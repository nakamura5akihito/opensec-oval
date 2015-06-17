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
package io.opensec.oval.model.common;

import io.opensec.oval.model.OvalEnumeration;



/**
 * The RecurseEnumeration defines how to recurse into the path entity,
 * in other words what to follow during recursion.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum RecurseEnumeration
    implements OvalEnumeration
{

    NONE                     ( "none" ),
    FILES                    ( "files" ),
    DIRECTORIES              ( "directories" ),
    FILES_AND_DIRECTORIES    ( "files and directories" ),
    SYMLINKS                 ( "symlinks" ),
    SYMLINKS_AND_DIRECTORIES ( "symlinks and directories" );



    /**
     * A factory method.
     */
    public static RecurseEnumeration fromValue(
                    final String value
                    )
    {
        for (RecurseEnumeration  e : RecurseEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    RecurseEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    public String value()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
// RecurseEnumeration
