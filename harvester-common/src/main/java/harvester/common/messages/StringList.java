package harvester.common.messages;

public final class StringList {
  private StringList() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ListOrBuilder extends
      // @@protoc_insertion_point(interface_extends:List)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated string item = 1;</code>
     */
    java.util.List<java.lang.String>
        getItemList();
    /**
     * <code>repeated string item = 1;</code>
     */
    int getItemCount();
    /**
     * <code>repeated string item = 1;</code>
     */
    java.lang.String getItem(int index);
    /**
     * <code>repeated string item = 1;</code>
     */
    com.google.protobuf.ByteString
        getItemBytes(int index);
  }
  /**
   * Protobuf type {@code List}
   */
  public  static final class List extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:List)
      ListOrBuilder {
    // Use List.newBuilder() to construct.
    private List(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private List() {
      item_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private List(
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
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                item_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              item_.add(s);
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
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          item_ = item_.getUnmodifiableView();
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return StringList.internal_static_List_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return StringList.internal_static_List_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              StringList.List.class, StringList.List.Builder.class);
    }

    public static final int ITEM_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList item_;
    /**
     * <code>repeated string item = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getItemList() {
      return item_;
    }
    /**
     * <code>repeated string item = 1;</code>
     */
    public int getItemCount() {
      return item_.size();
    }
    /**
     * <code>repeated string item = 1;</code>
     */
    public java.lang.String getItem(int index) {
      return item_.get(index);
    }
    /**
     * <code>repeated string item = 1;</code>
     */
    public com.google.protobuf.ByteString
        getItemBytes(int index) {
      return item_.getByteString(index);
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
      for (int i = 0; i < item_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, item_.getRaw(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < item_.size(); i++) {
          dataSize += computeStringSizeNoTag(item_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getItemList().size();
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
      if (!(obj instanceof StringList.List)) {
        return super.equals(obj);
      }
      StringList.List other = (StringList.List) obj;

      boolean result = true;
      result = result && getItemList()
          .equals(other.getItemList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (getItemCount() > 0) {
        hash = (37 * hash) + ITEM_FIELD_NUMBER;
        hash = (53 * hash) + getItemList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static StringList.List parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StringList.List parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StringList.List parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StringList.List parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StringList.List parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static StringList.List parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static StringList.List parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static StringList.List parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static StringList.List parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static StringList.List parseFrom(
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
    public static Builder newBuilder(StringList.List prototype) {
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
     * Protobuf type {@code List}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:List)
        StringList.ListOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return StringList.internal_static_List_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return StringList.internal_static_List_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                StringList.List.class, StringList.List.Builder.class);
      }

      // Construct using StringList.List.newBuilder()
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
        item_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return StringList.internal_static_List_descriptor;
      }

      public StringList.List getDefaultInstanceForType() {
        return StringList.List.getDefaultInstance();
      }

      public StringList.List build() {
        StringList.List result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public StringList.List buildPartial() {
        StringList.List result = new StringList.List(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          item_ = item_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.item_ = item_;
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
        if (other instanceof StringList.List) {
          return mergeFrom((StringList.List)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(StringList.List other) {
        if (other == StringList.List.getDefaultInstance()) return this;
        if (!other.item_.isEmpty()) {
          if (item_.isEmpty()) {
            item_ = other.item_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureItemIsMutable();
            item_.addAll(other.item_);
          }
          onChanged();
        }
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
        StringList.List parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (StringList.List) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.LazyStringList item_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureItemIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          item_ = new com.google.protobuf.LazyStringArrayList(item_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public com.google.protobuf.ProtocolStringList
          getItemList() {
        return item_.getUnmodifiableView();
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public int getItemCount() {
        return item_.size();
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public java.lang.String getItem(int index) {
        return item_.get(index);
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public com.google.protobuf.ByteString
          getItemBytes(int index) {
        return item_.getByteString(index);
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public Builder setItem(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureItemIsMutable();
        item_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public Builder addItem(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureItemIsMutable();
        item_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public Builder addAllItem(
          java.lang.Iterable<java.lang.String> values) {
        ensureItemIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, item_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public Builder clearItem() {
        item_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string item = 1;</code>
       */
      public Builder addItemBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureItemIsMutable();
        item_.add(value);
        onChanged();
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


      // @@protoc_insertion_point(builder_scope:List)
    }

    // @@protoc_insertion_point(class_scope:List)
    private static final StringList.List DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new StringList.List();
    }

    public static StringList.List getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<List>
        PARSER = new com.google.protobuf.AbstractParser<List>() {
      public List parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new List(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<List> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<List> getParserForType() {
      return PARSER;
    }

    public StringList.List getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_List_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_List_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020StringList.proto\"\024\n\004List\022\014\n\004item\030\001 \003(\t" +
      "B\014B\nStringListb\006proto3"
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
    internal_static_List_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_List_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_List_descriptor,
        new java.lang.String[] { "Item", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
