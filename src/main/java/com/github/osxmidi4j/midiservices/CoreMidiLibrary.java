//
// Copyright (c) 2013 All Right Reserved, Pascal Collberg
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
//
package com.github.osxmidi4j.midiservices;

import java.nio.IntBuffer;

import org.rococoa.ID;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * JNA Wrapper for library <b>CoreMidi Framework</b><br>
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a
 * href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few
 * opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a
 * href="http://rococoa.dev.java.net/">Rococoa</a>, or <a
 * href="http://jna.dev.java.net/">JNA</a>.
 */
// CHECKSTYLE:OFF *
public interface CoreMidiLibrary extends Library {
    String JNA_LIBRARY_NAME =
            "/System/Library/Frameworks/CoreMIDI.framework/CoreMIDI";
    NativeLibrary JNA_NATIVE_LIB = NativeLibrary
            .getInstance(CoreMidiLibrary.JNA_LIBRARY_NAME);
    CoreMidiLibrary INSTANCE = (CoreMidiLibrary) Native.loadLibrary(
            CoreMidiLibrary.JNA_LIBRARY_NAME, CoreMidiLibrary.class);

    int kMIDIInvalidClient = (int) -10830;
    int kMIDIInvalidPort = (int) -10831;
    int kMIDIWrongEndpointType = (int) -10832;
    int kMIDINoConnection = (int) -10833;
    int kMIDIUnknownEndpoint = (int) -10834;
    int kMIDIUnknownProperty = (int) -10835;
    int kMIDIWrongPropertyType = (int) -10836;
    int kMIDINoCurrentSetup = (int) -10837;
    int kMIDIMessageSendErr = (int) -10838;
    int kMIDIServerStartErr = (int) -10839;
    int kMIDISetupFormatErr = (int) -10840;
    int kMIDIWrongThread = (int) -10841;
    int kMIDIObjectNotFound = (int) -10842;
    int kMIDIIDNotUnique = (int) -10843;
    int kMIDIObjectType_Other = (int) -1;
    int kMIDIObjectType_Device = (int) 0;
    int kMIDIObjectType_Entity = (int) 1;
    int kMIDIObjectType_Source = (int) 2;
    int kMIDIObjectType_Destination = (int) 3;
    int kMIDIObjectType_ExternalMask = (int) 16;
    int kMIDIObjectType_ExternalDevice =
            (int) ((int) CoreMidiLibrary.kMIDIObjectType_ExternalMask | (int) CoreMidiLibrary.kMIDIObjectType_Device);
    int kMIDIObjectType_ExternalEntity =
            (int) ((int) CoreMidiLibrary.kMIDIObjectType_ExternalMask | (int) CoreMidiLibrary.kMIDIObjectType_Entity);
    int kMIDIObjectType_ExternalSource =
            (int) ((int) CoreMidiLibrary.kMIDIObjectType_ExternalMask | (int) CoreMidiLibrary.kMIDIObjectType_Source);
    int kMIDIObjectType_ExternalDestination =
            (int) ((int) CoreMidiLibrary.kMIDIObjectType_ExternalMask | (int) CoreMidiLibrary.kMIDIObjectType_Destination);
    int kMIDIInvalidUniqueID = (int) 0;
    int kMIDIMsgSetupChanged = (int) 1;
    int kMIDIMsgObjectAdded = (int) 2;
    int kMIDIMsgObjectRemoved = (int) 3;
    int kMIDIMsgPropertyChanged = (int) 4;
    int kMIDIMsgThruConnectionsChanged = (int) 5;
    int kMIDIMsgSerialPortOwnerChanged = (int) 6;
    int kMIDIMsgIOError = (int) 7;

    public interface MIDINotifyProc extends Callback {
        void apply(MIDINotification message, Pointer refCon);
    };

    public interface MIDIReadProc extends Callback {
        void apply(MIDIPacketList pktlist, Pointer readProcRefCon,
                Pointer srcConnRefCon);
    };

    public interface MIDICompletionProc extends Callback {
        void apply(Pointer request);
    };

    int MIDIClientCreate(ID name, CoreMidiLibrary.MIDINotifyProc notifyProc,
            Pointer notifyRefCon, NativeLongByReference outClient);

    int MIDIClientDispose(NativeLong client);

    int MIDIInputPortCreate(NativeLong client, ID portName,
            CoreMidiLibrary.MIDIReadProc readProc, Pointer refCon,
            NativeLongByReference outPort);

    int MIDIOutputPortCreate(NativeLong client, ID portName,
            NativeLongByReference outPort);

