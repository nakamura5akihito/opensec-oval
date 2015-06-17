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
package io.opensec.oval.model.ios;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityStateStringType;
import io.opensec.oval.model.definitions.StateType;

import java.util.ArrayList;
import java.util.Collection;



/**
 * The global state defines the different information that can be found
 * in the ios config file under the global context.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class GlobalState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           global_command;



    /**
     * Constructor.
     */
    public GlobalState()
    {
        this( null, 0 );
    }


    public GlobalState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public GlobalState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_family = Family.IOS;
        _oval_component = ComponentType.GLOBAL;
    }




    /**
     */
    public void setGlobalCommand(
                    final EntityStateStringType global_command
                    )
    {
        this.global_command = global_command;
    }


    public EntityStateStringType getGlobalCommand()
    {
        return global_command;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getGlobalCommand() );

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
        if (!(obj instanceof GlobalState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "global_state[" + super.toString()
                        + ", global_command="  + getGlobalCommand()
                        + "]";
    }

}
//
