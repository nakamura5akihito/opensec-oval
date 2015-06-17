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
package io.opensec.oval.model.windows;

import io.opensec.oval.model.OvalEnumeration;



/**
 * The different values that are valid for the controls_accepted entity of a service.
 *
 * @author  Akihito Nakamura, AIST
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ServiceControlsAcceptedEnumeration
    implements OvalEnumeration
{

    SERVICE_ACCEPT_NETBINDCHANGE,
    SERVICE_ACCEPT_PARAMCHANGE,
    SERVICE_ACCEPT_PAUSE_CONTINUE,
    SERVICE_ACCEPT_PRESHUTDOWN,
    SERVICE_ACCEPT_SHUTDOWN,
    SERVICE_ACCEPT_STOP,
    SERVICE_ACCEPT_HARDWAREPROFILECHANGE,
    SERVICE_ACCEPT_POWEREVENT,
    SERVICE_ACCEPT_SESSIONCHANGE,
    SERVICE_ACCEPT_TIMECHANGE,
    SERVICE_ACCEPT_TRIGGEREVENT,
    NONE ( "" );



    /**
     * A factory method.
     */
    public static ServiceControlsAcceptedEnumeration fromValue(
                    final String value
                    )
    {
        for (ServiceControlsAcceptedEnumeration  e : ServiceControlsAcceptedEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    ServiceControlsAcceptedEnumeration()
    {
        value = name();
    }


    ServiceControlsAcceptedEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    public String value()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
//
