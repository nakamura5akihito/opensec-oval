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
package io.opensec.oval.core.repository.morphia;

import io.opensec.oval.core.model.OvalEnumerationHelper;
import io.opensec.oval.model.ComponentType;
import io.opensec.oval.model.ElementType;
import io.opensec.oval.model.Family;
import io.opensec.oval.model.OvalEnumeration;
import io.opensec.oval.model.aix.FilesetStateEnumeration;
import io.opensec.oval.model.aix.FixInstallationStatusEnumeration;
import io.opensec.oval.model.aix.InterimFixStateEnumeration;
import io.opensec.oval.model.common.CheckEnumeration;
import io.opensec.oval.model.common.ClassEnumeration;
import io.opensec.oval.model.common.DatatypeEnumeration;
import io.opensec.oval.model.common.ExistenceEnumeration;
import io.opensec.oval.model.common.FamilyEnumeration;
import io.opensec.oval.model.common.MessageLevelEnumeration;
import io.opensec.oval.model.common.OperationEnumeration;
import io.opensec.oval.model.common.OperatorEnumeration;
import io.opensec.oval.model.common.RecurseDirectionEnumeration;
import io.opensec.oval.model.common.RecurseEnumeration;
import io.opensec.oval.model.common.RecurseFileSystemEnumeration;
import io.opensec.oval.model.common.WindowsViewEnumeration;
import io.opensec.oval.model.definitions.ArithmeticEnumeration;
import io.opensec.oval.model.definitions.DateTimeFormatEnumeration;
import io.opensec.oval.model.definitions.FilterActionEnumeration;
import io.opensec.oval.model.definitions.SetOperatorEnumeration;
import io.opensec.oval.model.independent.EngineEnumeration;
import io.opensec.oval.model.independent.HashTypeEnumeration;
import io.opensec.oval.model.independent.LdapBehaviorsEnumeration;
import io.opensec.oval.model.independent.LdaptypeEnumeration;
import io.opensec.oval.model.linux.RpmVerifyResultEnumeration;
import io.opensec.oval.model.macos.PlistTypeEnumeration;
import io.opensec.oval.model.mitre.DefinitionStatusEnumeration;
import io.opensec.oval.model.redhat.SeverityEnumeration;
import io.opensec.oval.model.results.ContentEnumeration;
import io.opensec.oval.model.results.ResultEnumeration;
import io.opensec.oval.model.sc.FlagEnumeration;
import io.opensec.oval.model.sc.StatusEnumeration;
import io.opensec.oval.model.solaris.SmfProtocolEnumeration;
import io.opensec.oval.model.solaris.SmfServiceStateEnumeration;
import io.opensec.oval.model.unix.CapabilityEnumeration;
import io.opensec.oval.model.unix.EncryptMethodEnumeration;
import io.opensec.oval.model.unix.EndpointEnumeration;
import io.opensec.oval.model.unix.GconfTypeEnumeration;
import io.opensec.oval.model.unix.InterfaceEnumeration;
import io.opensec.oval.model.unix.RoutingTableFlagsEnumeration;
import io.opensec.oval.model.unix.WaitStatusEnumeration;
import io.opensec.oval.model.unix.XinetdTypeStatusEnumeration;
import io.opensec.oval.model.windows.AddrTypeEnumeration;
import io.opensec.oval.model.windows.AdstypeEnumeration;
import io.opensec.oval.model.windows.AuditEnumeration;
import io.opensec.oval.model.windows.CmdletVerbEnumeration;
import io.opensec.oval.model.windows.DriveTypeEnumeration;
import io.opensec.oval.model.windows.FileTypeEnumeration;
import io.opensec.oval.model.windows.InterfaceTypeEnumeration;
import io.opensec.oval.model.windows.NamingContextEnumeration;
import io.opensec.oval.model.windows.PeSubsystemEnumeration;
import io.opensec.oval.model.windows.PeTargetMachineEnumeration;
import io.opensec.oval.model.windows.RegistryHiveEnumeration;
import io.opensec.oval.model.windows.RegistryTypeEnumeration;
import io.opensec.oval.model.windows.ServiceControlsAcceptedEnumeration;
import io.opensec.oval.model.windows.ServiceCurrentStateEnumeration;
import io.opensec.oval.model.windows.ServiceStartTypeEnumeration;
import io.opensec.oval.model.windows.ServiceTypeEnumeration;
import io.opensec.oval.model.windows.SharedResourceTypeEnumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mongodb.morphia.converters.SimpleValueConverter;
import org.mongodb.morphia.converters.TypeConverter;
import org.mongodb.morphia.mapping.MappedField;
import org.mongodb.morphia.mapping.MappingException;



/**
 * Morphia type converter for the OVAL model objects.
 *
 * @author  Akihito Nakamura, AIST
 */
