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

import io.opensec.oval.model.ElementRef;
import io.opensec.oval.model.ElementType;
import io.opensec.oval.model.sc.EntityItemStringType;



/**
 * The EntityItemVariableRefType defines a string item entity
 * that has a valid OVAL variable id as the value.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemVariableRefType
    extends EntityItemStringType
    implements ElementRef
{

    /**
     * Constructor.
     */
    public EntityItemVariableRefType()
    {
    }


    public EntityItemVariableRefType(
                    final String content
                    )
    {
        super( content );
    }



    //**************************************************************
    //  EntityItemBase
    //**************************************************************

//    @Override
//    public void setContent(
//                    final String content
//                    )
//    {
//        if (content != null) {
//            //validation
//            //TODO: some validation code.
//        }
//
//        super.setContent( content );
//    }



    //*********************************************************************
    //  ElementRef
    //*********************************************************************

    public String ovalGetRefId()
    {
        String  var_id = getContent();

        return var_id;
    }



    public ElementType ovalGetRefType()
    {
        return ElementType.VARIABLE;
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityItemVariableRefType)) {
            return false;
        }

        return super.equals( obj );
    }

}
//EntityItemVariableRefType
