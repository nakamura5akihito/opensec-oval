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




/**
 *
 * @author	Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class StatusChange
    extends Event
{

    private DefinitionStatusEnumeration  status;



    /**
     * Constructor.
     */
    public StatusChange()
    {
    }


    public StatusChange(
                    final String date,
                    final DefinitionStatusEnumeration status
                    )
    {
        super( date );
        setStatus( status );
    }



    /**
     */
    public void setStatus(
                    final DefinitionStatusEnumeration status
                    )
    {
        this.status = status;
    }


    public DefinitionStatusEnumeration getStatus()
    {
        return status;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "status_change[date=" + getDate()
                        + ", status=" + getStatus()
                        + "]";
    }

}
// StatusChange
