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
package io.opensec.oval.model.aix;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityStateVersionType;
import io.opensec.oval.model.definitions.StateType;

import java.util.ArrayList;
import java.util.Collection;



/**
 * The oslevel_state defines the information about maintenance level (system version).
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OsLevelState
    extends StateType
{

    //{0..1}
    private EntityStateVersionType  maintenance_level;



    /**
     * Constructor.
     */
    public OsLevelState()
    {
        this( null, 0 );
    }


    public OsLevelState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public OsLevelState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_family = Family.AIX;
        _oval_component = ComponentType.OSLEVEL;
    }



    /**
     */
    public void setMaintenanceLevel(
                    final EntityStateVersionType maintenance_level
                    )
    {
        this.maintenance_level = maintenance_level;
    }


    public EntityStateVersionType getMaintenanceLevel()
    {
        return maintenance_level;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getMaintenanceLevel() );

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
        if (!(obj instanceof OsLevelState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "oslevel_state[" + super.toString()
                        + ", maintenance_level="      + getMaintenanceLevel()
             + "]";
    }

}
//
