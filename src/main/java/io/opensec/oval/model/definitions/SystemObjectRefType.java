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

import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.ElementType;
import io.opensec.oval.model.OvalObject;



/**
 * An Object reference to be used by OVAL Tests.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemObjectRefType
    implements ElementRef, OvalObject
//    implements Dependent<TestType>
{

    private String  object_ref;
    //{required}



    /**
     * Constructor.
     */
    public SystemObjectRefType()
    {
    }


    /**
     * Constructor.
     */
    public SystemObjectRefType(
                    final String object_ref
                    )
    {
        setObjectRef( object_ref );
    }



    /**
     */
    public void setObjectRef(
                    final String object_ref
                    )
    {
        this.object_ref = object_ref;
    }


    public String getObjectRef()
    {
        return object_ref;
    }



    //**************************************************************
    //  ElementRef
    //**************************************************************

    public String ovalGetRefId()
    {
        return getObjectRef();
    }



    public ElementType ovalGetRefType()
    {
        return ElementType.OBJECT;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private TestType  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final TestType master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public TestType getMasterObject()
//    {
//        return _master;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  id = getObjectRef();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ElementRef)) {
            return false;
        }

        SystemObjectRefType  other = (SystemObjectRefType)obj;
        String  other_id = other.getObjectRef();
        String   this_id =  this.getObjectRef();
        if (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return getObjectRef();
    }

}
//
