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
package io.opensec.oval.model.independent;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.common.CheckEnumeration;
import io.opensec.oval.model.definitions.TestType;



/**
 * The SQL test is used to check information stored in a database.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the sql57 test and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class SqlTest
    extends TestType
{

    /**
     * Constructor.
     */
    public SqlTest()
    {
        this( null, 0 );
    }


    public SqlTest(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null, null );
    }


    public SqlTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        super( id, version, comment, check );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.sql;
        _oval_family = Family.INDEPENDENT;
        _oval_component = ComponentType.SQL;
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
        if (!(obj instanceof SqlTest)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sql_test[" + super.toString() + "]";
    }

}
//SqlTest