    int MIDIPortDispose(NativeLong port);

    int MIDIPortConnectSource(NativeLong port, NativeLong source,
            Pointer connRefCon);

    int MIDIPortDisconnectSource(NativeLong port, NativeLong source);

    NativeLong MIDIGetNumberOfDevices();

    NativeLong MIDIGetDevice(NativeLong deviceIndex0);

    NativeLong MIDIDeviceGetNumberOfEntities(NativeLong device);

    NativeLong MIDIDeviceGetEntity(NativeLong device, NativeLong entityIndex0);

    NativeLong MIDIEntityGetNumberOfSources(NativeLong entity);

    NativeLong MIDIEntityGetSource(NativeLong entity, NativeLong sourceIndex0);

    NativeLong MIDIEntityGetNumberOfDestinations(NativeLong entity);

    NativeLong MIDIEntityGetDestination(NativeLong entity, NativeLong destIndex0);

    int MIDIEntityGetDevice(NativeLong inEntity, NativeLongByReference outDevice);

    NativeLong MIDIGetNumberOfSources();

    NativeLong MIDIGetSource(NativeLong sourceIndex0);

    NativeLong MIDIGetNumberOfDestinations();

    NativeLong MIDIGetDestination(NativeLong destIndex0);

    int MIDIEndpointGetEntity(NativeLong inEndpoint,
            NativeLongByReference outEntity);

    int MIDIDestinationCreate(NativeLong client, ID name,
            CoreMidiLibrary.MIDIReadProc readProc, Pointer refCon,
            NativeLongByReference outDest);

    int MIDISourceCreate(NativeLong client, ID name,
            NativeLongByReference outSrc);

    int MIDIEndpointDispose(NativeLong endpt);

    NativeLong MIDIGetNumberOfExternalDevices();

    NativeLong MIDIGetExternalDevice(NativeLong deviceIndex0);

    int MIDIObjectGetIntegerProperty(long obj, ID propertyID,
            IntBuffer intBuffer);

    int MIDIObjectSetIntegerProperty(long obj, ID propertyID, int value);

    int MIDIObjectGetStringProperty(long obj, ID propertyID,
            PointerByReference reference);

    int MIDIObjectSetStringProperty(long obj, ID propertyID, ID str);

    int MIDIObjectGetDataProperty(long obj, ID propertyID,
            CoreMidiLibrary.CFDataRef outData);

    int MIDIObjectSetDataProperty(long obj, ID propertyID,
            CoreMidiLibrary.CFDataRef data);

    int MIDIObjectGetDictionaryProperty(long obj, ID propertyID,
            CoreMidiLibrary.CFDictionaryRef outDict);

    int MIDIObjectSetDictionaryProperty(long obj, ID propertyID,
            CoreMidiLibrary.CFDictionaryRef data);

    int MIDIObjectGetProperties(long obj, Pointer outProperties, byte deep);

    int MIDIObjectRemoveProperty(long obj, ID propertyID);

    int MIDIObjectFindByUniqueID(int inUniqueID, Pointer outObject,
            IntBuffer outObjectType);

    int MIDISend(NativeLong port, NativeLong dest, Pointer memory);

    int MIDISendSysex(Pointer pointer);

    int MIDIReceived(NativeLong src, MIDIPacketList pktlist);

    int MIDIFlushOutput(NativeLong dest);

    int MIDIRestart();

    Pointer MIDIPacketListInit(Pointer pointer);

    Pointer MIDIPacketListAdd(Pointer pointer, NativeLong listSize,
            Pointer curPacket, long time, NativeLong nData, byte data[]);

    String kMIDIPropertyName = "kMIDIPropertyName";

    String kMIDIPropertyManufacturer = "kMIDIPropertyManufacturer";

    String kMIDIPropertyModel = "kMIDIPropertyModel";

    String kMIDIPropertyUniqueID = "kMIDIPropertyUniqueID";

    String kMIDIPropertyDeviceID = "kMIDIPropertyDeviceID";

    String kMIDIPropertyReceiveChannels = "kMIDIPropertyReceiveChannels";

    String kMIDIPropertyTransmitChannels = "kMIDIPropertyTransmitChannels";

    String kMIDIPropertyMaxSysExSpeed = "kMIDIPropertyMaxSysExSpeed";

    String kMIDIPropertyAdvanceScheduleTimeMuSec =
            "kMIDIPropertyAdvanceScheduleTimeMuSec";

    String kMIDIPropertyIsEmbeddedEntity = "kMIDIPropertyIsEmbeddedEntity";

