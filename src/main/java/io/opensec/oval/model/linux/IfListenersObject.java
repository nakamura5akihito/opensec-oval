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
package io.opensec.oval.model.linux;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityObjectStringType;
import io.opensec.oval.model.definitions.Filter;
import io.opensec.oval.model.definitions.Set;
import io.opensec.oval.model.definitions.SystemObjectType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The iflisteners_object element is used by an iflisteners_test
 * to define the specific interface to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class IfListenersObject
    extends SystemObjectType
{

    //TODO: XSD model.
	// choice(
	//    set
    //    sequence(
    //           name
    //           filter
    //   ))

    private Set  set;
    //{1..1}

    private EntityObjectStringType  interface_name;
    //{1..1}

    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public IfListenersObject()
    {
        this( null, 0 );
    }


    public IfListenersObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_family = Family.LINUX;
        _oval_component = ComponentType.IFLISTENERS;
    }


//    public FileObject(
//                    final String id,
//                    final int version,
//                    final String comment
//                    )
//    {
//        super( id, version, comment );
//    }
//
//
//    public FileObject(
//                    final String id,
//                    final int version,
//                    final String path,
//                    final String filename
//                    )
//    {
//        this( id, version,
//                        new EntityObjectStringType( path ),
//                        new EntityObjectStringType( filename )
//        );
//    }
//
//
//    public FileObject(
//                    final String id,
//                    final int version,
//                    final EntityObjectStringType path,
//                    final EntityObjectStringType filename
//                    )
//    {
//        super( id, version );
//        setPath( path );
//        setFilename( filename );
//    }



    /**
     */
    public void setSet(
                    final Set set
                    )
    {
        this.set = set;
    }


    public Set getSet()
    {
        return set;
    }



    /**
     */
    public void setInterfaceName(
                    final EntityObjectStringType interface_name
                    )
    {
        this.interface_name = interface_name;
    }


    public EntityObjectStringType getInterfaceName()
    {
        return interface_name;
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filters
                    )
    {
        if (filter != filters) {
            filter.clear();
            if (filters != null  &&  filters.size() > 0) {
                filter.addAll( filters );
            }
        }
    }


    public boolean addFilter(
                    final Filter filter
                    )
    {
        if (filter == null) {
            return false;
        }

        return this.filter.add( filter );
    }


    public Collection<Filter> getFilter()
    {
        return filter;
    }


    public Iterator<Filter> iterateFilter()
    {
        return filter.iterator();
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getInterfaceName() );
        ref_list.addAll( getFilter() );

        return ref_list;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }


    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof IfListenersObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "iflisteners_object[" + super.toString()
                        + ", set"       + getSet()
                        + ", interface_name="     + getInterfaceName()
                        + ", filter="   + getFilter()
                        + "]";
    }

}
//
