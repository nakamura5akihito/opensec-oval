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

import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.Family;




/**
 *
 * @author	Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class DefinitionsComponent
    extends DefinitionsElement
{

    private String  comment;
    //{required:TestType}
    //{optional:ObjectType}
    //{optional:StateType}


    protected Family       _oval_family;
    protected ComponentType    _oval_component;



    /**
     * Constructor.
     */
    public DefinitionsComponent()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionsComponent(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public DefinitionsComponent(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version );
        setComment( comment );
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return comment;
    }


    public DefinitionsComponent comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }

}
//
