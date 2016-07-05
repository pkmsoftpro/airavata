/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.error;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * This exception is thrown by Airavata Services when a call fails as a result of
 * a problem in the service that could not be changed through client's action.
 * 
 * airavataErrorType:  The message type indicating the error that occurred.
 *   must be one of the values of AiravataErrorType.
 * 
 * message:  This may contain additional information about the error
 * 
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-07-05")
public class AiravataSystemException extends TException implements org.apache.thrift.TBase<AiravataSystemException, AiravataSystemException._Fields>, java.io.Serializable, Cloneable, Comparable<AiravataSystemException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AiravataSystemException");

  private static final org.apache.thrift.protocol.TField AIRAVATA_ERROR_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("airavataErrorType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AiravataSystemExceptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AiravataSystemExceptionTupleSchemeFactory());
  }

  private AiravataErrorType airavataErrorType; // required
  private String message; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see AiravataErrorType
     */
    AIRAVATA_ERROR_TYPE((short)1, "airavataErrorType"),
    MESSAGE((short)2, "message");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // AIRAVATA_ERROR_TYPE
          return AIRAVATA_ERROR_TYPE;
        case 2: // MESSAGE
          return MESSAGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.MESSAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AIRAVATA_ERROR_TYPE, new org.apache.thrift.meta_data.FieldMetaData("airavataErrorType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, AiravataErrorType.class)));
    tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AiravataSystemException.class, metaDataMap);
  }

  public AiravataSystemException() {
  }

  public AiravataSystemException(
    AiravataErrorType airavataErrorType)
  {
    this();
    this.airavataErrorType = airavataErrorType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AiravataSystemException(AiravataSystemException other) {
    if (other.isSetAiravataErrorType()) {
      this.airavataErrorType = other.airavataErrorType;
    }
    if (other.isSetMessage()) {
      this.message = other.message;
    }
  }

  public AiravataSystemException deepCopy() {
    return new AiravataSystemException(this);
  }

  @Override
  public void clear() {
    this.airavataErrorType = null;
    this.message = null;
  }

  /**
   * 
   * @see AiravataErrorType
   */
  public AiravataErrorType getAiravataErrorType() {
    return this.airavataErrorType;
  }

  /**
   * 
   * @see AiravataErrorType
   */
  public void setAiravataErrorType(AiravataErrorType airavataErrorType) {
    this.airavataErrorType = airavataErrorType;
  }

  public void unsetAiravataErrorType() {
    this.airavataErrorType = null;
  }

  /** Returns true if field airavataErrorType is set (has been assigned a value) and false otherwise */
  public boolean isSetAiravataErrorType() {
    return this.airavataErrorType != null;
  }

  public void setAiravataErrorTypeIsSet(boolean value) {
    if (!value) {
      this.airavataErrorType = null;
    }
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void unsetMessage() {
    this.message = null;
  }

  /** Returns true if field message is set (has been assigned a value) and false otherwise */
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case AIRAVATA_ERROR_TYPE:
      if (value == null) {
        unsetAiravataErrorType();
      } else {
        setAiravataErrorType((AiravataErrorType)value);
      }
      break;

    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case AIRAVATA_ERROR_TYPE:
      return getAiravataErrorType();

    case MESSAGE:
      return getMessage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case AIRAVATA_ERROR_TYPE:
      return isSetAiravataErrorType();
    case MESSAGE:
      return isSetMessage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AiravataSystemException)
      return this.equals((AiravataSystemException)that);
    return false;
  }

  public boolean equals(AiravataSystemException that) {
    if (that == null)
      return false;

    boolean this_present_airavataErrorType = true && this.isSetAiravataErrorType();
    boolean that_present_airavataErrorType = true && that.isSetAiravataErrorType();
    if (this_present_airavataErrorType || that_present_airavataErrorType) {
      if (!(this_present_airavataErrorType && that_present_airavataErrorType))
        return false;
      if (!this.airavataErrorType.equals(that.airavataErrorType))
        return false;
    }

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_airavataErrorType = true && (isSetAiravataErrorType());
    list.add(present_airavataErrorType);
    if (present_airavataErrorType)
      list.add(airavataErrorType.getValue());

    boolean present_message = true && (isSetMessage());
    list.add(present_message);
    if (present_message)
      list.add(message);

    return list.hashCode();
  }

  @Override
  public int compareTo(AiravataSystemException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAiravataErrorType()).compareTo(other.isSetAiravataErrorType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAiravataErrorType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.airavataErrorType, other.airavataErrorType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessage()).compareTo(other.isSetMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AiravataSystemException(");
    boolean first = true;

    sb.append("airavataErrorType:");
    if (this.airavataErrorType == null) {
      sb.append("null");
    } else {
      sb.append(this.airavataErrorType);
    }
    first = false;
    if (isSetMessage()) {
      if (!first) sb.append(", ");
      sb.append("message:");
      if (this.message == null) {
        sb.append("null");
      } else {
        sb.append(this.message);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetAiravataErrorType()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'airavataErrorType' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AiravataSystemExceptionStandardSchemeFactory implements SchemeFactory {
    public AiravataSystemExceptionStandardScheme getScheme() {
      return new AiravataSystemExceptionStandardScheme();
    }
  }

  private static class AiravataSystemExceptionStandardScheme extends StandardScheme<AiravataSystemException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AiravataSystemException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // AIRAVATA_ERROR_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.airavataErrorType = org.apache.airavata.model.error.AiravataErrorType.findByValue(iprot.readI32());
              struct.setAiravataErrorTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.message = iprot.readString();
              struct.setMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, AiravataSystemException struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.airavataErrorType != null) {
        oprot.writeFieldBegin(AIRAVATA_ERROR_TYPE_FIELD_DESC);
        oprot.writeI32(struct.airavataErrorType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.message != null) {
        if (struct.isSetMessage()) {
          oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
          oprot.writeString(struct.message);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AiravataSystemExceptionTupleSchemeFactory implements SchemeFactory {
    public AiravataSystemExceptionTupleScheme getScheme() {
      return new AiravataSystemExceptionTupleScheme();
    }
  }

  private static class AiravataSystemExceptionTupleScheme extends TupleScheme<AiravataSystemException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AiravataSystemException struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.airavataErrorType.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetMessage()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetMessage()) {
        oprot.writeString(struct.message);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AiravataSystemException struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.airavataErrorType = org.apache.airavata.model.error.AiravataErrorType.findByValue(iprot.readI32());
      struct.setAiravataErrorTypeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.message = iprot.readString();
        struct.setMessageIsSet(true);
      }
    }
  }

}

