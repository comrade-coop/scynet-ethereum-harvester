package kafka.balanceLastSeen.distribution.messages;

public final class MatrixBlob {
  private MatrixBlob() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ShapeOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Shape)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated uint32 dimension = 1;</code>
     */
    java.util.List<java.lang.Integer> getDimensionList();
    /**
     * <code>repeated uint32 dimension = 1;</code>
     */
    int getDimensionCount();
    /**
     * <code>repeated uint32 dimension = 1;</code>
     */
    int getDimension(int index);
  }
  /**
   * Protobuf type {@code Shape}
   */
  public  static final class Shape extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Shape)
      ShapeOrBuilder {
    // Use Shape.newBuilder() to construct.
    private Shape(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Shape() {
      dimension_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Shape(
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
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                dimension_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              dimension_.add(input.readUInt32());
              break;
            }
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
                dimension_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              while (input.getBytesUntilLimit() > 0) {
                dimension_.add(input.readUInt32());
              }
              input.popLimit(limit);
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
          dimension_ = java.util.Collections.unmodifiableList(dimension_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MatrixBlob.internal_static_Shape_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MatrixBlob.internal_static_Shape_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MatrixBlob.Shape.class, MatrixBlob.Shape.Builder.class);
    }

    public static final int DIMENSION_FIELD_NUMBER = 1;
    private java.util.List<java.lang.Integer> dimension_;
    /**
     * <code>repeated uint32 dimension = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getDimensionList() {
      return dimension_;
    }
    /**
     * <code>repeated uint32 dimension = 1;</code>
     */
    public int getDimensionCount() {
      return dimension_.size();
    }
    /**
     * <code>repeated uint32 dimension = 1;</code>
     */
    public int getDimension(int index) {
      return dimension_.get(index);
    }
    private int dimensionMemoizedSerializedSize = -1;

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
      getSerializedSize();
      if (getDimensionList().size() > 0) {
        output.writeUInt32NoTag(10);
        output.writeUInt32NoTag(dimensionMemoizedSerializedSize);
      }
      for (int i = 0; i < dimension_.size(); i++) {
        output.writeUInt32NoTag(dimension_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < dimension_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeUInt32SizeNoTag(dimension_.get(i));
        }
        size += dataSize;
        if (!getDimensionList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        dimensionMemoizedSerializedSize = dataSize;
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
      if (!(obj instanceof MatrixBlob.Shape)) {
        return super.equals(obj);
      }
      MatrixBlob.Shape other = (MatrixBlob.Shape) obj;

      boolean result = true;
      result = result && getDimensionList()
          .equals(other.getDimensionList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (getDimensionCount() > 0) {
        hash = (37 * hash) + DIMENSION_FIELD_NUMBER;
        hash = (53 * hash) + getDimensionList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static MatrixBlob.Shape parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MatrixBlob.Shape parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MatrixBlob.Shape parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MatrixBlob.Shape parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MatrixBlob.Shape parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MatrixBlob.Shape parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static MatrixBlob.Shape parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static MatrixBlob.Shape parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static MatrixBlob.Shape parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MatrixBlob.Shape parseFrom(
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
    public static Builder newBuilder(MatrixBlob.Shape prototype) {
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
     * Protobuf type {@code Shape}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Shape)
        MatrixBlob.ShapeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MatrixBlob.internal_static_Shape_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MatrixBlob.internal_static_Shape_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MatrixBlob.Shape.class, MatrixBlob.Shape.Builder.class);
      }

      // Construct using MatrixBlob.Shape.newBuilder()
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
        dimension_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MatrixBlob.internal_static_Shape_descriptor;
      }

      public MatrixBlob.Shape getDefaultInstanceForType() {
        return MatrixBlob.Shape.getDefaultInstance();
      }

      public MatrixBlob.Shape build() {
        MatrixBlob.Shape result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public MatrixBlob.Shape buildPartial() {
        MatrixBlob.Shape result = new MatrixBlob.Shape(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          dimension_ = java.util.Collections.unmodifiableList(dimension_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dimension_ = dimension_;
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
        if (other instanceof MatrixBlob.Shape) {
          return mergeFrom((MatrixBlob.Shape)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MatrixBlob.Shape other) {
        if (other == MatrixBlob.Shape.getDefaultInstance()) return this;
        if (!other.dimension_.isEmpty()) {
          if (dimension_.isEmpty()) {
            dimension_ = other.dimension_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDimensionIsMutable();
            dimension_.addAll(other.dimension_);
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
        MatrixBlob.Shape parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MatrixBlob.Shape) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<java.lang.Integer> dimension_ = java.util.Collections.emptyList();
      private void ensureDimensionIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          dimension_ = new java.util.ArrayList<java.lang.Integer>(dimension_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public java.util.List<java.lang.Integer>
          getDimensionList() {
        return java.util.Collections.unmodifiableList(dimension_);
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public int getDimensionCount() {
        return dimension_.size();
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public int getDimension(int index) {
        return dimension_.get(index);
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public Builder setDimension(
          int index, int value) {
        ensureDimensionIsMutable();
        dimension_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public Builder addDimension(int value) {
        ensureDimensionIsMutable();
        dimension_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public Builder addAllDimension(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureDimensionIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dimension_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated uint32 dimension = 1;</code>
       */
      public Builder clearDimension() {
        dimension_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
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


      // @@protoc_insertion_point(builder_scope:Shape)
    }

    // @@protoc_insertion_point(class_scope:Shape)
    private static final MatrixBlob.Shape DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MatrixBlob.Shape();
    }

    public static MatrixBlob.Shape getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Shape>
        PARSER = new com.google.protobuf.AbstractParser<Shape>() {
      public Shape parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Shape(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Shape> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Shape> getParserForType() {
      return PARSER;
    }

    public MatrixBlob.Shape getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface BlobOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Blob)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional .Shape shape = 7;</code>
     */
    boolean hasShape();
    /**
     * <code>optional .Shape shape = 7;</code>
     */
    MatrixBlob.Shape getShape();
    /**
     * <code>optional .Shape shape = 7;</code>
     */
    MatrixBlob.ShapeOrBuilder getShapeOrBuilder();

    /**
     * <code>repeated float data = 5 [packed = true];</code>
     */
    java.util.List<java.lang.Float> getDataList();
    /**
     * <code>repeated float data = 5 [packed = true];</code>
     */
    int getDataCount();
    /**
     * <code>repeated float data = 5 [packed = true];</code>
     */
    float getData(int index);

    /**
     * <code>repeated float diff = 6 [packed = true];</code>
     */
    java.util.List<java.lang.Float> getDiffList();
    /**
     * <code>repeated float diff = 6 [packed = true];</code>
     */
    int getDiffCount();
    /**
     * <code>repeated float diff = 6 [packed = true];</code>
     */
    float getDiff(int index);

    /**
     * <code>repeated double double_data = 8 [packed = true];</code>
     */
    java.util.List<java.lang.Double> getDoubleDataList();
    /**
     * <code>repeated double double_data = 8 [packed = true];</code>
     */
    int getDoubleDataCount();
    /**
     * <code>repeated double double_data = 8 [packed = true];</code>
     */
    double getDoubleData(int index);

    /**
     * <code>repeated double double_diff = 9 [packed = true];</code>
     */
    java.util.List<java.lang.Double> getDoubleDiffList();
    /**
     * <code>repeated double double_diff = 9 [packed = true];</code>
     */
    int getDoubleDiffCount();
    /**
     * <code>repeated double double_diff = 9 [packed = true];</code>
     */
    double getDoubleDiff(int index);
  }
  /**
   * Protobuf type {@code Blob}
   */
  public  static final class Blob extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Blob)
      BlobOrBuilder {
    // Use Blob.newBuilder() to construct.
    private Blob(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Blob() {
      data_ = java.util.Collections.emptyList();
      diff_ = java.util.Collections.emptyList();
      doubleData_ = java.util.Collections.emptyList();
      doubleDiff_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Blob(
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
            case 45: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                data_ = new java.util.ArrayList<java.lang.Float>();
                mutable_bitField0_ |= 0x00000002;
              }
              data_.add(input.readFloat());
              break;
            }
            case 42: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
                data_ = new java.util.ArrayList<java.lang.Float>();
                mutable_bitField0_ |= 0x00000002;
              }
              while (input.getBytesUntilLimit() > 0) {
                data_.add(input.readFloat());
              }
              input.popLimit(limit);
              break;
            }
            case 53: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                diff_ = new java.util.ArrayList<java.lang.Float>();
                mutable_bitField0_ |= 0x00000004;
              }
              diff_.add(input.readFloat());
              break;
            }
            case 50: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004) && input.getBytesUntilLimit() > 0) {
                diff_ = new java.util.ArrayList<java.lang.Float>();
                mutable_bitField0_ |= 0x00000004;
              }
              while (input.getBytesUntilLimit() > 0) {
                diff_.add(input.readFloat());
              }
              input.popLimit(limit);
              break;
            }
            case 58: {
              MatrixBlob.Shape.Builder subBuilder = null;
              if (shape_ != null) {
                subBuilder = shape_.toBuilder();
              }
              shape_ = input.readMessage(MatrixBlob.Shape.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(shape_);
                shape_ = subBuilder.buildPartial();
              }

              break;
            }
            case 65: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                doubleData_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000008;
              }
              doubleData_.add(input.readDouble());
              break;
            }
            case 66: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008) && input.getBytesUntilLimit() > 0) {
                doubleData_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000008;
              }
              while (input.getBytesUntilLimit() > 0) {
                doubleData_.add(input.readDouble());
              }
              input.popLimit(limit);
              break;
            }
            case 73: {
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                doubleDiff_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000010;
              }
              doubleDiff_.add(input.readDouble());
              break;
            }
            case 74: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010) && input.getBytesUntilLimit() > 0) {
                doubleDiff_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000010;
              }
              while (input.getBytesUntilLimit() > 0) {
                doubleDiff_.add(input.readDouble());
              }
              input.popLimit(limit);
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
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          data_ = java.util.Collections.unmodifiableList(data_);
        }
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          diff_ = java.util.Collections.unmodifiableList(diff_);
        }
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          doubleData_ = java.util.Collections.unmodifiableList(doubleData_);
        }
        if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
          doubleDiff_ = java.util.Collections.unmodifiableList(doubleDiff_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MatrixBlob.internal_static_Blob_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MatrixBlob.internal_static_Blob_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MatrixBlob.Blob.class, MatrixBlob.Blob.Builder.class);
    }

    private int bitField0_;
    public static final int SHAPE_FIELD_NUMBER = 7;
    private MatrixBlob.Shape shape_;
    /**
     * <code>optional .Shape shape = 7;</code>
     */
    public boolean hasShape() {
      return shape_ != null;
    }
    /**
     * <code>optional .Shape shape = 7;</code>
     */
    public MatrixBlob.Shape getShape() {
      return shape_ == null ? MatrixBlob.Shape.getDefaultInstance() : shape_;
    }
    /**
     * <code>optional .Shape shape = 7;</code>
     */
    public MatrixBlob.ShapeOrBuilder getShapeOrBuilder() {
      return getShape();
    }

    public static final int DATA_FIELD_NUMBER = 5;
    private java.util.List<java.lang.Float> data_;
    /**
     * <code>repeated float data = 5 [packed = true];</code>
     */
    public java.util.List<java.lang.Float>
        getDataList() {
      return data_;
    }
    /**
     * <code>repeated float data = 5 [packed = true];</code>
     */
    public int getDataCount() {
      return data_.size();
    }
    /**
     * <code>repeated float data = 5 [packed = true];</code>
     */
    public float getData(int index) {
      return data_.get(index);
    }
    private int dataMemoizedSerializedSize = -1;

    public static final int DIFF_FIELD_NUMBER = 6;
    private java.util.List<java.lang.Float> diff_;
    /**
     * <code>repeated float diff = 6 [packed = true];</code>
     */
    public java.util.List<java.lang.Float>
        getDiffList() {
      return diff_;
    }
    /**
     * <code>repeated float diff = 6 [packed = true];</code>
     */
    public int getDiffCount() {
      return diff_.size();
    }
    /**
     * <code>repeated float diff = 6 [packed = true];</code>
     */
    public float getDiff(int index) {
      return diff_.get(index);
    }
    private int diffMemoizedSerializedSize = -1;

    public static final int DOUBLE_DATA_FIELD_NUMBER = 8;
    private java.util.List<java.lang.Double> doubleData_;
    /**
     * <code>repeated double double_data = 8 [packed = true];</code>
     */
    public java.util.List<java.lang.Double>
        getDoubleDataList() {
      return doubleData_;
    }
    /**
     * <code>repeated double double_data = 8 [packed = true];</code>
     */
    public int getDoubleDataCount() {
      return doubleData_.size();
    }
    /**
     * <code>repeated double double_data = 8 [packed = true];</code>
     */
    public double getDoubleData(int index) {
      return doubleData_.get(index);
    }
    private int doubleDataMemoizedSerializedSize = -1;

    public static final int DOUBLE_DIFF_FIELD_NUMBER = 9;
    private java.util.List<java.lang.Double> doubleDiff_;
    /**
     * <code>repeated double double_diff = 9 [packed = true];</code>
     */
    public java.util.List<java.lang.Double>
        getDoubleDiffList() {
      return doubleDiff_;
    }
    /**
     * <code>repeated double double_diff = 9 [packed = true];</code>
     */
    public int getDoubleDiffCount() {
      return doubleDiff_.size();
    }
    /**
     * <code>repeated double double_diff = 9 [packed = true];</code>
     */
    public double getDoubleDiff(int index) {
      return doubleDiff_.get(index);
    }
    private int doubleDiffMemoizedSerializedSize = -1;

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
      getSerializedSize();
      if (getDataList().size() > 0) {
        output.writeUInt32NoTag(42);
        output.writeUInt32NoTag(dataMemoizedSerializedSize);
      }
      for (int i = 0; i < data_.size(); i++) {
        output.writeFloatNoTag(data_.get(i));
      }
      if (getDiffList().size() > 0) {
        output.writeUInt32NoTag(50);
        output.writeUInt32NoTag(diffMemoizedSerializedSize);
      }
      for (int i = 0; i < diff_.size(); i++) {
        output.writeFloatNoTag(diff_.get(i));
      }
      if (shape_ != null) {
        output.writeMessage(7, getShape());
      }
      if (getDoubleDataList().size() > 0) {
        output.writeUInt32NoTag(66);
        output.writeUInt32NoTag(doubleDataMemoizedSerializedSize);
      }
      for (int i = 0; i < doubleData_.size(); i++) {
        output.writeDoubleNoTag(doubleData_.get(i));
      }
      if (getDoubleDiffList().size() > 0) {
        output.writeUInt32NoTag(74);
        output.writeUInt32NoTag(doubleDiffMemoizedSerializedSize);
      }
      for (int i = 0; i < doubleDiff_.size(); i++) {
        output.writeDoubleNoTag(doubleDiff_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        dataSize = 4 * getDataList().size();
        size += dataSize;
        if (!getDataList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        dataMemoizedSerializedSize = dataSize;
      }
      {
        int dataSize = 0;
        dataSize = 4 * getDiffList().size();
        size += dataSize;
        if (!getDiffList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        diffMemoizedSerializedSize = dataSize;
      }
      if (shape_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(7, getShape());
      }
      {
        int dataSize = 0;
        dataSize = 8 * getDoubleDataList().size();
        size += dataSize;
        if (!getDoubleDataList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        doubleDataMemoizedSerializedSize = dataSize;
      }
      {
        int dataSize = 0;
        dataSize = 8 * getDoubleDiffList().size();
        size += dataSize;
        if (!getDoubleDiffList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        doubleDiffMemoizedSerializedSize = dataSize;
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
      if (!(obj instanceof MatrixBlob.Blob)) {
        return super.equals(obj);
      }
      MatrixBlob.Blob other = (MatrixBlob.Blob) obj;

      boolean result = true;
      result = result && (hasShape() == other.hasShape());
      if (hasShape()) {
        result = result && getShape()
            .equals(other.getShape());
      }
      result = result && getDataList()
          .equals(other.getDataList());
      result = result && getDiffList()
          .equals(other.getDiffList());
      result = result && getDoubleDataList()
          .equals(other.getDoubleDataList());
      result = result && getDoubleDiffList()
          .equals(other.getDoubleDiffList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasShape()) {
        hash = (37 * hash) + SHAPE_FIELD_NUMBER;
        hash = (53 * hash) + getShape().hashCode();
      }
      if (getDataCount() > 0) {
        hash = (37 * hash) + DATA_FIELD_NUMBER;
        hash = (53 * hash) + getDataList().hashCode();
      }
      if (getDiffCount() > 0) {
        hash = (37 * hash) + DIFF_FIELD_NUMBER;
        hash = (53 * hash) + getDiffList().hashCode();
      }
      if (getDoubleDataCount() > 0) {
        hash = (37 * hash) + DOUBLE_DATA_FIELD_NUMBER;
        hash = (53 * hash) + getDoubleDataList().hashCode();
      }
      if (getDoubleDiffCount() > 0) {
        hash = (37 * hash) + DOUBLE_DIFF_FIELD_NUMBER;
        hash = (53 * hash) + getDoubleDiffList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static MatrixBlob.Blob parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MatrixBlob.Blob parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MatrixBlob.Blob parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MatrixBlob.Blob parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MatrixBlob.Blob parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MatrixBlob.Blob parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static MatrixBlob.Blob parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static MatrixBlob.Blob parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static MatrixBlob.Blob parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MatrixBlob.Blob parseFrom(
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
    public static Builder newBuilder(MatrixBlob.Blob prototype) {
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
     * Protobuf type {@code Blob}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Blob)
        MatrixBlob.BlobOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MatrixBlob.internal_static_Blob_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MatrixBlob.internal_static_Blob_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MatrixBlob.Blob.class, MatrixBlob.Blob.Builder.class);
      }

      // Construct using MatrixBlob.Blob.newBuilder()
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
        if (shapeBuilder_ == null) {
          shape_ = null;
        } else {
          shape_ = null;
          shapeBuilder_ = null;
        }
        data_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        diff_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        doubleData_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        doubleDiff_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MatrixBlob.internal_static_Blob_descriptor;
      }

      public MatrixBlob.Blob getDefaultInstanceForType() {
        return MatrixBlob.Blob.getDefaultInstance();
      }

      public MatrixBlob.Blob build() {
        MatrixBlob.Blob result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public MatrixBlob.Blob buildPartial() {
        MatrixBlob.Blob result = new MatrixBlob.Blob(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (shapeBuilder_ == null) {
          result.shape_ = shape_;
        } else {
          result.shape_ = shapeBuilder_.build();
        }
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          data_ = java.util.Collections.unmodifiableList(data_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.data_ = data_;
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          diff_ = java.util.Collections.unmodifiableList(diff_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.diff_ = diff_;
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          doubleData_ = java.util.Collections.unmodifiableList(doubleData_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.doubleData_ = doubleData_;
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          doubleDiff_ = java.util.Collections.unmodifiableList(doubleDiff_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.doubleDiff_ = doubleDiff_;
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
        if (other instanceof MatrixBlob.Blob) {
          return mergeFrom((MatrixBlob.Blob)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MatrixBlob.Blob other) {
        if (other == MatrixBlob.Blob.getDefaultInstance()) return this;
        if (other.hasShape()) {
          mergeShape(other.getShape());
        }
        if (!other.data_.isEmpty()) {
          if (data_.isEmpty()) {
            data_ = other.data_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureDataIsMutable();
            data_.addAll(other.data_);
          }
          onChanged();
        }
        if (!other.diff_.isEmpty()) {
          if (diff_.isEmpty()) {
            diff_ = other.diff_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureDiffIsMutable();
            diff_.addAll(other.diff_);
          }
          onChanged();
        }
        if (!other.doubleData_.isEmpty()) {
          if (doubleData_.isEmpty()) {
            doubleData_ = other.doubleData_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDoubleDataIsMutable();
            doubleData_.addAll(other.doubleData_);
          }
          onChanged();
        }
        if (!other.doubleDiff_.isEmpty()) {
          if (doubleDiff_.isEmpty()) {
            doubleDiff_ = other.doubleDiff_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureDoubleDiffIsMutable();
            doubleDiff_.addAll(other.doubleDiff_);
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
        MatrixBlob.Blob parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MatrixBlob.Blob) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private MatrixBlob.Shape shape_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          MatrixBlob.Shape, MatrixBlob.Shape.Builder, MatrixBlob.ShapeOrBuilder> shapeBuilder_;
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public boolean hasShape() {
        return shapeBuilder_ != null || shape_ != null;
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public MatrixBlob.Shape getShape() {
        if (shapeBuilder_ == null) {
          return shape_ == null ? MatrixBlob.Shape.getDefaultInstance() : shape_;
        } else {
          return shapeBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public Builder setShape(MatrixBlob.Shape value) {
        if (shapeBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          shape_ = value;
          onChanged();
        } else {
          shapeBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public Builder setShape(
          MatrixBlob.Shape.Builder builderForValue) {
        if (shapeBuilder_ == null) {
          shape_ = builderForValue.build();
          onChanged();
        } else {
          shapeBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public Builder mergeShape(MatrixBlob.Shape value) {
        if (shapeBuilder_ == null) {
          if (shape_ != null) {
            shape_ =
              MatrixBlob.Shape.newBuilder(shape_).mergeFrom(value).buildPartial();
          } else {
            shape_ = value;
          }
          onChanged();
        } else {
          shapeBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public Builder clearShape() {
        if (shapeBuilder_ == null) {
          shape_ = null;
          onChanged();
        } else {
          shape_ = null;
          shapeBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public MatrixBlob.Shape.Builder getShapeBuilder() {
        
        onChanged();
        return getShapeFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      public MatrixBlob.ShapeOrBuilder getShapeOrBuilder() {
        if (shapeBuilder_ != null) {
          return shapeBuilder_.getMessageOrBuilder();
        } else {
          return shape_ == null ?
              MatrixBlob.Shape.getDefaultInstance() : shape_;
        }
      }
      /**
       * <code>optional .Shape shape = 7;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          MatrixBlob.Shape, MatrixBlob.Shape.Builder, MatrixBlob.ShapeOrBuilder> 
          getShapeFieldBuilder() {
        if (shapeBuilder_ == null) {
          shapeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              MatrixBlob.Shape, MatrixBlob.Shape.Builder, MatrixBlob.ShapeOrBuilder>(
                  getShape(),
                  getParentForChildren(),
                  isClean());
          shape_ = null;
        }
        return shapeBuilder_;
      }

      private java.util.List<java.lang.Float> data_ = java.util.Collections.emptyList();
      private void ensureDataIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          data_ = new java.util.ArrayList<java.lang.Float>(data_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public java.util.List<java.lang.Float>
          getDataList() {
        return java.util.Collections.unmodifiableList(data_);
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public int getDataCount() {
        return data_.size();
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public float getData(int index) {
        return data_.get(index);
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public Builder setData(
          int index, float value) {
        ensureDataIsMutable();
        data_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public Builder addData(float value) {
        ensureDataIsMutable();
        data_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public Builder addAllData(
          java.lang.Iterable<? extends java.lang.Float> values) {
        ensureDataIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, data_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float data = 5 [packed = true];</code>
       */
      public Builder clearData() {
        data_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Float> diff_ = java.util.Collections.emptyList();
      private void ensureDiffIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          diff_ = new java.util.ArrayList<java.lang.Float>(diff_);
          bitField0_ |= 0x00000004;
         }
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public java.util.List<java.lang.Float>
          getDiffList() {
        return java.util.Collections.unmodifiableList(diff_);
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public int getDiffCount() {
        return diff_.size();
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public float getDiff(int index) {
        return diff_.get(index);
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public Builder setDiff(
          int index, float value) {
        ensureDiffIsMutable();
        diff_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public Builder addDiff(float value) {
        ensureDiffIsMutable();
        diff_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public Builder addAllDiff(
          java.lang.Iterable<? extends java.lang.Float> values) {
        ensureDiffIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, diff_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float diff = 6 [packed = true];</code>
       */
      public Builder clearDiff() {
        diff_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Double> doubleData_ = java.util.Collections.emptyList();
      private void ensureDoubleDataIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          doubleData_ = new java.util.ArrayList<java.lang.Double>(doubleData_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public java.util.List<java.lang.Double>
          getDoubleDataList() {
        return java.util.Collections.unmodifiableList(doubleData_);
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public int getDoubleDataCount() {
        return doubleData_.size();
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public double getDoubleData(int index) {
        return doubleData_.get(index);
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public Builder setDoubleData(
          int index, double value) {
        ensureDoubleDataIsMutable();
        doubleData_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public Builder addDoubleData(double value) {
        ensureDoubleDataIsMutable();
        doubleData_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public Builder addAllDoubleData(
          java.lang.Iterable<? extends java.lang.Double> values) {
        ensureDoubleDataIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, doubleData_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double double_data = 8 [packed = true];</code>
       */
      public Builder clearDoubleData() {
        doubleData_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Double> doubleDiff_ = java.util.Collections.emptyList();
      private void ensureDoubleDiffIsMutable() {
        if (!((bitField0_ & 0x00000010) == 0x00000010)) {
          doubleDiff_ = new java.util.ArrayList<java.lang.Double>(doubleDiff_);
          bitField0_ |= 0x00000010;
         }
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public java.util.List<java.lang.Double>
          getDoubleDiffList() {
        return java.util.Collections.unmodifiableList(doubleDiff_);
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public int getDoubleDiffCount() {
        return doubleDiff_.size();
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public double getDoubleDiff(int index) {
        return doubleDiff_.get(index);
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public Builder setDoubleDiff(
          int index, double value) {
        ensureDoubleDiffIsMutable();
        doubleDiff_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public Builder addDoubleDiff(double value) {
        ensureDoubleDiffIsMutable();
        doubleDiff_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public Builder addAllDoubleDiff(
          java.lang.Iterable<? extends java.lang.Double> values) {
        ensureDoubleDiffIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, doubleDiff_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double double_diff = 9 [packed = true];</code>
       */
      public Builder clearDoubleDiff() {
        doubleDiff_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
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


      // @@protoc_insertion_point(builder_scope:Blob)
    }

    // @@protoc_insertion_point(class_scope:Blob)
    private static final MatrixBlob.Blob DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MatrixBlob.Blob();
    }

    public static MatrixBlob.Blob getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Blob>
        PARSER = new com.google.protobuf.AbstractParser<Blob>() {
      public Blob parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Blob(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Blob> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Blob> getParserForType() {
      return PARSER;
    }

    public MatrixBlob.Blob getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Shape_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Shape_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Blob_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Blob_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nBlob.proto\"\032\n\005Shape\022\021\n\tdimension\030\001 \003(\r" +
      "\"s\n\004Blob\022\025\n\005shape\030\007 \001(\0132\006.Shape\022\020\n\004data\030" +
      "\005 \003(\002B\002\020\001\022\020\n\004diff\030\006 \003(\002B\002\020\001\022\027\n\013double_da" +
      "ta\030\010 \003(\001B\002\020\001\022\027\n\013double_diff\030\t \003(\001B\002\020\001B\014B" +
      "\nMatrixBlobb\006proto3"
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
    internal_static_Shape_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Shape_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Shape_descriptor,
        new java.lang.String[] { "Dimension", });
    internal_static_Blob_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Blob_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Blob_descriptor,
        new java.lang.String[] { "Shape", "Data", "Diff", "DoubleData", "DoubleDiff", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
