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

import io.opensec.oval.model.OvalEnumeration;



/**
 * This enumeration defines the different values that are valid
 * for the installation_status entity of a fix_state state.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum FixInstallationStatusEnumeration
    implements OvalEnumeration
{

    ALL_INSTALLED       ( "ALL_INSTALLED" ),
    SOME_INSTALLED      ( "SOME_INSTALLED" ),
    NONE_INSTALLED      ( "NONE_INSTALLED" ),
    NONE                ( "" );



    /**
     * A factory method.
     */
    public static FixInstallationStatusEnumeration fromValue(
                    final String value
                    )
    {
        for (FixInstallationStatusEnumeration  e : FixInstallationStatusEnumeration.values()) {
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
    FixInstallationStatusEnumeration(
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
//
