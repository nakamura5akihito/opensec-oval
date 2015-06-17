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
package io.opensec.oval.model.independent;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityObjectStringType;
import io.opensec.oval.model.definitions.Set;
import io.opensec.oval.model.definitions.SystemObjectType;

import java.util.ArrayList;
import java.util.Collection;



/**
 * The SQL object is used by a sql test to define the specific database
 * and query to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the sql57 object and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class SqlObject
    extends SystemObjectType
{
    // XSD model:
    // choice(
    //         set
    //         sequence(
    //                   engine
    //                   version
    //                   connection_string
    //                   sql
    //          )
    // )

    private Set  set;

    private EntityObjectEngineType  engine;
    //{1..1}

    private EntityObjectStringType  version;
    //{1..1}

    private EntityObjectStringType  connection_string;
    //{1..1}

    private EntityObjectStringType  sql;
    //{1..1}



    /**
     * Constructor.
     */
    public SqlObject()
    {
        this( null, 0 );
    }


    public SqlObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public SqlObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.sql;
        _oval_family = Family.INDEPENDENT;
        _oval_component = ComponentType.SQL;
    }



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
    public void setEngine(
                    final EntityObjectEngineType engine
                    )
    {
        this.engine = engine;
    }


    public EntityObjectEngineType getEngine()
    {
        return engine;
    }



    /**
     */
    public void setVersion(
                    final EntityObjectStringType version
                    )
    {
        this.version = version;
    }


    public EntityObjectStringType getVersion()
    {
        return version;
    }



    /**
     */
    public void setConnectionString(
                    final EntityObjectStringType connection_string
                    )
    {
        this.connection_string = connection_string;
    }


    public EntityObjectStringType getConnectionString()
    {
        return connection_string;
    }



    /**
     */
    public void setSql(
                    final EntityObjectStringType sql
                    )
    {
        this.sql = sql;
    }


    public EntityObjectStringType getSql()
    {
        return sql;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getEngine() );
        ref_list.add( getVersion() );
        ref_list.add( getConnectionString() );
        ref_list.add( getSql() );

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
        if (!(obj instanceof SqlObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sql_object[" + super.toString()
                        + ", set="              + getSet()
                        + ", engine="           + getEngine()
                        + ", version="          + getVersion()
                        + ", conection_string=" + getConnectionString()
                        + ", sql="              + getSql()
                       + "]";
    }

}
//SqlObject
