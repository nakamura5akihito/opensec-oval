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
package io.opensec.oval.model.linux;

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.common.CheckEnumeration;
import io.opensec.oval.model.definitions.StateRefType;
import io.opensec.oval.model.definitions.SystemObjectRefType;
import io.opensec.oval.model.definitions.TestType;



/**
 * The rpmverifypackage_test is used to verify the integrity of installed RPMs.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyPackageTest
    extends TestType
{

    /**
     * Constructor.
     */
    public RpmVerifyPackageTest()
    {
        this( null, 0 );
    }


    public RpmVerifyPackageTest(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null, null );
    }


    public RpmVerifyPackageTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        this( id, version, comment, check, null, null );
    }


    public RpmVerifyPackageTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check,
                    final SystemObjectRefType object,
                    final StateRefType[] stateList
                    )
    {
        super( id, version, comment, check, object, stateList );

        _oval_family = Family.LINUX;
        _oval_component = ComponentType.RPMVERIFYPACKAGE;
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
        if (!(obj instanceof RpmVerifyPackageTest)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpmverifypackage_test[" + super.toString() + "]";
    }

}
//
