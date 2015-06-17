/**
 * Opensec OVAL - https://nakamura5akihito.github.io/
 * Copyright (C) 2015 Akihito Nakamura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opensec.oval.core.repository;

import io.opensec.oval.core.OpensecOvalContext;
import io.opensec.oval.core.model.EntityUtil;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.common.GeneratorType;
import io.opensec.oval.model.definitions.DefinitionType;
import io.opensec.oval.model.definitions.DefinitionsElement;
import io.opensec.oval.model.definitions.DefinitionsType;
import io.opensec.oval.model.definitions.OvalDefinitions;
import io.opensec.oval.repository.OvalRepository;
import io.opensec.util.IsoDate;
import io.opensec.util.config.ConfigurationException;
import io.opensec.util.repository.ObjectNotFoundException;
import io.opensec.util.repository.QueryParams;
import io.opensec.util.repository.QueryResults;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * OvalDefinitionsGenerator is an utility to generate OVAL Definitions document
 * in the OVAL repository.
 * There are two ways to specify which definitions must be included in documents;
 * OVAL ID list and query.
 *
 * @author	Akihito Nakamura
 */
public class OvalDefinitionsGenerator
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalDefinitionsGenerator.class );



    private static final String  _PRODUCT_VERSION_ = "1.0.0";
    private static final String  _PRODUCT_NAME_ = "cpe:/a:opensec:opensec-oval:" + _PRODUCT_VERSION_;


    private OpensecOvalContext  _context;
    private OvalRepository  _repository;



    /**
     * Constructor.
     */
    public OvalDefinitionsGenerator()
    {
        this( OpensecOvalContext.repository() );
    }


    public OvalDefinitionsGenerator(
                    final OpensecOvalContext context
                    )
    {
        setContext( context );
    }



    /**
     */
    public void setContext(
                    final OpensecOvalContext context
                    )
    {
        _context = context;
    }


    protected OpensecOvalContext _getContext()
    {
        if (_context == null) {
            throw new ConfigurationException();
        }

        return _context;
    }



    /**
     */
    public void setRepository(
                    final OvalRepository repository
                    )
    {
        _repository = repository;
    }


    protected OvalRepository _getRepository()
    {
        if (_repository == null) {
            _repository = _getContext().getRepository();
        }

        return _repository;
    }



    /**
     *
     * @param   params
     * @return
     *  the OvalDefinitions object ID.
     */
    public String generateByQuery(
                    final QueryParams params
                    )
    {
        QueryResults<DefinitionType>  results = _getRepository().findDefinition( params );
        Collection<DefinitionType>  def_list = results.getElements();

        DefinitionsType  defs = new DefinitionsType( def_list );
        OvalDefinitions  oval_defs = new OvalDefinitions();
        oval_defs.setDefinitions( defs );

        for (DefinitionType  def : def_list) {
            Collection<ElementRef>  ref_list = def.ovalGetElementRef();
            _addElements( oval_defs, ref_list );
        }

        String  schema_location = _getContext().getProperty( OpensecOvalContext.Xml.SCHEMA_LOCATION );
        oval_defs.setSchemaLocation( schema_location );
        oval_defs.setGenerator( _newGenerator() );
        String  id = _getRepository().saveOvalDefinitions( oval_defs );

        return id;
    }



    /**
     * Recursively called.
     */
    private void _addElements(
                    final OvalDefinitions oval_defs,
                    final Collection<ElementRef> ref_list
                    )
    {
        if (ref_list == null  ||  ref_list.size() == 0) {
            return;
        }

        for (ElementRef  ref : ref_list) {
            DefinitionsElement  element = _addElement( oval_defs, ref );
            if (element != null) {
                Collection<ElementRef>  next_ref_list = element.ovalGetElementRef();
                _addElements( oval_defs, next_ref_list );
            }
        }
    }



    /**
     */
    private DefinitionsElement _addElement(
                    final OvalDefinitions oval_defs,
                    final ElementRef ref
                    )
    {
        if (ref == null) {
            return null;
        }

        String  oval_id = ref.ovalGetRefId();
        _LOG_.debug( "candidate OVAL ID: " + oval_id );
        if (oval_id == null) {
            return null;
        }

        if (EntityUtil.containsElement( oval_defs, oval_id )) {
            _LOG_.debug( "element already contained: " + oval_id );
            return null;
        }

        DefinitionsElement  element = _getRepository().findElementById( oval_id );
        if (element == null) {
            throw new ObjectNotFoundException( "no such OVAL element in repository: " + oval_id );
        }

        EntityUtil.addElement( oval_defs, element );
        _LOG_.debug( "element added: " + oval_id );

        return element;
    }



    /**
     */
    protected GeneratorType _newGenerator()
    {
        return _newGenerator( new Date() );
    }


    protected GeneratorType _newGenerator(
                    final Date timestamp
                    )
    {
        String  schema_version = _getContext().getProperty( OpensecOvalContext.Xml.SCHEMA_VERSION );

        GeneratorType  generator = new GeneratorType();
        generator.setSchemaVersion(  schema_version );
        generator.setTimestamp(      IsoDate.format( timestamp ) );
        generator.setProductName(    _PRODUCT_NAME_ );
        generator.setProductVersion( _PRODUCT_VERSION_ );

        return generator;
    }




    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////



//    public static void main(
//                    final String[] args
//                    )
//    throws Exception
//    {
//        if (args.length == 0) {
//            System.out.println( "Usage: query [file_to_save]" );
//            System.exit( 1 );
//        }
//
//        QueryParams  params = parseQuery( args[0] );
//
//        final OvalDefinitionsGenerator  generator = new OvalDefinitionsGenerator();
//        String  doc_id = generator.generateByQuery_deprecated( params );
//        System.out.println( "OvalDefinitions document generated: ID=" + doc_id );
//
//        if (args.length > 1) {
//            String  filepath = args[1];
//            OvalDefinitions  doc = _getDatastore().findById( OvalDefinitions.class, doc_id );
//
//            System.out.println( "saving OvalDefinitions document...: file=" + filepath );
//            XmlMapper  xml_mapper = SixOvalContext.repository().getXmlMapper();
//            xml_mapper.marshal( doc, new FileWriter( new File( filepath ) ) );
//        }
//    }
//
//
//
//    public static QueryParams parseQuery( final String s )
//    {
//        String[]  key_values = s.split( "&" );
//        QueryParams  params = new QueryParams();
//        for (String  key_value : key_values) {
//            String[]  elements = key_value.split( "=" );
//            params.set( elements[0], elements[1] );
//        }
//
//        return params;
//    }

}
//
