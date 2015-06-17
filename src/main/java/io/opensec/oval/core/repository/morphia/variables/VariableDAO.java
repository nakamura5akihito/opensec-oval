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
package io.opensec.oval.core.repository.morphia.variables;

import io.opensec.oval.model.variables.VariableType;
import io.opensec.util.core.repository.morphia.BaseDAO;
import org.mongodb.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 */
public class VariableDAO
    extends BaseDAO<VariableType, String>
{

    /**
     */
    public VariableDAO(
                    final Datastore ds
                    )
    {
        super( VariableType.class, ds );
    }

}
//

