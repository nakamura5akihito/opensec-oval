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
package io.opensec.oval.model.definitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The count function takes one or more components and returns the count of all of 
 * the values represented by the components.
 *
 * @author	Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CountFunctionType
    extends FunctionGroup
{

    private final Collection<ComponentGroup>  component =
        new ArrayList<ComponentGroup>();
    //{1..*}



    /**
     * Constructor.
     */
    public CountFunctionType()
    {
    }



    /**
     */
    public void setComponent(
                    final Collection<? extends ComponentGroup> components
                    )
    {
        if (components != component) {
            component.clear();
            if (components != null  &&  components.size() > 0) {
                this.component.addAll( components );
            }
        }
    }


    public boolean addComponent(
                    final ComponentGroup component
                    )
    {
        if (component == null) {
            return false;
        }

        return this.component.add( component );
    }


    public Collection<ComponentGroup> getComponent()
    {
        return component;
    }


    public Iterator<ComponentGroup> iterateComponent()
    {
        return component.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "count[" + getComponent() + "]";
    }

}
//
