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
package io.opensec.oval.model.mitre;

import io.opensec.oval.model.common.GeneratorInformation;



/**
 * An additional generator information from Mitre.
 * This is not part of the official OVAL Schema.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Vendor
    extends GeneratorInformation
{

    private String  _name;
    //{xsd:string}



    /**
     * Constructor.
     */
    public Vendor()
    {
    }



    /**
     */
    public void setName(
                    final String name
                    )
    {
        _name = name;
    }


    public String getName()
    {
        return _name;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "vendor[" + getName() + "]";
    }

}
// Vendor