    String kMIDIPropertyIsBroadcast = "kMIDIPropertyIsBroadcast";

    String kMIDIPropertySingleRealtimeEntity =
            "kMIDIPropertySingleRealtimeEntity";

    String kMIDIPropertyConnectionUniqueID = "kMIDIPropertyConnectionUniqueID";

    String kMIDIPropertyOffline = "kMIDIPropertyOffline";

    String kMIDIPropertyPrivate = "kMIDIPropertyPrivate";

    String kMIDIPropertyDriverOwner = "kMIDIPropertyDriverOwner";

    String kMIDIPropertyFactoryPatchNameFile =
            "kMIDIPropertyFactoryPatchNameFile";

    String kMIDIPropertyUserPatchNameFile = "kMIDIPropertyUserPatchNameFile";

    String kMIDIPropertyNameConfiguration = "kMIDIPropertyNameConfiguration";

    String kMIDIPropertyImage = "kMIDIPropertyImage";

    String kMIDIPropertyDriverVersion = "kMIDIPropertyDriverVersion";

    String kMIDIPropertySupportsGeneralMIDI =
            "kMIDIPropertySupportsGeneralMIDI";

    String kMIDIPropertySupportsMMC = "kMIDIPropertySupportsMMC";

    String kMIDIPropertyCanRoute = "kMIDIPropertyCanRoute";

    String kMIDIPropertyReceivesClock = "kMIDIPropertyReceivesClock";

    String kMIDIPropertyReceivesMTC = "kMIDIPropertyReceivesMTC";

    String kMIDIPropertyReceivesNotes = "kMIDIPropertyReceivesNotes";

    String kMIDIPropertyReceivesProgramChanges =
            "kMIDIPropertyReceivesProgramChanges";

    String kMIDIPropertyReceivesBankSelectMSB =
            "kMIDIPropertyReceivesBankSelectMSB";

    String kMIDIPropertyReceivesBankSelectLSB =
            "kMIDIPropertyReceivesBankSelectLSB";

    String kMIDIPropertyTransmitsClock = "kMIDIPropertyTransmitsClock";

    String kMIDIPropertyTransmitsMTC = "kMIDIPropertyTransmitsMTC";

    String kMIDIPropertyTransmitsNotes = "kMIDIPropertyTransmitsNotes";

    String kMIDIPropertyTransmitsProgramChanges =
            "kMIDIPropertyTransmitsProgramChanges";

    String kMIDIPropertyTransmitsBankSelectMSB =
            "kMIDIPropertyTransmitsBankSelectMSB";

    String kMIDIPropertyTransmitsBankSelectLSB =
            "kMIDIPropertyTransmitsBankSelectLSB";

    String kMIDIPropertyPanDisruptsStereo = "kMIDIPropertyPanDisruptsStereo";

    String kMIDIPropertyIsSampler = "kMIDIPropertyIsSampler";

    String kMIDIPropertyIsDrumMachine = "kMIDIPropertyIsDrumMachine";

    String kMIDIPropertyIsMixer = "kMIDIPropertyIsMixer";

    String kMIDIPropertyIsEffectUnit = "kMIDIPropertyIsEffectUnit";

    String kMIDIPropertyMaxReceiveChannels = "kMIDIPropertyMaxReceiveChannels";

    String kMIDIPropertyMaxTransmitChannels =
            "kMIDIPropertyMaxTransmitChannels";

    String kMIDIPropertyDriverDeviceEditorApp =
            "kMIDIPropertyDriverDeviceEditorApp";

    String kMIDIPropertySupportsShowControl =
            "kMIDIPropertySupportsShowControl";

    String kMIDIPropertyDisplayName = "kMIDIPropertyDisplayName";

    // / Pointer to unknown (opaque) type
    // / Pointer to unknown (opaque) type
    public static class CFDictionaryRef extends PointerType {
        public CFDictionaryRef(Pointer address) {
            super(address);
        }

        public CFDictionaryRef() {
            super();
        }
    };

    // / Pointer to unknown (opaque) type
    // / Pointer to unknown (opaque) type
    public static class CFDataRef extends PointerType {
        public CFDataRef(Pointer address) {
            super(address);
        }

        public CFDataRef() {
            super();
        }
    };

    // / Pointer to unknown (opaque) type
    // / Pointer to unknown (opaque) type
    public static class MIDIClientRef extends PointerType {
        public MIDIClientRef(Pointer address) {
            super(address);
        }

        public MIDIClientRef() {
            super();
        }
    };
}
// CHECKSTYLE:ON

