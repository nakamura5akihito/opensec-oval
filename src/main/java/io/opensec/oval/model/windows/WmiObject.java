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
package io.opensec.oval.model.windows;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityObjectStringType;
import io.opensec.oval.model.definitions.Set;
import io.opensec.oval.model.definitions.SystemObjectType;

import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the wmi57 object and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class WmiObject
    extends SystemObjectType
{

    // XSD model:
    // choice(
    //         oval-def:set
    //         sequence(
    //                   namespace
    //                   wql
    //         )
    // )

    private Set  set;
    //{1..1}


    private EntityObjectStringType  namespace;
    //{1..1}

    private EntityObjectStringType  wql;
    //{1..1}


//    private final EntityPropertyMap<WmiProperty>  _properties =
//        WmiProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public WmiObject()
    {
        this( null, 0 );
    }


    public WmiObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version,
                        (EntityObjectStringType)null,
                        (EntityObjectStringType)null
                        );
    }


    public WmiObject(
                    final String id,
                    final int version,
                    final String namespace,
                    final String wql
                    )
    {
        this( id, version,
                        (namespace == null ? null : (new EntityObjectStringType( namespace ))),
                        (wql == null ? null : (new EntityObjectStringType( wql )))
        );
    }


    public WmiObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType namespace,
                    final EntityObjectStringType wql
                    )
    {
        super( id, version );

        setNamespace( namespace );
        setWql( wql );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.wmi;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.WMI;
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
    public void setNamespace(
                    final EntityObjectStringType namespace
                    )
    {
        this.namespace = namespace;
//        _properties.setProperty( WmiProperty.NAMESPACE, namespace );
    }


    public EntityObjectStringType getNamespace()
    {
        return namespace;
//        return _properties.getProperty(
//                        WmiProperty.NAMESPACE, EntityObjectStringType.class );
    }



    /**
     */
    public void setWql(
                    final EntityObjectStringType wql
                    )
    {
        this.wql = wql;
//        _properties.setProperty( WmiProperty.WQL, wql );
    }


    public EntityObjectStringType getWql()
    {
        return wql;
//        return _properties.getProperty(
//                        WmiProperty.WQL, EntityObjectStringType.class );
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getNamespace() );
        ref_list.add( getWql() );

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
        if (!(obj instanceof WmiObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi_object[" + super.toString()
                        + ", set=" + getSet()
                        + ", " + getNamespace()
                        + ", " + getWql()
//                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// WmiObject