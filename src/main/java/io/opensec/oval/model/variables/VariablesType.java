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
package io.opensec.oval.model.variables;

import io.opensec.oval.model.Container;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.mongodb.morphia.annotations.Reference;



/**
 * The VariablesType is a container for one or more variables.
 *
 * <p>Constraints:
 * The id of each object is unique in this container.
 * </p>
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariablesType
    extends Container<VariableType> //{1..*}
{

    @Reference
    private final Collection<VariableType>  variable = new HashSet<VariableType>();



    /**
     * Constructor.
     */
    public VariablesType()
    {
    }


    public VariablesType(
                    final Collection<? extends VariableType> variable_list
                    )
    {
        _copy( variable, variable_list );
    }


    public VariablesType(
                    final VariableType[] variable_list
                    )
    {
        this( Arrays.asList( variable_list ) );
    }



    /**
     */
    public void setVariable(
                    final Collection<? extends VariableType> variable_list
                    )
    {
        reset( variable_list );
    }


    public void setVariable(
                    final VariableType[] variable_list
                    )
    {
        reset( variable_list );
    }


    public Collection<VariableType> getVariable()
    {
        return _getCollection();
    }


//    public boolean addVariable(
//                    final VariableType variable
//                    )
//    {
//        return add( variable );
//    }
//
//
//    public Iterator<VariableType> iterateVariable()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<VariableType> _getCollection()
    {
        return variable;
    }

}
//
