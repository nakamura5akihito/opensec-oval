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

import io.opensec.oval.model.OvalEnumeration;



/**
 * Defines the datatype of the value associated with a property list preference key.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum PlistTypeEnumeration
    implements OvalEnumeration
{

    CFSTRING        ( "CFString" ),
    CFNUMBER        ( "CFNumber" ),
    CFBOOLEAN       ( "CFBoolean" ),
    CFDATE          ( "CFDate" ),
    CFDATA          ( "CFData" ),
    CFARRAY         ( "CFArray" ),
    CFDICTIONARY    ( "CFDictionary" ),
    NONE            ( "" );



    /**
     * A factory method.
     */
    public static PlistTypeEnumeration fromValue(
                    final String value
                    )
    {
        for (PlistTypeEnumeration  e : PlistTypeEnumeration.values()) {
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
    PlistTypeEnumeration(
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
