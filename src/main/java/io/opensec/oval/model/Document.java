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
package io.opensec.oval.model;

import io.opensec.util.persist.Persistable;
import org.mongodb.morphia.annotations.Id;




/**
 * The abstract superclass of the OVAL documents.
 *
 * @author	Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class Document
    implements OvalObject, Persistable<String>
{

    //MongoDB
    @Id
    private String  _id;


    private String  schemaLocation;



    /**
     * Constructor.
     */
    public Document()
    {
    }



    /*
     * IMPLEMENTATION NOTE:
     * This implementation of the schemaLocation property is a dirty hack.
     * Because the Spring OXM support for Castor does NOT provide the property.
     */

    /**
     */
    public void setSchemaLocation(
                    final String schemaLocation
                    )
    {
        this.schemaLocation = schemaLocation;
    }


    public String getSchemaLocation()
    {
        return schemaLocation;
    }



    //**************************************************************
    //  MongoDB/Morphia Lifecycle
    //**************************************************************

//    @SuppressWarnings( "unused" )
//    @PrePersist
//    private void _assignPersistentID()
//    {
//        String  pid = getPersistentID();
//        if (pid == null) {
//            pid = UUID.randomUUID().toString();
//            setPersistentID( pid );
//        }
//    }



    //*********************************************************************
    //  implements Persistable
    //*********************************************************************

//    @Override
//    public synchronized String getPersistentID()
//    {
//        String  pid = super.getPersistentID();
//        if (pid == null) {
//            pid = UUID.randomUUID().toString();
//            setPersistentID( pid );
//        }
//
//        return pid;
//    }


    @Override
    public void setPersistentID(
                    final String pid
                    )
    {
        _id = pid;
    }


    @Override
    public String getPersistentID()
    {
        return _id;
    }

}
//
