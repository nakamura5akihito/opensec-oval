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
package io.opensec.oval.model;



/**
 * The OVAL element type enumeration.
 * The types are definition, test, object, state, and variable.
 *
 * @author	Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ElementType
    implements OvalEnumeration
{

    DEFINITION ( "definition" ),
    TEST       ( "test"       ),
    OBJECT     ( "object"     ),
    STATE      ( "state"      ),
    VARIABLE   ( "variable"   );



    ///////////////////////////////////////////////////////////////////////

    /**
     * A factory method.
     */
    public static ElementType fromValue(
                    final String value
                    )
    {
        for (ElementType  e : ElementType.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value;


    /**
     * Constructor.
     */
    ElementType(
                    final String type
                    )
    {
        value = type;
    }



    //*********************************************************************
    //  OvalEnumeration
    //*********************************************************************

    public String value()
    {
        return value;
    }



    //*********************************************************************
    //  java.lang.Object
    //*********************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
//
