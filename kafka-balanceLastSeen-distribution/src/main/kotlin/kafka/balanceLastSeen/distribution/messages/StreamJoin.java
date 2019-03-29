package kafka.balanceLastSeen.distribution.messages;

public final class StreamJoin {
  private StreamJoin() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface JoinOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Join)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional uint32 number_of_streams = 1;</code>
     */
    int getNumberOfStreams();

    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */
    int getFeatureMap1Count();
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */
    boolean containsFeatureMap1(
        java.lang.String key);
    /**
     * Use {@link #getFeatureMap1Map()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap1();
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap1Map();
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */

    java.lang.String getFeatureMap1OrDefault(
        java.lang.String key,
        java.lang.String defaultValue);
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */

    java.lang.String getFeatureMap1OrThrow(
        java.lang.String key);

    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */
    int getFeatureMap2Count();
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */
    boolean containsFeatureMap2(
        java.lang.String key);
    /**
     * Use {@link #getFeatureMap2Map()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap2();
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap2Map();
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */

    java.lang.String getFeatureMap2OrDefault(
        java.lang.String key,
        java.lang.String defaultValue);
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */

    java.lang.String getFeatureMap2OrThrow(
        java.lang.String key);

    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */
    int getFeatureMap3Count();
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */
    boolean containsFeatureMap3(
        java.lang.String key);
    /**
     * Use {@link #getFeatureMap3Map()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap3();
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap3Map();
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */

    java.lang.String getFeatureMap3OrDefault(
        java.lang.String key,
        java.lang.String defaultValue);
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */

    java.lang.String getFeatureMap3OrThrow(
        java.lang.String key);

    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */
    int getFeatureMap4Count();
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */
    boolean containsFeatureMap4(
        java.lang.String key);
    /**
     * Use {@link #getFeatureMap4Map()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap4();
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getFeatureMap4Map();
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */

    java.lang.String getFeatureMap4OrDefault(
        java.lang.String key,
        java.lang.String defaultValue);
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */

    java.lang.String getFeatureMap4OrThrow(
        java.lang.String key);
  }
  /**
   * Protobuf type {@code Join}
   */
  public  static final class Join extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Join)
      JoinOrBuilder {
    // Use Join.newBuilder() to construct.
    private Join(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Join() {
      numberOfStreams_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Join(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              numberOfStreams_ = input.readUInt32();
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                featureMap1_ = com.google.protobuf.MapField.newMapField(
                    FeatureMap1DefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000002;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              featureMap1 = input.readMessage(
                  FeatureMap1DefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              featureMap1_.getMutableMap().put(featureMap1.getKey(), featureMap1.getValue());
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                featureMap2_ = com.google.protobuf.MapField.newMapField(
                    FeatureMap2DefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000004;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              featureMap2 = input.readMessage(
                  FeatureMap2DefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              featureMap2_.getMutableMap().put(featureMap2.getKey(), featureMap2.getValue());
              break;
            }
            case 34: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                featureMap3_ = com.google.protobuf.MapField.newMapField(
                    FeatureMap3DefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000008;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              featureMap3 = input.readMessage(
                  FeatureMap3DefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              featureMap3_.getMutableMap().put(featureMap3.getKey(), featureMap3.getValue());
              break;
            }
            case 42: {
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                featureMap4_ = com.google.protobuf.MapField.newMapField(
                    FeatureMap4DefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000010;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              featureMap4 = input.readMessage(
                  FeatureMap4DefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              featureMap4_.getMutableMap().put(featureMap4.getKey(), featureMap4.getValue());
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return StreamJoin.internal_static_Join_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetFeatureMap1();
        case 3:
          return internalGetFeatureMap2();
        case 4:
          return internalGetFeatureMap3();
        case 5:
          return internalGetFeatureMap4();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return StreamJoin.internal_static_Join_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              StreamJoin.Join.class, StreamJoin.Join.Builder.class);
    }

    private int bitField0_;
    public static final int NUMBER_OF_STREAMS_FIELD_NUMBER = 1;
    private int numberOfStreams_;
    /**
     * <code>optional uint32 number_of_streams = 1;</code>
     */
    public int getNumberOfStreams() {
      return numberOfStreams_;
    }

    public static final int FEATURE_MAP_1_FIELD_NUMBER = 2;
    private static final class FeatureMap1DefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, java.lang.String> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, java.lang.String>newDefaultInstance(
                  StreamJoin.internal_static_Join_FeatureMap1Entry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> featureMap1_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetFeatureMap1() {
      if (featureMap1_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            FeatureMap1DefaultEntryHolder.defaultEntry);
      }
      return featureMap1_;
    }

    public int getFeatureMap1Count() {
      return internalGetFeatureMap1().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */

    public boolean containsFeatureMap1(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetFeatureMap1().getMap().containsKey(key);
    }
    /**
     * Use {@link #getFeatureMap1Map()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap1() {
      return getFeatureMap1Map();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap1Map() {
      return internalGetFeatureMap1().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */

    public java.lang.String getFeatureMap1OrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap1().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
     */

    public java.lang.String getFeatureMap1OrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap1().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public static final int FEATURE_MAP_2_FIELD_NUMBER = 3;
    private static final class FeatureMap2DefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, java.lang.String> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, java.lang.String>newDefaultInstance(
                  StreamJoin.internal_static_Join_FeatureMap2Entry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> featureMap2_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetFeatureMap2() {
      if (featureMap2_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            FeatureMap2DefaultEntryHolder.defaultEntry);
      }
      return featureMap2_;
    }

    public int getFeatureMap2Count() {
      return internalGetFeatureMap2().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */

    public boolean containsFeatureMap2(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetFeatureMap2().getMap().containsKey(key);
    }
    /**
     * Use {@link #getFeatureMap2Map()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap2() {
      return getFeatureMap2Map();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap2Map() {
      return internalGetFeatureMap2().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */

    public java.lang.String getFeatureMap2OrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap2().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
     */

    public java.lang.String getFeatureMap2OrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap2().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public static final int FEATURE_MAP_3_FIELD_NUMBER = 4;
    private static final class FeatureMap3DefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, java.lang.String> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, java.lang.String>newDefaultInstance(
                  StreamJoin.internal_static_Join_FeatureMap3Entry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> featureMap3_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetFeatureMap3() {
      if (featureMap3_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            FeatureMap3DefaultEntryHolder.defaultEntry);
      }
      return featureMap3_;
    }

    public int getFeatureMap3Count() {
      return internalGetFeatureMap3().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */

    public boolean containsFeatureMap3(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetFeatureMap3().getMap().containsKey(key);
    }
    /**
     * Use {@link #getFeatureMap3Map()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap3() {
      return getFeatureMap3Map();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap3Map() {
      return internalGetFeatureMap3().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */

    public java.lang.String getFeatureMap3OrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap3().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
     */

    public java.lang.String getFeatureMap3OrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap3().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public static final int FEATURE_MAP_4_FIELD_NUMBER = 5;
    private static final class FeatureMap4DefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, java.lang.String> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, java.lang.String>newDefaultInstance(
                  StreamJoin.internal_static_Join_FeatureMap4Entry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> featureMap4_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetFeatureMap4() {
      if (featureMap4_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            FeatureMap4DefaultEntryHolder.defaultEntry);
      }
      return featureMap4_;
    }

    public int getFeatureMap4Count() {
      return internalGetFeatureMap4().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */

    public boolean containsFeatureMap4(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetFeatureMap4().getMap().containsKey(key);
    }
    /**
     * Use {@link #getFeatureMap4Map()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap4() {
      return getFeatureMap4Map();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getFeatureMap4Map() {
      return internalGetFeatureMap4().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */

    public java.lang.String getFeatureMap4OrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap4().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
     */

    public java.lang.String getFeatureMap4OrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetFeatureMap4().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (numberOfStreams_ != 0) {
        output.writeUInt32(1, numberOfStreams_);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap1().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap1 = FeatureMap1DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(2, featureMap1);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap2().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap2 = FeatureMap2DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(3, featureMap2);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap3().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap3 = FeatureMap3DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(4, featureMap3);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap4().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap4 = FeatureMap4DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(5, featureMap4);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (numberOfStreams_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, numberOfStreams_);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap1().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap1 = FeatureMap1DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(2, featureMap1);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap2().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap2 = FeatureMap2DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(3, featureMap2);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap3().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap3 = FeatureMap3DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(4, featureMap3);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetFeatureMap4().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        featureMap4 = FeatureMap4DefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(5, featureMap4);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof StreamJoin.Join)) {
        return super.equals(obj);
      }
      StreamJoin.Join other = (StreamJoin.Join) obj;

      boolean result = true;
      result = result && (getNumberOfStreams()
          == other.getNumberOfStreams());
      result = result && internalGetFeatureMap1().equals(
          other.internalGetFeatureMap1());
      result = result && internalGetFeatureMap2().equals(
          other.internalGetFeatureMap2());
      result = result && internalGetFeatureMap3().equals(
          other.internalGetFeatureMap3());
      result = result && internalGetFeatureMap4().equals(
          other.internalGetFeatureMap4());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + NUMBER_OF_STREAMS_FIELD_NUMBER;
      hash = (53 * hash) + getNumberOfStreams();
      if (!internalGetFeatureMap1().getMap().isEmpty()) {
        hash = (37 * hash) + FEATURE_MAP_1_FIELD_NUMBER;
        hash = (53 * hash) + internalGetFeatureMap1().hashCode();
      }
      if (!internalGetFeatureMap2().getMap().isEmpty()) {
        hash = (37 * hash) + FEATURE_MAP_2_FIELD_NUMBER;
        hash = (53 * hash) + internalGetFeatureMap2().hashCode();
      }
      if (!internalGetFeatureMap3().getMap().isEmpty()) {
        hash = (37 * hash) + FEATURE_MAP_3_FIELD_NUMBER;
        hash = (53 * hash) + internalGetFeatureMap3().hashCode();
      }
      if (!internalGetFeatureMap4().getMap().isEmpty()) {
        hash = (37 * hash) + FEATURE_MAP_4_FIELD_NUMBER;
        hash = (53 * hash) + internalGetFeatureMap4().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static StreamJoin.Join parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StreamJoin.Join parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StreamJoin.Join parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StreamJoin.Join parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StreamJoin.Join parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static StreamJoin.Join parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static StreamJoin.Join parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static StreamJoin.Join parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static StreamJoin.Join parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static StreamJoin.Join parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(StreamJoin.Join prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Join}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Join)
        StreamJoin.JoinOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return StreamJoin.internal_static_Join_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 2:
            return internalGetFeatureMap1();
          case 3:
            return internalGetFeatureMap2();
          case 4:
            return internalGetFeatureMap3();
          case 5:
            return internalGetFeatureMap4();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(
          int number) {
        switch (number) {
          case 2:
            return internalGetMutableFeatureMap1();
          case 3:
            return internalGetMutableFeatureMap2();
          case 4:
            return internalGetMutableFeatureMap3();
          case 5:
            return internalGetMutableFeatureMap4();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return StreamJoin.internal_static_Join_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                StreamJoin.Join.class, StreamJoin.Join.Builder.class);
      }

      // Construct using StreamJoin.Join.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        numberOfStreams_ = 0;

        internalGetMutableFeatureMap1().clear();
        internalGetMutableFeatureMap2().clear();
        internalGetMutableFeatureMap3().clear();
        internalGetMutableFeatureMap4().clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return StreamJoin.internal_static_Join_descriptor;
      }

      public StreamJoin.Join getDefaultInstanceForType() {
        return StreamJoin.Join.getDefaultInstance();
      }

      public StreamJoin.Join build() {
        StreamJoin.Join result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public StreamJoin.Join buildPartial() {
        StreamJoin.Join result = new StreamJoin.Join(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.numberOfStreams_ = numberOfStreams_;
        result.featureMap1_ = internalGetFeatureMap1();
        result.featureMap1_.makeImmutable();
        result.featureMap2_ = internalGetFeatureMap2();
        result.featureMap2_.makeImmutable();
        result.featureMap3_ = internalGetFeatureMap3();
        result.featureMap3_.makeImmutable();
        result.featureMap4_ = internalGetFeatureMap4();
        result.featureMap4_.makeImmutable();
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof StreamJoin.Join) {
          return mergeFrom((StreamJoin.Join)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(StreamJoin.Join other) {
        if (other == StreamJoin.Join.getDefaultInstance()) return this;
        if (other.getNumberOfStreams() != 0) {
          setNumberOfStreams(other.getNumberOfStreams());
        }
        internalGetMutableFeatureMap1().mergeFrom(
            other.internalGetFeatureMap1());
        internalGetMutableFeatureMap2().mergeFrom(
            other.internalGetFeatureMap2());
        internalGetMutableFeatureMap3().mergeFrom(
            other.internalGetFeatureMap3());
        internalGetMutableFeatureMap4().mergeFrom(
            other.internalGetFeatureMap4());
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        StreamJoin.Join parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (StreamJoin.Join) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int numberOfStreams_ ;
      /**
       * <code>optional uint32 number_of_streams = 1;</code>
       */
      public int getNumberOfStreams() {
        return numberOfStreams_;
      }
      /**
       * <code>optional uint32 number_of_streams = 1;</code>
       */
      public Builder setNumberOfStreams(int value) {
        
        numberOfStreams_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint32 number_of_streams = 1;</code>
       */
      public Builder clearNumberOfStreams() {
        
        numberOfStreams_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> featureMap1_;
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetFeatureMap1() {
        if (featureMap1_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              FeatureMap1DefaultEntryHolder.defaultEntry);
        }
        return featureMap1_;
      }
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetMutableFeatureMap1() {
        onChanged();;
        if (featureMap1_ == null) {
          featureMap1_ = com.google.protobuf.MapField.newMapField(
              FeatureMap1DefaultEntryHolder.defaultEntry);
        }
        if (!featureMap1_.isMutable()) {
          featureMap1_ = featureMap1_.copy();
        }
        return featureMap1_;
      }

      public int getFeatureMap1Count() {
        return internalGetFeatureMap1().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */

      public boolean containsFeatureMap1(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetFeatureMap1().getMap().containsKey(key);
      }
      /**
       * Use {@link #getFeatureMap1Map()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap1() {
        return getFeatureMap1Map();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */

      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap1Map() {
        return internalGetFeatureMap1().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */

      public java.lang.String getFeatureMap1OrDefault(
          java.lang.String key,
          java.lang.String defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap1().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */

      public java.lang.String getFeatureMap1OrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap1().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearFeatureMap1() {
        getMutableFeatureMap1().clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */

      public Builder removeFeatureMap1(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap1().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableFeatureMap1() {
        return internalGetMutableFeatureMap1().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */
      public Builder putFeatureMap1(
          java.lang.String key,
          java.lang.String value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap1().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_1 = 2;</code>
       */

      public Builder putAllFeatureMap1(
          java.util.Map<java.lang.String, java.lang.String> values) {
        getMutableFeatureMap1().putAll(values);
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> featureMap2_;
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetFeatureMap2() {
        if (featureMap2_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              FeatureMap2DefaultEntryHolder.defaultEntry);
        }
        return featureMap2_;
      }
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetMutableFeatureMap2() {
        onChanged();;
        if (featureMap2_ == null) {
          featureMap2_ = com.google.protobuf.MapField.newMapField(
              FeatureMap2DefaultEntryHolder.defaultEntry);
        }
        if (!featureMap2_.isMutable()) {
          featureMap2_ = featureMap2_.copy();
        }
        return featureMap2_;
      }

      public int getFeatureMap2Count() {
        return internalGetFeatureMap2().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */

      public boolean containsFeatureMap2(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetFeatureMap2().getMap().containsKey(key);
      }
      /**
       * Use {@link #getFeatureMap2Map()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap2() {
        return getFeatureMap2Map();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */

      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap2Map() {
        return internalGetFeatureMap2().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */

      public java.lang.String getFeatureMap2OrDefault(
          java.lang.String key,
          java.lang.String defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap2().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */

      public java.lang.String getFeatureMap2OrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap2().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearFeatureMap2() {
        getMutableFeatureMap2().clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */

      public Builder removeFeatureMap2(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap2().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableFeatureMap2() {
        return internalGetMutableFeatureMap2().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */
      public Builder putFeatureMap2(
          java.lang.String key,
          java.lang.String value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap2().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_2 = 3;</code>
       */

      public Builder putAllFeatureMap2(
          java.util.Map<java.lang.String, java.lang.String> values) {
        getMutableFeatureMap2().putAll(values);
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> featureMap3_;
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetFeatureMap3() {
        if (featureMap3_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              FeatureMap3DefaultEntryHolder.defaultEntry);
        }
        return featureMap3_;
      }
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetMutableFeatureMap3() {
        onChanged();;
        if (featureMap3_ == null) {
          featureMap3_ = com.google.protobuf.MapField.newMapField(
              FeatureMap3DefaultEntryHolder.defaultEntry);
        }
        if (!featureMap3_.isMutable()) {
          featureMap3_ = featureMap3_.copy();
        }
        return featureMap3_;
      }

      public int getFeatureMap3Count() {
        return internalGetFeatureMap3().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */

      public boolean containsFeatureMap3(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetFeatureMap3().getMap().containsKey(key);
      }
      /**
       * Use {@link #getFeatureMap3Map()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap3() {
        return getFeatureMap3Map();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */

      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap3Map() {
        return internalGetFeatureMap3().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */

      public java.lang.String getFeatureMap3OrDefault(
          java.lang.String key,
          java.lang.String defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap3().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */

      public java.lang.String getFeatureMap3OrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap3().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearFeatureMap3() {
        getMutableFeatureMap3().clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */

      public Builder removeFeatureMap3(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap3().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableFeatureMap3() {
        return internalGetMutableFeatureMap3().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */
      public Builder putFeatureMap3(
          java.lang.String key,
          java.lang.String value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap3().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_3 = 4;</code>
       */

      public Builder putAllFeatureMap3(
          java.util.Map<java.lang.String, java.lang.String> values) {
        getMutableFeatureMap3().putAll(values);
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> featureMap4_;
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetFeatureMap4() {
        if (featureMap4_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              FeatureMap4DefaultEntryHolder.defaultEntry);
        }
        return featureMap4_;
      }
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetMutableFeatureMap4() {
        onChanged();;
        if (featureMap4_ == null) {
          featureMap4_ = com.google.protobuf.MapField.newMapField(
              FeatureMap4DefaultEntryHolder.defaultEntry);
        }
        if (!featureMap4_.isMutable()) {
          featureMap4_ = featureMap4_.copy();
        }
        return featureMap4_;
      }

      public int getFeatureMap4Count() {
        return internalGetFeatureMap4().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */

      public boolean containsFeatureMap4(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetFeatureMap4().getMap().containsKey(key);
      }
      /**
       * Use {@link #getFeatureMap4Map()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap4() {
        return getFeatureMap4Map();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */

      public java.util.Map<java.lang.String, java.lang.String> getFeatureMap4Map() {
        return internalGetFeatureMap4().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */

      public java.lang.String getFeatureMap4OrDefault(
          java.lang.String key,
          java.lang.String defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap4().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */

      public java.lang.String getFeatureMap4OrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetFeatureMap4().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearFeatureMap4() {
        getMutableFeatureMap4().clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */

      public Builder removeFeatureMap4(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap4().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableFeatureMap4() {
        return internalGetMutableFeatureMap4().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */
      public Builder putFeatureMap4(
          java.lang.String key,
          java.lang.String value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        getMutableFeatureMap4().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; feature_map_4 = 5;</code>
       */

      public Builder putAllFeatureMap4(
          java.util.Map<java.lang.String, java.lang.String> values) {
        getMutableFeatureMap4().putAll(values);
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Join)
    }

    // @@protoc_insertion_point(class_scope:Join)
    private static final StreamJoin.Join DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new StreamJoin.Join();
    }

    public static StreamJoin.Join getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Join>
        PARSER = new com.google.protobuf.AbstractParser<Join>() {
      public Join parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Join(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Join> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Join> getParserForType() {
      return PARSER;
    }

    public StreamJoin.Join getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Join_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Join_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Join_FeatureMap1Entry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Join_FeatureMap1Entry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Join_FeatureMap2Entry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Join_FeatureMap2Entry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Join_FeatureMap3Entry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Join_FeatureMap3Entry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Join_FeatureMap4Entry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Join_FeatureMap4Entry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020StreamJoin.proto\"\255\003\n\004Join\022\031\n\021number_of" +
      "_streams\030\001 \001(\r\022-\n\rfeature_map_1\030\002 \003(\0132\026." +
      "Join.FeatureMap1Entry\022-\n\rfeature_map_2\030\003" +
      " \003(\0132\026.Join.FeatureMap2Entry\022-\n\rfeature_" +
      "map_3\030\004 \003(\0132\026.Join.FeatureMap3Entry\022-\n\rf" +
      "eature_map_4\030\005 \003(\0132\026.Join.FeatureMap4Ent" +
      "ry\0322\n\020FeatureMap1Entry\022\013\n\003key\030\001 \001(\t\022\r\n\005v" +
      "alue\030\002 \001(\t:\0028\001\0322\n\020FeatureMap2Entry\022\013\n\003ke" +
      "y\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\0322\n\020FeatureMap" +
      "3Entry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\0322",
      "\n\020FeatureMap4Entry\022\013\n\003key\030\001 \001(\t\022\r\n\005value" +
      "\030\002 \001(\t:\0028\001B\014B\nStreamJoinb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Join_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Join_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Join_descriptor,
        new java.lang.String[] { "NumberOfStreams", "FeatureMap1", "FeatureMap2", "FeatureMap3", "FeatureMap4", });
    internal_static_Join_FeatureMap1Entry_descriptor =
      internal_static_Join_descriptor.getNestedTypes().get(0);
    internal_static_Join_FeatureMap1Entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Join_FeatureMap1Entry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Join_FeatureMap2Entry_descriptor =
      internal_static_Join_descriptor.getNestedTypes().get(1);
    internal_static_Join_FeatureMap2Entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Join_FeatureMap2Entry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Join_FeatureMap3Entry_descriptor =
      internal_static_Join_descriptor.getNestedTypes().get(2);
    internal_static_Join_FeatureMap3Entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Join_FeatureMap3Entry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Join_FeatureMap4Entry_descriptor =
      internal_static_Join_descriptor.getNestedTypes().get(3);
    internal_static_Join_FeatureMap4Entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Join_FeatureMap4Entry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
