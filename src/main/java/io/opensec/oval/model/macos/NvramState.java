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
package io.opensec.oval.model.macos;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityStateStringType;
import io.opensec.oval.model.definitions.StateType;

import java.util.ArrayList;
import java.util.Collection;



/**
 * This state pulls data from the 'nvram -p' output.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NvramState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   nvram_var;
    private EntityStateStringType   nvram_value;



    /**
     * Constructor.
     */
    public NvramState()
    {
        this( null, 0 );
    }


    public NvramState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public NvramState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_family = Family.MACOS;
        _oval_component = ComponentType.NVRAM;
    }



    /**
     */
    public void setNvramVar(
                    final EntityStateStringType nvram_var
                    )
    {
        this.nvram_var = nvram_var;
    }


    public EntityStateStringType getNvramVar()
    {
        return nvram_var;
    }



    /**
     */
    public void setNvramValue(
                    final EntityStateStringType nvram_value
                    )
    {
        this.nvram_value = nvram_value;
    }


    public EntityStateStringType getNvramValue()
    {
        return nvram_value;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getNvramVar() );
        ref_list.add( getNvramValue() );

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
        if (!(obj instanceof NvramState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "nvram_state[" + super.toString()
             + ", nvram_var="   + getNvramVar()
             + ", nvram_value=" + getNvramValue()
             + "]";
    }

}
//
