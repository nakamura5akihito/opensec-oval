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




/**
 * The abstract Item holds information about a specific item on a system.
 * An item might be a file, a rpm, a process, etc.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
// NOTE: This class must be abstract and dependent.
// Castor fails to load polymorphic objects
// if the common abstract super class is mapped to a super table.
//public abstract class Item
public abstract class Item
    extends ItemType
{

    /**
     * Constructor.
     */
    public Item()
    {
    }


    public Item(
                    final int id
                    )
    {
        super( id );
    }


    public Item(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
    }

}
// Item
