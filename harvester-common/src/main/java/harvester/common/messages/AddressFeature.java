package harvester.common.messages;
public final class AddressFeature {
  private AddressFeature() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AddressFeatureMapOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AddressFeatureMap)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */
    int getAddressFeatureCount();
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */
    boolean containsAddressFeature(
            String key);
    /**
     * Use {@link #getAddressFeatureMap()} instead.
     */
    @Deprecated
    java.util.Map<String, String>
    getAddressFeature();
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */
    java.util.Map<String, String>
    getAddressFeatureMap();
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */

    String getAddressFeatureOrDefault(
            String key,
            String defaultValue);
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */

    String getAddressFeatureOrThrow(
            String key);
  }
  /**
   * Protobuf type {@code AddressFeatureMap}
   */
  public  static final class AddressFeatureMap extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:AddressFeatureMap)
      AddressFeatureMapOrBuilder {
    // Use AddressFeatureMap.newBuilder() to construct.
    private AddressFeatureMap(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AddressFeatureMap() {
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private AddressFeatureMap(
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
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                addressFeature_ = com.google.protobuf.MapField.newMapField(
                    AddressFeatureDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000001;
              }
              com.google.protobuf.MapEntry<String, String>
              addressFeature = input.readMessage(
                  AddressFeatureDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              addressFeature_.getMutableMap().put(addressFeature.getKey(), addressFeature.getValue());
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
      return AddressFeature.internal_static_AddressFeatureMap_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetAddressFeature();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AddressFeature.internal_static_AddressFeatureMap_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AddressFeature.AddressFeatureMap.class, AddressFeature.AddressFeatureMap.Builder.class);
    }

    public static final int ADDRESS_FEATURE_FIELD_NUMBER = 1;
    private static final class AddressFeatureDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          String, String> defaultEntry =
              com.google.protobuf.MapEntry
              .<String, String>newDefaultInstance(
                  AddressFeature.internal_static_AddressFeatureMap_AddressFeatureEntry_descriptor,
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        String, String> addressFeature_;
    private com.google.protobuf.MapField<String, String>
    internalGetAddressFeature() {
      if (addressFeature_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            AddressFeatureDefaultEntryHolder.defaultEntry);
      }
      return addressFeature_;
    }

    public int getAddressFeatureCount() {
      return internalGetAddressFeature().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */

    public boolean containsAddressFeature(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetAddressFeature().getMap().containsKey(key);
    }
    /**
     * Use {@link #getAddressFeatureMap()} instead.
     */
    @Deprecated
    public java.util.Map<String, String> getAddressFeature() {
      return getAddressFeatureMap();
    }
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */

    public java.util.Map<String, String> getAddressFeatureMap() {
      return internalGetAddressFeature().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */

    public String getAddressFeatureOrDefault(
        String key,
        String defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetAddressFeature().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; address_feature = 1;</code>
     */

    public String getAddressFeatureOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetAddressFeature().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
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
      for (java.util.Map.Entry<String, String> entry
           : internalGetAddressFeature().getMap().entrySet()) {
        com.google.protobuf.MapEntry<String, String>
        addressFeature = AddressFeatureDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(1, addressFeature);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (java.util.Map.Entry<String, String> entry
           : internalGetAddressFeature().getMap().entrySet()) {
        com.google.protobuf.MapEntry<String, String>
        addressFeature = AddressFeatureDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(1, addressFeature);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof AddressFeature.AddressFeatureMap)) {
        return super.equals(obj);
      }
      AddressFeature.AddressFeatureMap other = (AddressFeature.AddressFeatureMap) obj;

      boolean result = true;
      result = result && internalGetAddressFeature().equals(
          other.internalGetAddressFeature());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (!internalGetAddressFeature().getMap().isEmpty()) {
        hash = (37 * hash) + ADDRESS_FEATURE_FIELD_NUMBER;
        hash = (53 * hash) + internalGetAddressFeature().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static AddressFeature.AddressFeatureMap parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static AddressFeature.AddressFeatureMap parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static AddressFeature.AddressFeatureMap parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AddressFeature.AddressFeatureMap parseFrom(
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
    public static Builder newBuilder(AddressFeature.AddressFeatureMap prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AddressFeatureMap}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AddressFeatureMap)
        AddressFeature.AddressFeatureMapOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return AddressFeature.internal_static_AddressFeatureMap_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 1:
            return internalGetAddressFeature();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(
          int number) {
        switch (number) {
          case 1:
            return internalGetMutableAddressFeature();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return AddressFeature.internal_static_AddressFeatureMap_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AddressFeature.AddressFeatureMap.class, AddressFeature.AddressFeatureMap.Builder.class);
      }

      // Construct using AddressFeature.AddressFeatureMap.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
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
        internalGetMutableAddressFeature().clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return AddressFeature.internal_static_AddressFeatureMap_descriptor;
      }

      public AddressFeature.AddressFeatureMap getDefaultInstanceForType() {
        return AddressFeature.AddressFeatureMap.getDefaultInstance();
      }

      public AddressFeature.AddressFeatureMap build() {
        AddressFeature.AddressFeatureMap result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public AddressFeature.AddressFeatureMap buildPartial() {
        AddressFeature.AddressFeatureMap result = new AddressFeature.AddressFeatureMap(this);
        int from_bitField0_ = bitField0_;
        result.addressFeature_ = internalGetAddressFeature();
        result.addressFeature_.makeImmutable();
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
        if (other instanceof AddressFeature.AddressFeatureMap) {
          return mergeFrom((AddressFeature.AddressFeatureMap)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AddressFeature.AddressFeatureMap other) {
        if (other == AddressFeature.AddressFeatureMap.getDefaultInstance()) return this;
        internalGetMutableAddressFeature().mergeFrom(
            other.internalGetAddressFeature());
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
        AddressFeature.AddressFeatureMap parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AddressFeature.AddressFeatureMap) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.MapField<
          String, String> addressFeature_;
      private com.google.protobuf.MapField<String, String>
      internalGetAddressFeature() {
        if (addressFeature_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              AddressFeatureDefaultEntryHolder.defaultEntry);
        }
        return addressFeature_;
      }
      private com.google.protobuf.MapField<String, String>
      internalGetMutableAddressFeature() {
        onChanged();;
        if (addressFeature_ == null) {
          addressFeature_ = com.google.protobuf.MapField.newMapField(
              AddressFeatureDefaultEntryHolder.defaultEntry);
        }
        if (!addressFeature_.isMutable()) {
          addressFeature_ = addressFeature_.copy();
        }
        return addressFeature_;
      }

      public int getAddressFeatureCount() {
        return internalGetAddressFeature().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */

      public boolean containsAddressFeature(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        return internalGetAddressFeature().getMap().containsKey(key);
      }
      /**
       * Use {@link #getAddressFeatureMap()} instead.
       */
      @Deprecated
      public java.util.Map<String, String> getAddressFeature() {
        return getAddressFeatureMap();
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */

      public java.util.Map<String, String> getAddressFeatureMap() {
        return internalGetAddressFeature().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */

      public String getAddressFeatureOrDefault(
          String key,
          String defaultValue) {
        if (key == null) { throw new NullPointerException(); }
        java.util.Map<String, String> map =
            internalGetAddressFeature().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */

      public String getAddressFeatureOrThrow(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        java.util.Map<String, String> map =
            internalGetAddressFeature().getMap();
        if (!map.containsKey(key)) {
          throw new IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearAddressFeature() {
        getMutableAddressFeature().clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */

      public Builder removeAddressFeature(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        getMutableAddressFeature().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @Deprecated
      public java.util.Map<String, String>
      getMutableAddressFeature() {
        return internalGetMutableAddressFeature().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */
      public Builder putAddressFeature(
          String key,
          String value) {
        if (key == null) { throw new NullPointerException(); }
        if (value == null) { throw new NullPointerException(); }
        getMutableAddressFeature().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; address_feature = 1;</code>
       */

      public Builder putAllAddressFeature(
          java.util.Map<String, String> values) {
        getMutableAddressFeature().putAll(values);
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


      // @@protoc_insertion_point(builder_scope:AddressFeatureMap)
    }

    // @@protoc_insertion_point(class_scope:AddressFeatureMap)
    private static final AddressFeature.AddressFeatureMap DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new AddressFeature.AddressFeatureMap();
    }

    public static AddressFeature.AddressFeatureMap getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AddressFeatureMap>
        PARSER = new com.google.protobuf.AbstractParser<AddressFeatureMap>() {
      public AddressFeatureMap parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new AddressFeatureMap(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AddressFeatureMap> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<AddressFeatureMap> getParserForType() {
      return PARSER;
    }

    public AddressFeature.AddressFeatureMap getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AddressFeatureMap_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AddressFeatureMap_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AddressFeatureMap_AddressFeatureEntry_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AddressFeatureMap_AddressFeatureEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\024AddressFeature.proto\"\213\001\n\021AddressFeatur" +
      "eMap\022?\n\017address_feature\030\001 \003(\0132&.AddressF" +
      "eatureMap.AddressFeatureEntry\0325\n\023Address" +
      "FeatureEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t" +
      ":\0028\001B\020B\016AddressFeatureb\006proto3"
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
    internal_static_AddressFeatureMap_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AddressFeatureMap_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AddressFeatureMap_descriptor,
        new String[] { "AddressFeature", });
    internal_static_AddressFeatureMap_AddressFeatureEntry_descriptor =
      internal_static_AddressFeatureMap_descriptor.getNestedTypes().get(0);
    internal_static_AddressFeatureMap_AddressFeatureEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AddressFeatureMap_AddressFeatureEntry_descriptor,
        new String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
