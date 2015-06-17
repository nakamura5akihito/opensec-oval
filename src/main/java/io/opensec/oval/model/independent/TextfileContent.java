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

import io.opensec.oval.model.definitions.EntityMap;



/**
 * Experimental:
 * Is there any smart way to manage entities of OVAL Objects and States?
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextfileContent
{

    public enum Entity
    {
        FILEPATH,
        PATH,
        FILENAME,
        PATTERN,
        INSTANCE,
        TEXT,
        LINE,
        SUBEXPRESSION;
    }



    /**
     */
    public static EntityMap<TextfileContent.Entity> createEntityMap()
    {
        return (new EntityMap<TextfileContent.Entity>());
    }

}
//
