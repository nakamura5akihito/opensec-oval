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
package io.opensec.oval.model.sc;

import io.opensec.oval.model.common.DatatypeEnumeration;



/**
 * The EntityItemEVRString type is extended by the entities of an individual item.
 * This type represents the epoch, version, and release fields as a single version string.
 * It has the form "EPOCH:VERSION-RELEASE".
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemEVRStringType
    extends EntityItemSimpleBaseType
{

    public static final DatatypeEnumeration  FIXED_DATATYPE = DatatypeEnumeration.EVR_STRING;
    //{required, fixed="evr_string"}



    /**
     * Constructor.
     */
    public EntityItemEVRStringType()
    {
    }


    public EntityItemEVRStringType(
                    final String content
                    )
    {
        super( content );
    }


//    public EntityItemEVRStringType(
//                    final String content,
//                    final StatusEnumeration status
//                    )
//    {
//        super( content, status );
//    }
//
//
//    public EntityItemEVRStringType(
//                    final String content,
//                    final DatatypeEnumeration datatype,
//                    final StatusEnumeration status
//                    )
//    {
//        super( content, datatype, status );
//    }



    //**************************************************************
    //  EntityItemBase
    //**************************************************************

    @Override
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        if (datatype != null  &&  datatype != FIXED_DATATYPE) {
            throw new IllegalArgumentException( "invalid datatype: " + datatype);
        }

        super.setDatatype( datatype );
    }


//    //{required}
//    @Override
//    public DatatypeEnumeration getDatatype()
//    {
//        return FIXED_DATATYPE;
//    }



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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityItemEVRStringType)) {
            return false;
        }

        return super.equals( obj );
    }

}
//