public class OvalConverter
    extends TypeConverter
    implements SimpleValueConverter
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalConverter.class );



    private static final Class<?>[]  _SUPPORTED_CLASSES_ = new Class[] {
        // opensec //
        ComponentType.class,
        ElementType.class,
        Family.class,
//      Platform.class,
//      Product.class

        // aix //
        FilesetStateEnumeration.class,
        FixInstallationStatusEnumeration.class,
        InterimFixStateEnumeration.class,

        // common //
        CheckEnumeration.class,
        ClassEnumeration.class,
        DatatypeEnumeration.class,
        ExistenceEnumeration.class,
        FamilyEnumeration.class,
        MessageLevelEnumeration.class,
        OperationEnumeration.class,
        OperatorEnumeration.class,
        RecurseDirectionEnumeration.class,
        RecurseEnumeration.class,
        RecurseFileSystemEnumeration.class,
        WindowsViewEnumeration.class,

        // definitions //
        ArithmeticEnumeration.class,
        DateTimeFormatEnumeration.class,
        FilterActionEnumeration.class,
        SetOperatorEnumeration.class,

        // independent //
        EngineEnumeration.class,
        HashTypeEnumeration.class,
        LdapBehaviorsEnumeration.class,
        LdaptypeEnumeration.class,

        // linux //
        io.opensec.oval.model.linux.ProtocolEnumeration.class,
        RpmVerifyResultEnumeration.class,

        // macos //
        io.opensec.oval.model.macos.PermissionCompareEnumeration.class,
        PlistTypeEnumeration.class,

        // mitre //
        DefinitionStatusEnumeration.class,

        // redhat //
        SeverityEnumeration.class,

        // results
        ContentEnumeration.class,
        ResultEnumeration.class,

        // sc //
        FlagEnumeration.class,
        StatusEnumeration.class,

        // solaris //
        io.opensec.oval.model.solaris.PermissionCompareEnumeration.class,
        SmfProtocolEnumeration.class,
        SmfServiceStateEnumeration.class,

        // unix //
        CapabilityEnumeration.class,
        EncryptMethodEnumeration.class,
        EndpointEnumeration.class,
        GconfTypeEnumeration.class,
        InterfaceEnumeration.class,
        RoutingTableFlagsEnumeration.class,
        WaitStatusEnumeration.class,
        XinetdTypeStatusEnumeration.class,

        //windows
        AddrTypeEnumeration.class,
        AdstypeEnumeration.class,
        AuditEnumeration.class,
        CmdletVerbEnumeration.class,
        DriveTypeEnumeration.class,
        FileTypeEnumeration.class,
        InterfaceTypeEnumeration.class,
        NamingContextEnumeration.class,
        PeSubsystemEnumeration.class,
        PeTargetMachineEnumeration.class,
        io.opensec.oval.model.windows.ProtocolEnumeration.class,
        RegistryHiveEnumeration.class,
        RegistryTypeEnumeration.class,
        ServiceControlsAcceptedEnumeration.class,
        ServiceCurrentStateEnumeration.class,
        ServiceStartTypeEnumeration.class,
        ServiceTypeEnumeration.class,
        SharedResourceTypeEnumeration.class
    };



    /**
     * Constructor.
     */
    public OvalConverter()
    {
        super( _SUPPORTED_CLASSES_ );
    }



    //*********************************************************************
    //  TypeConverter
    //*********************************************************************

    // Object (Java) --> simple value (Mongo)
    @Override
    public Object encode(
                    final Object object,
                    final MappedField optionalExtraInfo
                    )
    {
        if (object == null) {
            return null;
        }

        if (object instanceof OvalEnumeration) {
            return OvalEnumeration.class.cast( object ).value();
//        } else if (object instanceof NameEntity) {
//            return NameEntity.class.cast( object ).getName();
        }

        throw new MappingException( "unsupported type: "
                        + String.valueOf( object.getClass() ) );
    }



    // simple value (Mongo) --> Object (Java)
    @Override
    public Object decode(
                    @SuppressWarnings( "rawtypes" ) final Class targetClass,
                    final Object fromDBObject,
                    final MappedField optionalExtraInfo
                    )
    {
        _LOG_.trace( "target class: " + targetClass );
        if (fromDBObject == null) {
            return null;
        }

        if (OvalEnumeration.class.isAssignableFrom( targetClass )) {
            @SuppressWarnings( "unchecked" )
            Class<? extends OvalEnumeration>  enumClass =
                targetClass.asSubclass( OvalEnumeration.class );
            return OvalEnumerationHelper.fromValue( enumClass, fromDBObject.toString() );

//        } else if (NameEntity.class.isAssignableFrom( targetClass )) {
//            @SuppressWarnings( "unchecked" )
//            Class<? extends NameEntity>  nameClass =
//                targetClass.asSubclass( NameEntity.class );
//            return nameFromValue( nameClass, fromDBObject.toString() );
        }

        throw new MappingException( "unsupported type: "
                        + String.valueOf( targetClass ) );
    }



//  //**************************************************************
//  //  supporting NameEntity
//  //**************************************************************
//
//  /**
//   */
//  public static Object nameFromValue(
//                  final Class<? extends NameEntity> targetClass,
//                  final String name
//                  )
//  {
//      NameEntity  obj = null;
//
//      try {
//          obj = targetClass.newInstance();
//      } catch (Exception ex) {
//          _LOG_.error( ex.getMessage() );
//          throw new MappingException( ex.getMessage() );
//      }
//
//      obj.setName( name );
//      return obj;
//  }

}
//

