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
package io.opensec.oval.model.hpux;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.definitions.EntityStateStringType;
import io.opensec.oval.model.definitions.StateType;

import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.3:
 *             Replaced by the patch53 state and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class PatchState
    extends StateType
{

    //{0..1}
    private EntityStateStringType       patch_name;
    private EntityStateStringType       swtype;
    private EntityStateStringType       area_patched;
    private EntityStateStringType       patch_base;



    /**
     * Constructor.
     */
    public PatchState()
    {
        this( null, 0 );
    }


    public PatchState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public PatchState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_family = Family.HPUX;
        _oval_component = ComponentType.PATCH;
    }



    /**
     */
    public void setPatchName(
                    final EntityStateStringType patch_name
                    )
    {
        this.patch_name = patch_name;
    }


    public EntityStateStringType getPatchName()
    {
        return patch_name;
    }



    /**
     */
    public void setSwtype(
                    final EntityStateStringType swtype
                    )
    {
        this.swtype = swtype;
    }


    public EntityStateStringType getSwtype()
    {
        return swtype;
    }



    /**
     */
    public EntityStateStringType getAreaPatched()
    {
        return area_patched;
    }


    public void setAreaPatched(
                    final EntityStateStringType area_patched
                    )
    {
        this.area_patched = area_patched;
    }



    /**
     */
    public void setPatchBase(
                    final EntityStateStringType patch_base
                    )
    {
        this.patch_base = patch_base;
    }


    public EntityStateStringType getPatchBase()
    {
        return patch_base;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getPatchName() );
        ref_list.add( getSwtype() );
        ref_list.add( getAreaPatched() );
        ref_list.add( getPatchBase() );

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
        if (!(obj instanceof PatchState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "patch_state[" + super.toString()
                        + ", patch_name="   + getPatchName()
                        + ", swtype="       + getSwtype()
                        + ", area_patched=" + getAreaPatched()
                        + ", patch_base="   + getPatchBase()
             + "]";
    }

}
//
