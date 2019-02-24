package kafka.blockchain.producer.messages;

public final class Messages {
  private Messages() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface BlockOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Block)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string hash = 1;</code>
     */
    java.lang.String getHash();
    /**
     * <code>optional string hash = 1;</code>
     */
    com.google.protobuf.ByteString
        getHashBytes();

    /**
     * <code>optional string number = 2;</code>
     */
    java.lang.String getNumber();
    /**
     * <code>optional string number = 2;</code>
     */
    com.google.protobuf.ByteString
        getNumberBytes();

    /**
     * <code>optional string timestamp = 3;</code>
     */
    java.lang.String getTimestamp();
    /**
     * <code>optional string timestamp = 3;</code>
     */
    com.google.protobuf.ByteString
        getTimestampBytes();

    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    java.util.List<Messages.Transaction> 
        getTransactionsList();
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    Messages.Transaction getTransactions(int index);
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    int getTransactionsCount();
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    java.util.List<? extends Messages.TransactionOrBuilder> 
        getTransactionsOrBuilderList();
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    Messages.TransactionOrBuilder getTransactionsOrBuilder(
        int index);

    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    java.util.List<Messages.Trace> 
        getTracesList();
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    Messages.Trace getTraces(int index);
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    int getTracesCount();
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    java.util.List<? extends Messages.TraceOrBuilder> 
        getTracesOrBuilderList();
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    Messages.TraceOrBuilder getTracesOrBuilder(
        int index);

    /**
     * <code>optional string author = 6;</code>
     */
    java.lang.String getAuthor();
    /**
     * <code>optional string author = 6;</code>
     */
    com.google.protobuf.ByteString
        getAuthorBytes();
  }
  /**
   * Protobuf type {@code Block}
   */
  public  static final class Block extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Block)
      BlockOrBuilder {
    // Use Block.newBuilder() to construct.
    private Block(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Block() {
      hash_ = "";
      number_ = "";
      timestamp_ = "";
      transactions_ = java.util.Collections.emptyList();
      traces_ = java.util.Collections.emptyList();
      author_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Block(
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

              hash_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              number_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              timestamp_ = s;
              break;
            }
            case 34: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                transactions_ = new java.util.ArrayList<Messages.Transaction>();
                mutable_bitField0_ |= 0x00000008;
              }
              transactions_.add(
                  input.readMessage(Messages.Transaction.parser(), extensionRegistry));
              break;
            }
            case 42: {
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                traces_ = new java.util.ArrayList<Messages.Trace>();
                mutable_bitField0_ |= 0x00000010;
              }
              traces_.add(
                  input.readMessage(Messages.Trace.parser(), extensionRegistry));
              break;
            }
            case 50: {
              java.lang.String s = input.readStringRequireUtf8();

              author_ = s;
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
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          transactions_ = java.util.Collections.unmodifiableList(transactions_);
        }
        if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
          traces_ = java.util.Collections.unmodifiableList(traces_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Messages.internal_static_Block_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Block_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Block.class, Messages.Block.Builder.class);
    }

    private int bitField0_;
    public static final int HASH_FIELD_NUMBER = 1;
    private volatile java.lang.Object hash_;
    /**
     * <code>optional string hash = 1;</code>
     */
    public java.lang.String getHash() {
      java.lang.Object ref = hash_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hash_ = s;
        return s;
      }
    }
    /**
     * <code>optional string hash = 1;</code>
     */
    public com.google.protobuf.ByteString
        getHashBytes() {
      java.lang.Object ref = hash_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int NUMBER_FIELD_NUMBER = 2;
    private volatile java.lang.Object number_;
    /**
     * <code>optional string number = 2;</code>
     */
    public java.lang.String getNumber() {
      java.lang.Object ref = number_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        number_ = s;
        return s;
      }
    }
    /**
     * <code>optional string number = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNumberBytes() {
      java.lang.Object ref = number_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        number_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private volatile java.lang.Object timestamp_;
    /**
     * <code>optional string timestamp = 3;</code>
     */
    public java.lang.String getTimestamp() {
      java.lang.Object ref = timestamp_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timestamp_ = s;
        return s;
      }
    }
    /**
     * <code>optional string timestamp = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTimestampBytes() {
      java.lang.Object ref = timestamp_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        timestamp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TRANSACTIONS_FIELD_NUMBER = 4;
    private java.util.List<Messages.Transaction> transactions_;
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    public java.util.List<Messages.Transaction> getTransactionsList() {
      return transactions_;
    }
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    public java.util.List<? extends Messages.TransactionOrBuilder> 
        getTransactionsOrBuilderList() {
      return transactions_;
    }
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    public int getTransactionsCount() {
      return transactions_.size();
    }
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    public Messages.Transaction getTransactions(int index) {
      return transactions_.get(index);
    }
    /**
     * <code>repeated .Transaction transactions = 4;</code>
     */
    public Messages.TransactionOrBuilder getTransactionsOrBuilder(
        int index) {
      return transactions_.get(index);
    }

    public static final int TRACES_FIELD_NUMBER = 5;
    private java.util.List<Messages.Trace> traces_;
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    public java.util.List<Messages.Trace> getTracesList() {
      return traces_;
    }
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    public java.util.List<? extends Messages.TraceOrBuilder> 
        getTracesOrBuilderList() {
      return traces_;
    }
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    public int getTracesCount() {
      return traces_.size();
    }
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    public Messages.Trace getTraces(int index) {
      return traces_.get(index);
    }
    /**
     * <code>repeated .Trace traces = 5;</code>
     */
    public Messages.TraceOrBuilder getTracesOrBuilder(
        int index) {
      return traces_.get(index);
    }

    public static final int AUTHOR_FIELD_NUMBER = 6;
    private volatile java.lang.Object author_;
    /**
     * <code>optional string author = 6;</code>
     */
    public java.lang.String getAuthor() {
      java.lang.Object ref = author_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        author_ = s;
        return s;
      }
    }
    /**
     * <code>optional string author = 6;</code>
     */
    public com.google.protobuf.ByteString
        getAuthorBytes() {
      java.lang.Object ref = author_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        author_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getHashBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, hash_);
      }
      if (!getNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, number_);
      }
      if (!getTimestampBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, timestamp_);
      }
      for (int i = 0; i < transactions_.size(); i++) {
        output.writeMessage(4, transactions_.get(i));
      }
      for (int i = 0; i < traces_.size(); i++) {
        output.writeMessage(5, traces_.get(i));
      }
      if (!getAuthorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, author_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getHashBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, hash_);
      }
      if (!getNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, number_);
      }
      if (!getTimestampBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, timestamp_);
      }
      for (int i = 0; i < transactions_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, transactions_.get(i));
      }
      for (int i = 0; i < traces_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(5, traces_.get(i));
      }
      if (!getAuthorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, author_);
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
      if (!(obj instanceof Messages.Block)) {
        return super.equals(obj);
      }
      Messages.Block other = (Messages.Block) obj;

      boolean result = true;
      result = result && getHash()
          .equals(other.getHash());
      result = result && getNumber()
          .equals(other.getNumber());
      result = result && getTimestamp()
          .equals(other.getTimestamp());
      result = result && getTransactionsList()
          .equals(other.getTransactionsList());
      result = result && getTracesList()
          .equals(other.getTracesList());
      result = result && getAuthor()
          .equals(other.getAuthor());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + HASH_FIELD_NUMBER;
      hash = (53 * hash) + getHash().hashCode();
      hash = (37 * hash) + NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getNumber().hashCode();
      hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + getTimestamp().hashCode();
      if (getTransactionsCount() > 0) {
        hash = (37 * hash) + TRANSACTIONS_FIELD_NUMBER;
        hash = (53 * hash) + getTransactionsList().hashCode();
      }
      if (getTracesCount() > 0) {
        hash = (37 * hash) + TRACES_FIELD_NUMBER;
        hash = (53 * hash) + getTracesList().hashCode();
      }
      hash = (37 * hash) + AUTHOR_FIELD_NUMBER;
      hash = (53 * hash) + getAuthor().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Block parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Block parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Block parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Block parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Block parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Block parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Block parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Block parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Block parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Block parseFrom(
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
    public static Builder newBuilder(Messages.Block prototype) {
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
     * Protobuf type {@code Block}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Block)
        Messages.BlockOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Block_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Block_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Block.class, Messages.Block.Builder.class);
      }

      // Construct using Messages.Block.newBuilder()
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
          getTransactionsFieldBuilder();
          getTracesFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        hash_ = "";

        number_ = "";

        timestamp_ = "";

        if (transactionsBuilder_ == null) {
          transactions_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          transactionsBuilder_.clear();
        }
        if (tracesBuilder_ == null) {
          traces_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000010);
        } else {
          tracesBuilder_.clear();
        }
        author_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Block_descriptor;
      }

      public Messages.Block getDefaultInstanceForType() {
        return Messages.Block.getDefaultInstance();
      }

      public Messages.Block build() {
        Messages.Block result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Block buildPartial() {
        Messages.Block result = new Messages.Block(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.hash_ = hash_;
        result.number_ = number_;
        result.timestamp_ = timestamp_;
        if (transactionsBuilder_ == null) {
          if (((bitField0_ & 0x00000008) == 0x00000008)) {
            transactions_ = java.util.Collections.unmodifiableList(transactions_);
            bitField0_ = (bitField0_ & ~0x00000008);
          }
          result.transactions_ = transactions_;
        } else {
          result.transactions_ = transactionsBuilder_.build();
        }
        if (tracesBuilder_ == null) {
          if (((bitField0_ & 0x00000010) == 0x00000010)) {
            traces_ = java.util.Collections.unmodifiableList(traces_);
            bitField0_ = (bitField0_ & ~0x00000010);
          }
          result.traces_ = traces_;
        } else {
          result.traces_ = tracesBuilder_.build();
        }
        result.author_ = author_;
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
        if (other instanceof Messages.Block) {
          return mergeFrom((Messages.Block)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Block other) {
        if (other == Messages.Block.getDefaultInstance()) return this;
        if (!other.getHash().isEmpty()) {
          hash_ = other.hash_;
          onChanged();
        }
        if (!other.getNumber().isEmpty()) {
          number_ = other.number_;
          onChanged();
        }
        if (!other.getTimestamp().isEmpty()) {
          timestamp_ = other.timestamp_;
          onChanged();
        }
        if (transactionsBuilder_ == null) {
          if (!other.transactions_.isEmpty()) {
            if (transactions_.isEmpty()) {
              transactions_ = other.transactions_;
              bitField0_ = (bitField0_ & ~0x00000008);
            } else {
              ensureTransactionsIsMutable();
              transactions_.addAll(other.transactions_);
            }
            onChanged();
          }
        } else {
          if (!other.transactions_.isEmpty()) {
            if (transactionsBuilder_.isEmpty()) {
              transactionsBuilder_.dispose();
              transactionsBuilder_ = null;
              transactions_ = other.transactions_;
              bitField0_ = (bitField0_ & ~0x00000008);
              transactionsBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getTransactionsFieldBuilder() : null;
            } else {
              transactionsBuilder_.addAllMessages(other.transactions_);
            }
          }
        }
        if (tracesBuilder_ == null) {
          if (!other.traces_.isEmpty()) {
            if (traces_.isEmpty()) {
              traces_ = other.traces_;
              bitField0_ = (bitField0_ & ~0x00000010);
            } else {
              ensureTracesIsMutable();
              traces_.addAll(other.traces_);
            }
            onChanged();
          }
        } else {
          if (!other.traces_.isEmpty()) {
            if (tracesBuilder_.isEmpty()) {
              tracesBuilder_.dispose();
              tracesBuilder_ = null;
              traces_ = other.traces_;
              bitField0_ = (bitField0_ & ~0x00000010);
              tracesBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getTracesFieldBuilder() : null;
            } else {
              tracesBuilder_.addAllMessages(other.traces_);
            }
          }
        }
        if (!other.getAuthor().isEmpty()) {
          author_ = other.author_;
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
        Messages.Block parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Block) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object hash_ = "";
      /**
       * <code>optional string hash = 1;</code>
       */
      public java.lang.String getHash() {
        java.lang.Object ref = hash_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hash_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string hash = 1;</code>
       */
      public com.google.protobuf.ByteString
          getHashBytes() {
        java.lang.Object ref = hash_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          hash_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string hash = 1;</code>
       */
      public Builder setHash(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        hash_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string hash = 1;</code>
       */
      public Builder clearHash() {
        
        hash_ = getDefaultInstance().getHash();
        onChanged();
        return this;
      }
      /**
       * <code>optional string hash = 1;</code>
       */
      public Builder setHashBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        hash_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object number_ = "";
      /**
       * <code>optional string number = 2;</code>
       */
      public java.lang.String getNumber() {
        java.lang.Object ref = number_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          number_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string number = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNumberBytes() {
        java.lang.Object ref = number_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          number_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string number = 2;</code>
       */
      public Builder setNumber(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        number_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string number = 2;</code>
       */
      public Builder clearNumber() {
        
        number_ = getDefaultInstance().getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional string number = 2;</code>
       */
      public Builder setNumberBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        number_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object timestamp_ = "";
      /**
       * <code>optional string timestamp = 3;</code>
       */
      public java.lang.String getTimestamp() {
        java.lang.Object ref = timestamp_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          timestamp_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string timestamp = 3;</code>
       */
      public com.google.protobuf.ByteString
          getTimestampBytes() {
        java.lang.Object ref = timestamp_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          timestamp_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string timestamp = 3;</code>
       */
      public Builder setTimestamp(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        timestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string timestamp = 3;</code>
       */
      public Builder clearTimestamp() {
        
        timestamp_ = getDefaultInstance().getTimestamp();
        onChanged();
        return this;
      }
      /**
       * <code>optional string timestamp = 3;</code>
       */
      public Builder setTimestampBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        timestamp_ = value;
        onChanged();
        return this;
      }

      private java.util.List<Messages.Transaction> transactions_ =
        java.util.Collections.emptyList();
      private void ensureTransactionsIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          transactions_ = new java.util.ArrayList<Messages.Transaction>(transactions_);
          bitField0_ |= 0x00000008;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Messages.Transaction, Messages.Transaction.Builder, Messages.TransactionOrBuilder> transactionsBuilder_;

      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public java.util.List<Messages.Transaction> getTransactionsList() {
        if (transactionsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(transactions_);
        } else {
          return transactionsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public int getTransactionsCount() {
        if (transactionsBuilder_ == null) {
          return transactions_.size();
        } else {
          return transactionsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Messages.Transaction getTransactions(int index) {
        if (transactionsBuilder_ == null) {
          return transactions_.get(index);
        } else {
          return transactionsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder setTransactions(
          int index, Messages.Transaction value) {
        if (transactionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTransactionsIsMutable();
          transactions_.set(index, value);
          onChanged();
        } else {
          transactionsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder setTransactions(
          int index, Messages.Transaction.Builder builderForValue) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.set(index, builderForValue.build());
          onChanged();
        } else {
          transactionsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder addTransactions(Messages.Transaction value) {
        if (transactionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTransactionsIsMutable();
          transactions_.add(value);
          onChanged();
        } else {
          transactionsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder addTransactions(
          int index, Messages.Transaction value) {
        if (transactionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTransactionsIsMutable();
          transactions_.add(index, value);
          onChanged();
        } else {
          transactionsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder addTransactions(
          Messages.Transaction.Builder builderForValue) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.add(builderForValue.build());
          onChanged();
        } else {
          transactionsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder addTransactions(
          int index, Messages.Transaction.Builder builderForValue) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.add(index, builderForValue.build());
          onChanged();
        } else {
          transactionsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder addAllTransactions(
          java.lang.Iterable<? extends Messages.Transaction> values) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, transactions_);
          onChanged();
        } else {
          transactionsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder clearTransactions() {
        if (transactionsBuilder_ == null) {
          transactions_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000008);
          onChanged();
        } else {
          transactionsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Builder removeTransactions(int index) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.remove(index);
          onChanged();
        } else {
          transactionsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Messages.Transaction.Builder getTransactionsBuilder(
          int index) {
        return getTransactionsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Messages.TransactionOrBuilder getTransactionsOrBuilder(
          int index) {
        if (transactionsBuilder_ == null) {
          return transactions_.get(index);  } else {
          return transactionsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public java.util.List<? extends Messages.TransactionOrBuilder> 
           getTransactionsOrBuilderList() {
        if (transactionsBuilder_ != null) {
          return transactionsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(transactions_);
        }
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Messages.Transaction.Builder addTransactionsBuilder() {
        return getTransactionsFieldBuilder().addBuilder(
            Messages.Transaction.getDefaultInstance());
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public Messages.Transaction.Builder addTransactionsBuilder(
          int index) {
        return getTransactionsFieldBuilder().addBuilder(
            index, Messages.Transaction.getDefaultInstance());
      }
      /**
       * <code>repeated .Transaction transactions = 4;</code>
       */
      public java.util.List<Messages.Transaction.Builder> 
           getTransactionsBuilderList() {
        return getTransactionsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Messages.Transaction, Messages.Transaction.Builder, Messages.TransactionOrBuilder> 
          getTransactionsFieldBuilder() {
        if (transactionsBuilder_ == null) {
          transactionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Messages.Transaction, Messages.Transaction.Builder, Messages.TransactionOrBuilder>(
                  transactions_,
                  ((bitField0_ & 0x00000008) == 0x00000008),
                  getParentForChildren(),
                  isClean());
          transactions_ = null;
        }
        return transactionsBuilder_;
      }

      private java.util.List<Messages.Trace> traces_ =
        java.util.Collections.emptyList();
      private void ensureTracesIsMutable() {
        if (!((bitField0_ & 0x00000010) == 0x00000010)) {
          traces_ = new java.util.ArrayList<Messages.Trace>(traces_);
          bitField0_ |= 0x00000010;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Messages.Trace, Messages.Trace.Builder, Messages.TraceOrBuilder> tracesBuilder_;

      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public java.util.List<Messages.Trace> getTracesList() {
        if (tracesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(traces_);
        } else {
          return tracesBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public int getTracesCount() {
        if (tracesBuilder_ == null) {
          return traces_.size();
        } else {
          return tracesBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Messages.Trace getTraces(int index) {
        if (tracesBuilder_ == null) {
          return traces_.get(index);
        } else {
          return tracesBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder setTraces(
          int index, Messages.Trace value) {
        if (tracesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTracesIsMutable();
          traces_.set(index, value);
          onChanged();
        } else {
          tracesBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder setTraces(
          int index, Messages.Trace.Builder builderForValue) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.set(index, builderForValue.build());
          onChanged();
        } else {
          tracesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder addTraces(Messages.Trace value) {
        if (tracesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTracesIsMutable();
          traces_.add(value);
          onChanged();
        } else {
          tracesBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder addTraces(
          int index, Messages.Trace value) {
        if (tracesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTracesIsMutable();
          traces_.add(index, value);
          onChanged();
        } else {
          tracesBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder addTraces(
          Messages.Trace.Builder builderForValue) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.add(builderForValue.build());
          onChanged();
        } else {
          tracesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder addTraces(
          int index, Messages.Trace.Builder builderForValue) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.add(index, builderForValue.build());
          onChanged();
        } else {
          tracesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder addAllTraces(
          java.lang.Iterable<? extends Messages.Trace> values) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, traces_);
          onChanged();
        } else {
          tracesBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder clearTraces() {
        if (tracesBuilder_ == null) {
          traces_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000010);
          onChanged();
        } else {
          tracesBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Builder removeTraces(int index) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.remove(index);
          onChanged();
        } else {
          tracesBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Messages.Trace.Builder getTracesBuilder(
          int index) {
        return getTracesFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Messages.TraceOrBuilder getTracesOrBuilder(
          int index) {
        if (tracesBuilder_ == null) {
          return traces_.get(index);  } else {
          return tracesBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public java.util.List<? extends Messages.TraceOrBuilder> 
           getTracesOrBuilderList() {
        if (tracesBuilder_ != null) {
          return tracesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(traces_);
        }
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Messages.Trace.Builder addTracesBuilder() {
        return getTracesFieldBuilder().addBuilder(
            Messages.Trace.getDefaultInstance());
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public Messages.Trace.Builder addTracesBuilder(
          int index) {
        return getTracesFieldBuilder().addBuilder(
            index, Messages.Trace.getDefaultInstance());
      }
      /**
       * <code>repeated .Trace traces = 5;</code>
       */
      public java.util.List<Messages.Trace.Builder> 
           getTracesBuilderList() {
        return getTracesFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Messages.Trace, Messages.Trace.Builder, Messages.TraceOrBuilder> 
          getTracesFieldBuilder() {
        if (tracesBuilder_ == null) {
          tracesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Messages.Trace, Messages.Trace.Builder, Messages.TraceOrBuilder>(
                  traces_,
                  ((bitField0_ & 0x00000010) == 0x00000010),
                  getParentForChildren(),
                  isClean());
          traces_ = null;
        }
        return tracesBuilder_;
      }

      private java.lang.Object author_ = "";
      /**
       * <code>optional string author = 6;</code>
       */
      public java.lang.String getAuthor() {
        java.lang.Object ref = author_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          author_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string author = 6;</code>
       */
      public com.google.protobuf.ByteString
          getAuthorBytes() {
        java.lang.Object ref = author_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          author_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string author = 6;</code>
       */
      public Builder setAuthor(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        author_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string author = 6;</code>
       */
      public Builder clearAuthor() {
        
        author_ = getDefaultInstance().getAuthor();
        onChanged();
        return this;
      }
      /**
       * <code>optional string author = 6;</code>
       */
      public Builder setAuthorBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        author_ = value;
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


      // @@protoc_insertion_point(builder_scope:Block)
    }

    // @@protoc_insertion_point(class_scope:Block)
    private static final Messages.Block DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Block();
    }

    public static Messages.Block getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Block>
        PARSER = new com.google.protobuf.AbstractParser<Block>() {
      public Block parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Block(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Block> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Block> getParserForType() {
      return PARSER;
    }

    public Messages.Block getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface TransactionOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Transaction)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional .Receipt receipt = 1;</code>
     */
    boolean hasReceipt();
    /**
     * <code>optional .Receipt receipt = 1;</code>
     */
    Messages.Receipt getReceipt();
    /**
     * <code>optional .Receipt receipt = 1;</code>
     */
    Messages.ReceiptOrBuilder getReceiptOrBuilder();

    /**
     * <code>optional uint64 chainId = 2;</code>
     */
    long getChainId();

    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    java.util.List<Messages.Trace> 
        getTracesList();
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    Messages.Trace getTraces(int index);
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    int getTracesCount();
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    java.util.List<? extends Messages.TraceOrBuilder> 
        getTracesOrBuilderList();
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    Messages.TraceOrBuilder getTracesOrBuilder(
        int index);

    /**
     * <code>optional string from = 4;</code>
     */
    java.lang.String getFrom();
    /**
     * <code>optional string from = 4;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    /**
     * <code>optional string gas = 5;</code>
     */
    java.lang.String getGas();
    /**
     * <code>optional string gas = 5;</code>
     */
    com.google.protobuf.ByteString
        getGasBytes();

    /**
     * <code>optional string gas_price = 6;</code>
     */
    java.lang.String getGasPrice();
    /**
     * <code>optional string gas_price = 6;</code>
     */
    com.google.protobuf.ByteString
        getGasPriceBytes();

    /**
     * <code>optional string hash = 7;</code>
     */
    java.lang.String getHash();
    /**
     * <code>optional string hash = 7;</code>
     */
    com.google.protobuf.ByteString
        getHashBytes();

    /**
     * <code>optional string input = 8;</code>
     */
    java.lang.String getInput();
    /**
     * <code>optional string input = 8;</code>
     */
    com.google.protobuf.ByteString
        getInputBytes();

    /**
     * <code>optional string nonce = 9;</code>
     */
    java.lang.String getNonce();
    /**
     * <code>optional string nonce = 9;</code>
     */
    com.google.protobuf.ByteString
        getNonceBytes();

    /**
     * <code>optional string public_key = 10;</code>
     */
    java.lang.String getPublicKey();
    /**
     * <code>optional string public_key = 10;</code>
     */
    com.google.protobuf.ByteString
        getPublicKeyBytes();

    /**
     * <code>optional string to = 11;</code>
     */
    java.lang.String getTo();
    /**
     * <code>optional string to = 11;</code>
     */
    com.google.protobuf.ByteString
        getToBytes();

    /**
     * <code>optional string index = 12;</code>
     */
    java.lang.String getIndex();
    /**
     * <code>optional string index = 12;</code>
     */
    com.google.protobuf.ByteString
        getIndexBytes();

    /**
     * <code>optional string index_raw = 13;</code>
     */
    java.lang.String getIndexRaw();
    /**
     * <code>optional string index_raw = 13;</code>
     */
    com.google.protobuf.ByteString
        getIndexRawBytes();

    /**
     * <code>optional string value = 14;</code>
     */
    java.lang.String getValue();
    /**
     * <code>optional string value = 14;</code>
     */
    com.google.protobuf.ByteString
        getValueBytes();

    /**
     * <code>optional .SRV srv = 15;</code>
     */
    boolean hasSrv();
    /**
     * <code>optional .SRV srv = 15;</code>
     */
    Messages.SRV getSrv();
    /**
     * <code>optional .SRV srv = 15;</code>
     */
    Messages.SRVOrBuilder getSrvOrBuilder();

    /**
     * <code>optional string creates = 16;</code>
     */
    java.lang.String getCreates();
    /**
     * <code>optional string creates = 16;</code>
     */
    com.google.protobuf.ByteString
        getCreatesBytes();
  }
  /**
   * Protobuf type {@code Transaction}
   */
  public  static final class Transaction extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Transaction)
      TransactionOrBuilder {
    // Use Transaction.newBuilder() to construct.
    private Transaction(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Transaction() {
      chainId_ = 0L;
      traces_ = java.util.Collections.emptyList();
      from_ = "";
      gas_ = "";
      gasPrice_ = "";
      hash_ = "";
      input_ = "";
      nonce_ = "";
      publicKey_ = "";
      to_ = "";
      index_ = "";
      indexRaw_ = "";
      value_ = "";
      creates_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Transaction(
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
              Messages.Receipt.Builder subBuilder = null;
              if (receipt_ != null) {
                subBuilder = receipt_.toBuilder();
              }
              receipt_ = input.readMessage(Messages.Receipt.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(receipt_);
                receipt_ = subBuilder.buildPartial();
              }

              break;
            }
            case 16: {

              chainId_ = input.readUInt64();
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                traces_ = new java.util.ArrayList<Messages.Trace>();
                mutable_bitField0_ |= 0x00000004;
              }
              traces_.add(
                  input.readMessage(Messages.Trace.parser(), extensionRegistry));
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              from_ = s;
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              gas_ = s;
              break;
            }
            case 50: {
              java.lang.String s = input.readStringRequireUtf8();

              gasPrice_ = s;
              break;
            }
            case 58: {
              java.lang.String s = input.readStringRequireUtf8();

              hash_ = s;
              break;
            }
            case 66: {
              java.lang.String s = input.readStringRequireUtf8();

              input_ = s;
              break;
            }
            case 74: {
              java.lang.String s = input.readStringRequireUtf8();

              nonce_ = s;
              break;
            }
            case 82: {
              java.lang.String s = input.readStringRequireUtf8();

              publicKey_ = s;
              break;
            }
            case 90: {
              java.lang.String s = input.readStringRequireUtf8();

              to_ = s;
              break;
            }
            case 98: {
              java.lang.String s = input.readStringRequireUtf8();

              index_ = s;
              break;
            }
            case 106: {
              java.lang.String s = input.readStringRequireUtf8();

              indexRaw_ = s;
              break;
            }
            case 114: {
              java.lang.String s = input.readStringRequireUtf8();

              value_ = s;
              break;
            }
            case 122: {
              Messages.SRV.Builder subBuilder = null;
              if (srv_ != null) {
                subBuilder = srv_.toBuilder();
              }
              srv_ = input.readMessage(Messages.SRV.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(srv_);
                srv_ = subBuilder.buildPartial();
              }

              break;
            }
            case 130: {
              java.lang.String s = input.readStringRequireUtf8();

              creates_ = s;
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
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          traces_ = java.util.Collections.unmodifiableList(traces_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Messages.internal_static_Transaction_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Transaction_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Transaction.class, Messages.Transaction.Builder.class);
    }

    private int bitField0_;
    public static final int RECEIPT_FIELD_NUMBER = 1;
    private Messages.Receipt receipt_;
    /**
     * <code>optional .Receipt receipt = 1;</code>
     */
    public boolean hasReceipt() {
      return receipt_ != null;
    }
    /**
     * <code>optional .Receipt receipt = 1;</code>
     */
    public Messages.Receipt getReceipt() {
      return receipt_ == null ? Messages.Receipt.getDefaultInstance() : receipt_;
    }
    /**
     * <code>optional .Receipt receipt = 1;</code>
     */
    public Messages.ReceiptOrBuilder getReceiptOrBuilder() {
      return getReceipt();
    }

    public static final int CHAINID_FIELD_NUMBER = 2;
    private long chainId_;
    /**
     * <code>optional uint64 chainId = 2;</code>
     */
    public long getChainId() {
      return chainId_;
    }

    public static final int TRACES_FIELD_NUMBER = 3;
    private java.util.List<Messages.Trace> traces_;
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    public java.util.List<Messages.Trace> getTracesList() {
      return traces_;
    }
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    public java.util.List<? extends Messages.TraceOrBuilder> 
        getTracesOrBuilderList() {
      return traces_;
    }
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    public int getTracesCount() {
      return traces_.size();
    }
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    public Messages.Trace getTraces(int index) {
      return traces_.get(index);
    }
    /**
     * <code>repeated .Trace traces = 3;</code>
     */
    public Messages.TraceOrBuilder getTracesOrBuilder(
        int index) {
      return traces_.get(index);
    }

    public static final int FROM_FIELD_NUMBER = 4;
    private volatile java.lang.Object from_;
    /**
     * <code>optional string from = 4;</code>
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        from_ = s;
        return s;
      }
    }
    /**
     * <code>optional string from = 4;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GAS_FIELD_NUMBER = 5;
    private volatile java.lang.Object gas_;
    /**
     * <code>optional string gas = 5;</code>
     */
    public java.lang.String getGas() {
      java.lang.Object ref = gas_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gas_ = s;
        return s;
      }
    }
    /**
     * <code>optional string gas = 5;</code>
     */
    public com.google.protobuf.ByteString
        getGasBytes() {
      java.lang.Object ref = gas_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gas_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GAS_PRICE_FIELD_NUMBER = 6;
    private volatile java.lang.Object gasPrice_;
    /**
     * <code>optional string gas_price = 6;</code>
     */
    public java.lang.String getGasPrice() {
      java.lang.Object ref = gasPrice_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gasPrice_ = s;
        return s;
      }
    }
    /**
     * <code>optional string gas_price = 6;</code>
     */
    public com.google.protobuf.ByteString
        getGasPriceBytes() {
      java.lang.Object ref = gasPrice_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gasPrice_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HASH_FIELD_NUMBER = 7;
    private volatile java.lang.Object hash_;
    /**
     * <code>optional string hash = 7;</code>
     */
    public java.lang.String getHash() {
      java.lang.Object ref = hash_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hash_ = s;
        return s;
      }
    }
    /**
     * <code>optional string hash = 7;</code>
     */
    public com.google.protobuf.ByteString
        getHashBytes() {
      java.lang.Object ref = hash_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INPUT_FIELD_NUMBER = 8;
    private volatile java.lang.Object input_;
    /**
     * <code>optional string input = 8;</code>
     */
    public java.lang.String getInput() {
      java.lang.Object ref = input_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        input_ = s;
        return s;
      }
    }
    /**
     * <code>optional string input = 8;</code>
     */
    public com.google.protobuf.ByteString
        getInputBytes() {
      java.lang.Object ref = input_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        input_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int NONCE_FIELD_NUMBER = 9;
    private volatile java.lang.Object nonce_;
    /**
     * <code>optional string nonce = 9;</code>
     */
    public java.lang.String getNonce() {
      java.lang.Object ref = nonce_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nonce_ = s;
        return s;
      }
    }
    /**
     * <code>optional string nonce = 9;</code>
     */
    public com.google.protobuf.ByteString
        getNonceBytes() {
      java.lang.Object ref = nonce_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nonce_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PUBLIC_KEY_FIELD_NUMBER = 10;
    private volatile java.lang.Object publicKey_;
    /**
     * <code>optional string public_key = 10;</code>
     */
    public java.lang.String getPublicKey() {
      java.lang.Object ref = publicKey_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        publicKey_ = s;
        return s;
      }
    }
    /**
     * <code>optional string public_key = 10;</code>
     */
    public com.google.protobuf.ByteString
        getPublicKeyBytes() {
      java.lang.Object ref = publicKey_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        publicKey_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TO_FIELD_NUMBER = 11;
    private volatile java.lang.Object to_;
    /**
     * <code>optional string to = 11;</code>
     */
    public java.lang.String getTo() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        to_ = s;
        return s;
      }
    }
    /**
     * <code>optional string to = 11;</code>
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INDEX_FIELD_NUMBER = 12;
    private volatile java.lang.Object index_;
    /**
     * <code>optional string index = 12;</code>
     */
    public java.lang.String getIndex() {
      java.lang.Object ref = index_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        index_ = s;
        return s;
      }
    }
    /**
     * <code>optional string index = 12;</code>
     */
    public com.google.protobuf.ByteString
        getIndexBytes() {
      java.lang.Object ref = index_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        index_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INDEX_RAW_FIELD_NUMBER = 13;
    private volatile java.lang.Object indexRaw_;
    /**
     * <code>optional string index_raw = 13;</code>
     */
    public java.lang.String getIndexRaw() {
      java.lang.Object ref = indexRaw_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        indexRaw_ = s;
        return s;
      }
    }
    /**
     * <code>optional string index_raw = 13;</code>
     */
    public com.google.protobuf.ByteString
        getIndexRawBytes() {
      java.lang.Object ref = indexRaw_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        indexRaw_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 14;
    private volatile java.lang.Object value_;
    /**
     * <code>optional string value = 14;</code>
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      }
    }
    /**
     * <code>optional string value = 14;</code>
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SRV_FIELD_NUMBER = 15;
    private Messages.SRV srv_;
    /**
     * <code>optional .SRV srv = 15;</code>
     */
    public boolean hasSrv() {
      return srv_ != null;
    }
    /**
     * <code>optional .SRV srv = 15;</code>
     */
    public Messages.SRV getSrv() {
      return srv_ == null ? Messages.SRV.getDefaultInstance() : srv_;
    }
    /**
     * <code>optional .SRV srv = 15;</code>
     */
    public Messages.SRVOrBuilder getSrvOrBuilder() {
      return getSrv();
    }

    public static final int CREATES_FIELD_NUMBER = 16;
    private volatile java.lang.Object creates_;
    /**
     * <code>optional string creates = 16;</code>
     */
    public java.lang.String getCreates() {
      java.lang.Object ref = creates_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        creates_ = s;
        return s;
      }
    }
    /**
     * <code>optional string creates = 16;</code>
     */
    public com.google.protobuf.ByteString
        getCreatesBytes() {
      java.lang.Object ref = creates_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        creates_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (receipt_ != null) {
        output.writeMessage(1, getReceipt());
      }
      if (chainId_ != 0L) {
        output.writeUInt64(2, chainId_);
      }
      for (int i = 0; i < traces_.size(); i++) {
        output.writeMessage(3, traces_.get(i));
      }
      if (!getFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, from_);
      }
      if (!getGasBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, gas_);
      }
      if (!getGasPriceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, gasPrice_);
      }
      if (!getHashBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, hash_);
      }
      if (!getInputBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 8, input_);
      }
      if (!getNonceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 9, nonce_);
      }
      if (!getPublicKeyBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, publicKey_);
      }
      if (!getToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 11, to_);
      }
      if (!getIndexBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 12, index_);
      }
      if (!getIndexRawBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 13, indexRaw_);
      }
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 14, value_);
      }
      if (srv_ != null) {
        output.writeMessage(15, getSrv());
      }
      if (!getCreatesBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 16, creates_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (receipt_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getReceipt());
      }
      if (chainId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(2, chainId_);
      }
      for (int i = 0; i < traces_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, traces_.get(i));
      }
      if (!getFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, from_);
      }
      if (!getGasBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, gas_);
      }
      if (!getGasPriceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, gasPrice_);
      }
      if (!getHashBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, hash_);
      }
      if (!getInputBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, input_);
      }
      if (!getNonceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, nonce_);
      }
      if (!getPublicKeyBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, publicKey_);
      }
      if (!getToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, to_);
      }
      if (!getIndexBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, index_);
      }
      if (!getIndexRawBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, indexRaw_);
      }
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(14, value_);
      }
      if (srv_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(15, getSrv());
      }
      if (!getCreatesBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(16, creates_);
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
      if (!(obj instanceof Messages.Transaction)) {
        return super.equals(obj);
      }
      Messages.Transaction other = (Messages.Transaction) obj;

      boolean result = true;
      result = result && (hasReceipt() == other.hasReceipt());
      if (hasReceipt()) {
        result = result && getReceipt()
            .equals(other.getReceipt());
      }
      result = result && (getChainId()
          == other.getChainId());
      result = result && getTracesList()
          .equals(other.getTracesList());
      result = result && getFrom()
          .equals(other.getFrom());
      result = result && getGas()
          .equals(other.getGas());
      result = result && getGasPrice()
          .equals(other.getGasPrice());
      result = result && getHash()
          .equals(other.getHash());
      result = result && getInput()
          .equals(other.getInput());
      result = result && getNonce()
          .equals(other.getNonce());
      result = result && getPublicKey()
          .equals(other.getPublicKey());
      result = result && getTo()
          .equals(other.getTo());
      result = result && getIndex()
          .equals(other.getIndex());
      result = result && getIndexRaw()
          .equals(other.getIndexRaw());
      result = result && getValue()
          .equals(other.getValue());
      result = result && (hasSrv() == other.hasSrv());
      if (hasSrv()) {
        result = result && getSrv()
            .equals(other.getSrv());
      }
      result = result && getCreates()
          .equals(other.getCreates());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasReceipt()) {
        hash = (37 * hash) + RECEIPT_FIELD_NUMBER;
        hash = (53 * hash) + getReceipt().hashCode();
      }
      hash = (37 * hash) + CHAINID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getChainId());
      if (getTracesCount() > 0) {
        hash = (37 * hash) + TRACES_FIELD_NUMBER;
        hash = (53 * hash) + getTracesList().hashCode();
      }
      hash = (37 * hash) + FROM_FIELD_NUMBER;
      hash = (53 * hash) + getFrom().hashCode();
      hash = (37 * hash) + GAS_FIELD_NUMBER;
      hash = (53 * hash) + getGas().hashCode();
      hash = (37 * hash) + GAS_PRICE_FIELD_NUMBER;
      hash = (53 * hash) + getGasPrice().hashCode();
      hash = (37 * hash) + HASH_FIELD_NUMBER;
      hash = (53 * hash) + getHash().hashCode();
      hash = (37 * hash) + INPUT_FIELD_NUMBER;
      hash = (53 * hash) + getInput().hashCode();
      hash = (37 * hash) + NONCE_FIELD_NUMBER;
      hash = (53 * hash) + getNonce().hashCode();
      hash = (37 * hash) + PUBLIC_KEY_FIELD_NUMBER;
      hash = (53 * hash) + getPublicKey().hashCode();
      hash = (37 * hash) + TO_FIELD_NUMBER;
      hash = (53 * hash) + getTo().hashCode();
      hash = (37 * hash) + INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getIndex().hashCode();
      hash = (37 * hash) + INDEX_RAW_FIELD_NUMBER;
      hash = (53 * hash) + getIndexRaw().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      if (hasSrv()) {
        hash = (37 * hash) + SRV_FIELD_NUMBER;
        hash = (53 * hash) + getSrv().hashCode();
      }
      hash = (37 * hash) + CREATES_FIELD_NUMBER;
      hash = (53 * hash) + getCreates().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Transaction parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Transaction parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Transaction parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Transaction parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Transaction parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Transaction parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Transaction parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Transaction parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Transaction parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Transaction parseFrom(
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
    public static Builder newBuilder(Messages.Transaction prototype) {
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
     * Protobuf type {@code Transaction}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Transaction)
        Messages.TransactionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Transaction_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Transaction_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Transaction.class, Messages.Transaction.Builder.class);
      }

      // Construct using Messages.Transaction.newBuilder()
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
          getTracesFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        if (receiptBuilder_ == null) {
          receipt_ = null;
        } else {
          receipt_ = null;
          receiptBuilder_ = null;
        }
        chainId_ = 0L;

        if (tracesBuilder_ == null) {
          traces_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          tracesBuilder_.clear();
        }
        from_ = "";

        gas_ = "";

        gasPrice_ = "";

        hash_ = "";

        input_ = "";

        nonce_ = "";

        publicKey_ = "";

        to_ = "";

        index_ = "";

        indexRaw_ = "";

        value_ = "";

        if (srvBuilder_ == null) {
          srv_ = null;
        } else {
          srv_ = null;
          srvBuilder_ = null;
        }
        creates_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Transaction_descriptor;
      }

      public Messages.Transaction getDefaultInstanceForType() {
        return Messages.Transaction.getDefaultInstance();
      }

      public Messages.Transaction build() {
        Messages.Transaction result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Transaction buildPartial() {
        Messages.Transaction result = new Messages.Transaction(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (receiptBuilder_ == null) {
          result.receipt_ = receipt_;
        } else {
          result.receipt_ = receiptBuilder_.build();
        }
        result.chainId_ = chainId_;
        if (tracesBuilder_ == null) {
          if (((bitField0_ & 0x00000004) == 0x00000004)) {
            traces_ = java.util.Collections.unmodifiableList(traces_);
            bitField0_ = (bitField0_ & ~0x00000004);
          }
          result.traces_ = traces_;
        } else {
          result.traces_ = tracesBuilder_.build();
        }
        result.from_ = from_;
        result.gas_ = gas_;
        result.gasPrice_ = gasPrice_;
        result.hash_ = hash_;
        result.input_ = input_;
        result.nonce_ = nonce_;
        result.publicKey_ = publicKey_;
        result.to_ = to_;
        result.index_ = index_;
        result.indexRaw_ = indexRaw_;
        result.value_ = value_;
        if (srvBuilder_ == null) {
          result.srv_ = srv_;
        } else {
          result.srv_ = srvBuilder_.build();
        }
        result.creates_ = creates_;
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
        if (other instanceof Messages.Transaction) {
          return mergeFrom((Messages.Transaction)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Transaction other) {
        if (other == Messages.Transaction.getDefaultInstance()) return this;
        if (other.hasReceipt()) {
          mergeReceipt(other.getReceipt());
        }
        if (other.getChainId() != 0L) {
          setChainId(other.getChainId());
        }
        if (tracesBuilder_ == null) {
          if (!other.traces_.isEmpty()) {
            if (traces_.isEmpty()) {
              traces_ = other.traces_;
              bitField0_ = (bitField0_ & ~0x00000004);
            } else {
              ensureTracesIsMutable();
              traces_.addAll(other.traces_);
            }
            onChanged();
          }
        } else {
          if (!other.traces_.isEmpty()) {
            if (tracesBuilder_.isEmpty()) {
              tracesBuilder_.dispose();
              tracesBuilder_ = null;
              traces_ = other.traces_;
              bitField0_ = (bitField0_ & ~0x00000004);
              tracesBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getTracesFieldBuilder() : null;
            } else {
              tracesBuilder_.addAllMessages(other.traces_);
            }
          }
        }
        if (!other.getFrom().isEmpty()) {
          from_ = other.from_;
          onChanged();
        }
        if (!other.getGas().isEmpty()) {
          gas_ = other.gas_;
          onChanged();
        }
        if (!other.getGasPrice().isEmpty()) {
          gasPrice_ = other.gasPrice_;
          onChanged();
        }
        if (!other.getHash().isEmpty()) {
          hash_ = other.hash_;
          onChanged();
        }
        if (!other.getInput().isEmpty()) {
          input_ = other.input_;
          onChanged();
        }
        if (!other.getNonce().isEmpty()) {
          nonce_ = other.nonce_;
          onChanged();
        }
        if (!other.getPublicKey().isEmpty()) {
          publicKey_ = other.publicKey_;
          onChanged();
        }
        if (!other.getTo().isEmpty()) {
          to_ = other.to_;
          onChanged();
        }
        if (!other.getIndex().isEmpty()) {
          index_ = other.index_;
          onChanged();
        }
        if (!other.getIndexRaw().isEmpty()) {
          indexRaw_ = other.indexRaw_;
          onChanged();
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
          onChanged();
        }
        if (other.hasSrv()) {
          mergeSrv(other.getSrv());
        }
        if (!other.getCreates().isEmpty()) {
          creates_ = other.creates_;
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
        Messages.Transaction parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Transaction) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private Messages.Receipt receipt_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Receipt, Messages.Receipt.Builder, Messages.ReceiptOrBuilder> receiptBuilder_;
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public boolean hasReceipt() {
        return receiptBuilder_ != null || receipt_ != null;
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Messages.Receipt getReceipt() {
        if (receiptBuilder_ == null) {
          return receipt_ == null ? Messages.Receipt.getDefaultInstance() : receipt_;
        } else {
          return receiptBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Builder setReceipt(Messages.Receipt value) {
        if (receiptBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          receipt_ = value;
          onChanged();
        } else {
          receiptBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Builder setReceipt(
          Messages.Receipt.Builder builderForValue) {
        if (receiptBuilder_ == null) {
          receipt_ = builderForValue.build();
          onChanged();
        } else {
          receiptBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Builder mergeReceipt(Messages.Receipt value) {
        if (receiptBuilder_ == null) {
          if (receipt_ != null) {
            receipt_ =
              Messages.Receipt.newBuilder(receipt_).mergeFrom(value).buildPartial();
          } else {
            receipt_ = value;
          }
          onChanged();
        } else {
          receiptBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Builder clearReceipt() {
        if (receiptBuilder_ == null) {
          receipt_ = null;
          onChanged();
        } else {
          receipt_ = null;
          receiptBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Messages.Receipt.Builder getReceiptBuilder() {
        
        onChanged();
        return getReceiptFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      public Messages.ReceiptOrBuilder getReceiptOrBuilder() {
        if (receiptBuilder_ != null) {
          return receiptBuilder_.getMessageOrBuilder();
        } else {
          return receipt_ == null ?
              Messages.Receipt.getDefaultInstance() : receipt_;
        }
      }
      /**
       * <code>optional .Receipt receipt = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Receipt, Messages.Receipt.Builder, Messages.ReceiptOrBuilder> 
          getReceiptFieldBuilder() {
        if (receiptBuilder_ == null) {
          receiptBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.Receipt, Messages.Receipt.Builder, Messages.ReceiptOrBuilder>(
                  getReceipt(),
                  getParentForChildren(),
                  isClean());
          receipt_ = null;
        }
        return receiptBuilder_;
      }

      private long chainId_ ;
      /**
       * <code>optional uint64 chainId = 2;</code>
       */
      public long getChainId() {
        return chainId_;
      }
      /**
       * <code>optional uint64 chainId = 2;</code>
       */
      public Builder setChainId(long value) {
        
        chainId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint64 chainId = 2;</code>
       */
      public Builder clearChainId() {
        
        chainId_ = 0L;
        onChanged();
        return this;
      }

      private java.util.List<Messages.Trace> traces_ =
        java.util.Collections.emptyList();
      private void ensureTracesIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          traces_ = new java.util.ArrayList<Messages.Trace>(traces_);
          bitField0_ |= 0x00000004;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Messages.Trace, Messages.Trace.Builder, Messages.TraceOrBuilder> tracesBuilder_;

      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public java.util.List<Messages.Trace> getTracesList() {
        if (tracesBuilder_ == null) {
          return java.util.Collections.unmodifiableList(traces_);
        } else {
          return tracesBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public int getTracesCount() {
        if (tracesBuilder_ == null) {
          return traces_.size();
        } else {
          return tracesBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Messages.Trace getTraces(int index) {
        if (tracesBuilder_ == null) {
          return traces_.get(index);
        } else {
          return tracesBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder setTraces(
          int index, Messages.Trace value) {
        if (tracesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTracesIsMutable();
          traces_.set(index, value);
          onChanged();
        } else {
          tracesBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder setTraces(
          int index, Messages.Trace.Builder builderForValue) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.set(index, builderForValue.build());
          onChanged();
        } else {
          tracesBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder addTraces(Messages.Trace value) {
        if (tracesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTracesIsMutable();
          traces_.add(value);
          onChanged();
        } else {
          tracesBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder addTraces(
          int index, Messages.Trace value) {
        if (tracesBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTracesIsMutable();
          traces_.add(index, value);
          onChanged();
        } else {
          tracesBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder addTraces(
          Messages.Trace.Builder builderForValue) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.add(builderForValue.build());
          onChanged();
        } else {
          tracesBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder addTraces(
          int index, Messages.Trace.Builder builderForValue) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.add(index, builderForValue.build());
          onChanged();
        } else {
          tracesBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder addAllTraces(
          java.lang.Iterable<? extends Messages.Trace> values) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, traces_);
          onChanged();
        } else {
          tracesBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder clearTraces() {
        if (tracesBuilder_ == null) {
          traces_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
          onChanged();
        } else {
          tracesBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Builder removeTraces(int index) {
        if (tracesBuilder_ == null) {
          ensureTracesIsMutable();
          traces_.remove(index);
          onChanged();
        } else {
          tracesBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Messages.Trace.Builder getTracesBuilder(
          int index) {
        return getTracesFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Messages.TraceOrBuilder getTracesOrBuilder(
          int index) {
        if (tracesBuilder_ == null) {
          return traces_.get(index);  } else {
          return tracesBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public java.util.List<? extends Messages.TraceOrBuilder> 
           getTracesOrBuilderList() {
        if (tracesBuilder_ != null) {
          return tracesBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(traces_);
        }
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Messages.Trace.Builder addTracesBuilder() {
        return getTracesFieldBuilder().addBuilder(
            Messages.Trace.getDefaultInstance());
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public Messages.Trace.Builder addTracesBuilder(
          int index) {
        return getTracesFieldBuilder().addBuilder(
            index, Messages.Trace.getDefaultInstance());
      }
      /**
       * <code>repeated .Trace traces = 3;</code>
       */
      public java.util.List<Messages.Trace.Builder> 
           getTracesBuilderList() {
        return getTracesFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Messages.Trace, Messages.Trace.Builder, Messages.TraceOrBuilder> 
          getTracesFieldBuilder() {
        if (tracesBuilder_ == null) {
          tracesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Messages.Trace, Messages.Trace.Builder, Messages.TraceOrBuilder>(
                  traces_,
                  ((bitField0_ & 0x00000004) == 0x00000004),
                  getParentForChildren(),
                  isClean());
          traces_ = null;
        }
        return tracesBuilder_;
      }

      private java.lang.Object from_ = "";
      /**
       * <code>optional string from = 4;</code>
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public Builder clearFrom() {
        
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 4;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        from_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object gas_ = "";
      /**
       * <code>optional string gas = 5;</code>
       */
      public java.lang.String getGas() {
        java.lang.Object ref = gas_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gas_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string gas = 5;</code>
       */
      public com.google.protobuf.ByteString
          getGasBytes() {
        java.lang.Object ref = gas_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gas_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string gas = 5;</code>
       */
      public Builder setGas(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gas_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas = 5;</code>
       */
      public Builder clearGas() {
        
        gas_ = getDefaultInstance().getGas();
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas = 5;</code>
       */
      public Builder setGasBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gas_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object gasPrice_ = "";
      /**
       * <code>optional string gas_price = 6;</code>
       */
      public java.lang.String getGasPrice() {
        java.lang.Object ref = gasPrice_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gasPrice_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string gas_price = 6;</code>
       */
      public com.google.protobuf.ByteString
          getGasPriceBytes() {
        java.lang.Object ref = gasPrice_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gasPrice_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string gas_price = 6;</code>
       */
      public Builder setGasPrice(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gasPrice_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas_price = 6;</code>
       */
      public Builder clearGasPrice() {
        
        gasPrice_ = getDefaultInstance().getGasPrice();
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas_price = 6;</code>
       */
      public Builder setGasPriceBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gasPrice_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object hash_ = "";
      /**
       * <code>optional string hash = 7;</code>
       */
      public java.lang.String getHash() {
        java.lang.Object ref = hash_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hash_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string hash = 7;</code>
       */
      public com.google.protobuf.ByteString
          getHashBytes() {
        java.lang.Object ref = hash_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          hash_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string hash = 7;</code>
       */
      public Builder setHash(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        hash_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string hash = 7;</code>
       */
      public Builder clearHash() {
        
        hash_ = getDefaultInstance().getHash();
        onChanged();
        return this;
      }
      /**
       * <code>optional string hash = 7;</code>
       */
      public Builder setHashBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        hash_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object input_ = "";
      /**
       * <code>optional string input = 8;</code>
       */
      public java.lang.String getInput() {
        java.lang.Object ref = input_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          input_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string input = 8;</code>
       */
      public com.google.protobuf.ByteString
          getInputBytes() {
        java.lang.Object ref = input_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          input_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string input = 8;</code>
       */
      public Builder setInput(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        input_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string input = 8;</code>
       */
      public Builder clearInput() {
        
        input_ = getDefaultInstance().getInput();
        onChanged();
        return this;
      }
      /**
       * <code>optional string input = 8;</code>
       */
      public Builder setInputBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        input_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object nonce_ = "";
      /**
       * <code>optional string nonce = 9;</code>
       */
      public java.lang.String getNonce() {
        java.lang.Object ref = nonce_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          nonce_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string nonce = 9;</code>
       */
      public com.google.protobuf.ByteString
          getNonceBytes() {
        java.lang.Object ref = nonce_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          nonce_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string nonce = 9;</code>
       */
      public Builder setNonce(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        nonce_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string nonce = 9;</code>
       */
      public Builder clearNonce() {
        
        nonce_ = getDefaultInstance().getNonce();
        onChanged();
        return this;
      }
      /**
       * <code>optional string nonce = 9;</code>
       */
      public Builder setNonceBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        nonce_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object publicKey_ = "";
      /**
       * <code>optional string public_key = 10;</code>
       */
      public java.lang.String getPublicKey() {
        java.lang.Object ref = publicKey_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          publicKey_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string public_key = 10;</code>
       */
      public com.google.protobuf.ByteString
          getPublicKeyBytes() {
        java.lang.Object ref = publicKey_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          publicKey_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string public_key = 10;</code>
       */
      public Builder setPublicKey(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        publicKey_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string public_key = 10;</code>
       */
      public Builder clearPublicKey() {
        
        publicKey_ = getDefaultInstance().getPublicKey();
        onChanged();
        return this;
      }
      /**
       * <code>optional string public_key = 10;</code>
       */
      public Builder setPublicKeyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        publicKey_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object to_ = "";
      /**
       * <code>optional string to = 11;</code>
       */
      public java.lang.String getTo() {
        java.lang.Object ref = to_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          to_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string to = 11;</code>
       */
      public com.google.protobuf.ByteString
          getToBytes() {
        java.lang.Object ref = to_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          to_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string to = 11;</code>
       */
      public Builder setTo(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        to_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 11;</code>
       */
      public Builder clearTo() {
        
        to_ = getDefaultInstance().getTo();
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 11;</code>
       */
      public Builder setToBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        to_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object index_ = "";
      /**
       * <code>optional string index = 12;</code>
       */
      public java.lang.String getIndex() {
        java.lang.Object ref = index_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          index_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string index = 12;</code>
       */
      public com.google.protobuf.ByteString
          getIndexBytes() {
        java.lang.Object ref = index_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          index_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string index = 12;</code>
       */
      public Builder setIndex(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        index_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string index = 12;</code>
       */
      public Builder clearIndex() {
        
        index_ = getDefaultInstance().getIndex();
        onChanged();
        return this;
      }
      /**
       * <code>optional string index = 12;</code>
       */
      public Builder setIndexBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        index_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object indexRaw_ = "";
      /**
       * <code>optional string index_raw = 13;</code>
       */
      public java.lang.String getIndexRaw() {
        java.lang.Object ref = indexRaw_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          indexRaw_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string index_raw = 13;</code>
       */
      public com.google.protobuf.ByteString
          getIndexRawBytes() {
        java.lang.Object ref = indexRaw_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          indexRaw_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string index_raw = 13;</code>
       */
      public Builder setIndexRaw(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        indexRaw_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string index_raw = 13;</code>
       */
      public Builder clearIndexRaw() {
        
        indexRaw_ = getDefaultInstance().getIndexRaw();
        onChanged();
        return this;
      }
      /**
       * <code>optional string index_raw = 13;</code>
       */
      public Builder setIndexRawBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        indexRaw_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object value_ = "";
      /**
       * <code>optional string value = 14;</code>
       */
      public java.lang.String getValue() {
        java.lang.Object ref = value_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          value_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string value = 14;</code>
       */
      public com.google.protobuf.ByteString
          getValueBytes() {
        java.lang.Object ref = value_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          value_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string value = 14;</code>
       */
      public Builder setValue(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 14;</code>
       */
      public Builder clearValue() {
        
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 14;</code>
       */
      public Builder setValueBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        value_ = value;
        onChanged();
        return this;
      }

      private Messages.SRV srv_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.SRV, Messages.SRV.Builder, Messages.SRVOrBuilder> srvBuilder_;
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public boolean hasSrv() {
        return srvBuilder_ != null || srv_ != null;
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Messages.SRV getSrv() {
        if (srvBuilder_ == null) {
          return srv_ == null ? Messages.SRV.getDefaultInstance() : srv_;
        } else {
          return srvBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Builder setSrv(Messages.SRV value) {
        if (srvBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          srv_ = value;
          onChanged();
        } else {
          srvBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Builder setSrv(
          Messages.SRV.Builder builderForValue) {
        if (srvBuilder_ == null) {
          srv_ = builderForValue.build();
          onChanged();
        } else {
          srvBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Builder mergeSrv(Messages.SRV value) {
        if (srvBuilder_ == null) {
          if (srv_ != null) {
            srv_ =
              Messages.SRV.newBuilder(srv_).mergeFrom(value).buildPartial();
          } else {
            srv_ = value;
          }
          onChanged();
        } else {
          srvBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Builder clearSrv() {
        if (srvBuilder_ == null) {
          srv_ = null;
          onChanged();
        } else {
          srv_ = null;
          srvBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Messages.SRV.Builder getSrvBuilder() {
        
        onChanged();
        return getSrvFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      public Messages.SRVOrBuilder getSrvOrBuilder() {
        if (srvBuilder_ != null) {
          return srvBuilder_.getMessageOrBuilder();
        } else {
          return srv_ == null ?
              Messages.SRV.getDefaultInstance() : srv_;
        }
      }
      /**
       * <code>optional .SRV srv = 15;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.SRV, Messages.SRV.Builder, Messages.SRVOrBuilder> 
          getSrvFieldBuilder() {
        if (srvBuilder_ == null) {
          srvBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.SRV, Messages.SRV.Builder, Messages.SRVOrBuilder>(
                  getSrv(),
                  getParentForChildren(),
                  isClean());
          srv_ = null;
        }
        return srvBuilder_;
      }

      private java.lang.Object creates_ = "";
      /**
       * <code>optional string creates = 16;</code>
       */
      public java.lang.String getCreates() {
        java.lang.Object ref = creates_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          creates_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string creates = 16;</code>
       */
      public com.google.protobuf.ByteString
          getCreatesBytes() {
        java.lang.Object ref = creates_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          creates_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string creates = 16;</code>
       */
      public Builder setCreates(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        creates_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string creates = 16;</code>
       */
      public Builder clearCreates() {
        
        creates_ = getDefaultInstance().getCreates();
        onChanged();
        return this;
      }
      /**
       * <code>optional string creates = 16;</code>
       */
      public Builder setCreatesBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        creates_ = value;
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


      // @@protoc_insertion_point(builder_scope:Transaction)
    }

    // @@protoc_insertion_point(class_scope:Transaction)
    private static final Messages.Transaction DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Transaction();
    }

    public static Messages.Transaction getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Transaction>
        PARSER = new com.google.protobuf.AbstractParser<Transaction>() {
      public Transaction parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Transaction(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Transaction> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Transaction> getParserForType() {
      return PARSER;
    }

    public Messages.Transaction getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface SRVOrBuilder extends
      // @@protoc_insertion_point(interface_extends:SRV)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string s = 1;</code>
     */
    java.lang.String getS();
    /**
     * <code>optional string s = 1;</code>
     */
    com.google.protobuf.ByteString
        getSBytes();

    /**
     * <code>optional string r = 2;</code>
     */
    java.lang.String getR();
    /**
     * <code>optional string r = 2;</code>
     */
    com.google.protobuf.ByteString
        getRBytes();

    /**
     * <code>optional uint64 v = 3;</code>
     */
    long getV();
  }
  /**
   * Protobuf type {@code SRV}
   */
  public  static final class SRV extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:SRV)
      SRVOrBuilder {
    // Use SRV.newBuilder() to construct.
    private SRV(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SRV() {
      s_ = "";
      r_ = "";
      v_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private SRV(
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

              s_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              r_ = s;
              break;
            }
            case 24: {

              v_ = input.readUInt64();
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
      return Messages.internal_static_SRV_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_SRV_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.SRV.class, Messages.SRV.Builder.class);
    }

    public static final int S_FIELD_NUMBER = 1;
    private volatile java.lang.Object s_;
    /**
     * <code>optional string s = 1;</code>
     */
    public java.lang.String getS() {
      java.lang.Object ref = s_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        s_ = s;
        return s;
      }
    }
    /**
     * <code>optional string s = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSBytes() {
      java.lang.Object ref = s_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        s_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int R_FIELD_NUMBER = 2;
    private volatile java.lang.Object r_;
    /**
     * <code>optional string r = 2;</code>
     */
    public java.lang.String getR() {
      java.lang.Object ref = r_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        r_ = s;
        return s;
      }
    }
    /**
     * <code>optional string r = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRBytes() {
      java.lang.Object ref = r_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        r_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int V_FIELD_NUMBER = 3;
    private long v_;
    /**
     * <code>optional uint64 v = 3;</code>
     */
    public long getV() {
      return v_;
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
      if (!getSBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, s_);
      }
      if (!getRBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, r_);
      }
      if (v_ != 0L) {
        output.writeUInt64(3, v_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getSBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, s_);
      }
      if (!getRBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, r_);
      }
      if (v_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(3, v_);
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
      if (!(obj instanceof Messages.SRV)) {
        return super.equals(obj);
      }
      Messages.SRV other = (Messages.SRV) obj;

      boolean result = true;
      result = result && getS()
          .equals(other.getS());
      result = result && getR()
          .equals(other.getR());
      result = result && (getV()
          == other.getV());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + S_FIELD_NUMBER;
      hash = (53 * hash) + getS().hashCode();
      hash = (37 * hash) + R_FIELD_NUMBER;
      hash = (53 * hash) + getR().hashCode();
      hash = (37 * hash) + V_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getV());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.SRV parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.SRV parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.SRV parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.SRV parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.SRV parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.SRV parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.SRV parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.SRV parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.SRV parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.SRV parseFrom(
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
    public static Builder newBuilder(Messages.SRV prototype) {
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
     * Protobuf type {@code SRV}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:SRV)
        Messages.SRVOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_SRV_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_SRV_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.SRV.class, Messages.SRV.Builder.class);
      }

      // Construct using Messages.SRV.newBuilder()
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
        s_ = "";

        r_ = "";

        v_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_SRV_descriptor;
      }

      public Messages.SRV getDefaultInstanceForType() {
        return Messages.SRV.getDefaultInstance();
      }

      public Messages.SRV build() {
        Messages.SRV result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.SRV buildPartial() {
        Messages.SRV result = new Messages.SRV(this);
        result.s_ = s_;
        result.r_ = r_;
        result.v_ = v_;
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
        if (other instanceof Messages.SRV) {
          return mergeFrom((Messages.SRV)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.SRV other) {
        if (other == Messages.SRV.getDefaultInstance()) return this;
        if (!other.getS().isEmpty()) {
          s_ = other.s_;
          onChanged();
        }
        if (!other.getR().isEmpty()) {
          r_ = other.r_;
          onChanged();
        }
        if (other.getV() != 0L) {
          setV(other.getV());
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
        Messages.SRV parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.SRV) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object s_ = "";
      /**
       * <code>optional string s = 1;</code>
       */
      public java.lang.String getS() {
        java.lang.Object ref = s_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          s_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string s = 1;</code>
       */
      public com.google.protobuf.ByteString
          getSBytes() {
        java.lang.Object ref = s_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          s_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string s = 1;</code>
       */
      public Builder setS(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        s_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string s = 1;</code>
       */
      public Builder clearS() {
        
        s_ = getDefaultInstance().getS();
        onChanged();
        return this;
      }
      /**
       * <code>optional string s = 1;</code>
       */
      public Builder setSBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        s_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object r_ = "";
      /**
       * <code>optional string r = 2;</code>
       */
      public java.lang.String getR() {
        java.lang.Object ref = r_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          r_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string r = 2;</code>
       */
      public com.google.protobuf.ByteString
          getRBytes() {
        java.lang.Object ref = r_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          r_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string r = 2;</code>
       */
      public Builder setR(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        r_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string r = 2;</code>
       */
      public Builder clearR() {
        
        r_ = getDefaultInstance().getR();
        onChanged();
        return this;
      }
      /**
       * <code>optional string r = 2;</code>
       */
      public Builder setRBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        r_ = value;
        onChanged();
        return this;
      }

      private long v_ ;
      /**
       * <code>optional uint64 v = 3;</code>
       */
      public long getV() {
        return v_;
      }
      /**
       * <code>optional uint64 v = 3;</code>
       */
      public Builder setV(long value) {
        
        v_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint64 v = 3;</code>
       */
      public Builder clearV() {
        
        v_ = 0L;
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


      // @@protoc_insertion_point(builder_scope:SRV)
    }

    // @@protoc_insertion_point(class_scope:SRV)
    private static final Messages.SRV DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.SRV();
    }

    public static Messages.SRV getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SRV>
        PARSER = new com.google.protobuf.AbstractParser<SRV>() {
      public SRV parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new SRV(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SRV> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SRV> getParserForType() {
      return PARSER;
    }

    public Messages.SRV getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ReceiptOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Receipt)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string gas_used = 1;</code>
     */
    java.lang.String getGasUsed();
    /**
     * <code>optional string gas_used = 1;</code>
     */
    com.google.protobuf.ByteString
        getGasUsedBytes();

    /**
     * <code>optional string status = 2;</code>
     */
    java.lang.String getStatus();
    /**
     * <code>optional string status = 2;</code>
     */
    com.google.protobuf.ByteString
        getStatusBytes();
  }
  /**
   * Protobuf type {@code Receipt}
   */
  public  static final class Receipt extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Receipt)
      ReceiptOrBuilder {
    // Use Receipt.newBuilder() to construct.
    private Receipt(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Receipt() {
      gasUsed_ = "";
      status_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Receipt(
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

              gasUsed_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              status_ = s;
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
      return Messages.internal_static_Receipt_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Receipt_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Receipt.class, Messages.Receipt.Builder.class);
    }

    public static final int GAS_USED_FIELD_NUMBER = 1;
    private volatile java.lang.Object gasUsed_;
    /**
     * <code>optional string gas_used = 1;</code>
     */
    public java.lang.String getGasUsed() {
      java.lang.Object ref = gasUsed_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gasUsed_ = s;
        return s;
      }
    }
    /**
     * <code>optional string gas_used = 1;</code>
     */
    public com.google.protobuf.ByteString
        getGasUsedBytes() {
      java.lang.Object ref = gasUsed_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gasUsed_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STATUS_FIELD_NUMBER = 2;
    private volatile java.lang.Object status_;
    /**
     * <code>optional string status = 2;</code>
     */
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      }
    }
    /**
     * <code>optional string status = 2;</code>
     */
    public com.google.protobuf.ByteString
        getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getGasUsedBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, gasUsed_);
      }
      if (!getStatusBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, status_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getGasUsedBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, gasUsed_);
      }
      if (!getStatusBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, status_);
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
      if (!(obj instanceof Messages.Receipt)) {
        return super.equals(obj);
      }
      Messages.Receipt other = (Messages.Receipt) obj;

      boolean result = true;
      result = result && getGasUsed()
          .equals(other.getGasUsed());
      result = result && getStatus()
          .equals(other.getStatus());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + GAS_USED_FIELD_NUMBER;
      hash = (53 * hash) + getGasUsed().hashCode();
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Receipt parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Receipt parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Receipt parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Receipt parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Receipt parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Receipt parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Receipt parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Receipt parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Receipt parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Receipt parseFrom(
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
    public static Builder newBuilder(Messages.Receipt prototype) {
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
     * Protobuf type {@code Receipt}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Receipt)
        Messages.ReceiptOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Receipt_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Receipt_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Receipt.class, Messages.Receipt.Builder.class);
      }

      // Construct using Messages.Receipt.newBuilder()
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
        gasUsed_ = "";

        status_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Receipt_descriptor;
      }

      public Messages.Receipt getDefaultInstanceForType() {
        return Messages.Receipt.getDefaultInstance();
      }

      public Messages.Receipt build() {
        Messages.Receipt result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Receipt buildPartial() {
        Messages.Receipt result = new Messages.Receipt(this);
        result.gasUsed_ = gasUsed_;
        result.status_ = status_;
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
        if (other instanceof Messages.Receipt) {
          return mergeFrom((Messages.Receipt)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Receipt other) {
        if (other == Messages.Receipt.getDefaultInstance()) return this;
        if (!other.getGasUsed().isEmpty()) {
          gasUsed_ = other.gasUsed_;
          onChanged();
        }
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
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
        Messages.Receipt parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Receipt) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object gasUsed_ = "";
      /**
       * <code>optional string gas_used = 1;</code>
       */
      public java.lang.String getGasUsed() {
        java.lang.Object ref = gasUsed_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gasUsed_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string gas_used = 1;</code>
       */
      public com.google.protobuf.ByteString
          getGasUsedBytes() {
        java.lang.Object ref = gasUsed_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gasUsed_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string gas_used = 1;</code>
       */
      public Builder setGasUsed(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gasUsed_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas_used = 1;</code>
       */
      public Builder clearGasUsed() {
        
        gasUsed_ = getDefaultInstance().getGasUsed();
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas_used = 1;</code>
       */
      public Builder setGasUsedBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gasUsed_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object status_ = "";
      /**
       * <code>optional string status = 2;</code>
       */
      public java.lang.String getStatus() {
        java.lang.Object ref = status_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          status_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string status = 2;</code>
       */
      public com.google.protobuf.ByteString
          getStatusBytes() {
        java.lang.Object ref = status_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          status_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string status = 2;</code>
       */
      public Builder setStatus(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string status = 2;</code>
       */
      public Builder clearStatus() {
        
        status_ = getDefaultInstance().getStatus();
        onChanged();
        return this;
      }
      /**
       * <code>optional string status = 2;</code>
       */
      public Builder setStatusBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        status_ = value;
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


      // @@protoc_insertion_point(builder_scope:Receipt)
    }

    // @@protoc_insertion_point(class_scope:Receipt)
    private static final Messages.Receipt DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Receipt();
    }

    public static Messages.Receipt getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Receipt>
        PARSER = new com.google.protobuf.AbstractParser<Receipt>() {
      public Receipt parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Receipt(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Receipt> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Receipt> getParserForType() {
      return PARSER;
    }

    public Messages.Receipt getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface TraceOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Trace)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string subtraces_count = 1;</code>
     */
    java.lang.String getSubtracesCount();
    /**
     * <code>optional string subtraces_count = 1;</code>
     */
    com.google.protobuf.ByteString
        getSubtracesCountBytes();

    /**
     * <code>repeated string trace_address = 2;</code>
     */
    java.util.List<java.lang.String>
        getTraceAddressList();
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    int getTraceAddressCount();
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    java.lang.String getTraceAddress(int index);
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    com.google.protobuf.ByteString
        getTraceAddressBytes(int index);

    /**
     * <code>optional string transaction_hash = 3;</code>
     */
    java.lang.String getTransactionHash();
    /**
     * <code>optional string transaction_hash = 3;</code>
     */
    com.google.protobuf.ByteString
        getTransactionHashBytes();

    /**
     * <code>optional string transaction_position = 4;</code>
     */
    java.lang.String getTransactionPosition();
    /**
     * <code>optional string transaction_position = 4;</code>
     */
    com.google.protobuf.ByteString
        getTransactionPositionBytes();

    /**
     * <code>optional string type = 5;</code>
     */
    java.lang.String getType();
    /**
     * <code>optional string type = 5;</code>
     */
    com.google.protobuf.ByteString
        getTypeBytes();

    /**
     * <code>optional .Trace.Action action = 6;</code>
     */
    int getActionValue();
    /**
     * <code>optional .Trace.Action action = 6;</code>
     */
    Messages.Trace.Action getAction();

    /**
     * <code>optional .Call call = 7;</code>
     */
    boolean hasCall();
    /**
     * <code>optional .Call call = 7;</code>
     */
    Messages.Call getCall();
    /**
     * <code>optional .Call call = 7;</code>
     */
    Messages.CallOrBuilder getCallOrBuilder();

    /**
     * <code>optional .Create create = 8;</code>
     */
    boolean hasCreate();
    /**
     * <code>optional .Create create = 8;</code>
     */
    Messages.Create getCreate();
    /**
     * <code>optional .Create create = 8;</code>
     */
    Messages.CreateOrBuilder getCreateOrBuilder();

    /**
     * <code>optional .Reward reward = 9;</code>
     */
    boolean hasReward();
    /**
     * <code>optional .Reward reward = 9;</code>
     */
    Messages.Reward getReward();
    /**
     * <code>optional .Reward reward = 9;</code>
     */
    Messages.RewardOrBuilder getRewardOrBuilder();

    /**
     * <code>optional .Suicide suicide = 10;</code>
     */
    boolean hasSuicide();
    /**
     * <code>optional .Suicide suicide = 10;</code>
     */
    Messages.Suicide getSuicide();
    /**
     * <code>optional .Suicide suicide = 10;</code>
     */
    Messages.SuicideOrBuilder getSuicideOrBuilder();

    /**
     * <code>optional .Result result = 11;</code>
     */
    boolean hasResult();
    /**
     * <code>optional .Result result = 11;</code>
     */
    Messages.Result getResult();
    /**
     * <code>optional .Result result = 11;</code>
     */
    Messages.ResultOrBuilder getResultOrBuilder();

    /**
     * <code>optional string error = 12;</code>
     */
    java.lang.String getError();
    /**
     * <code>optional string error = 12;</code>
     */
    com.google.protobuf.ByteString
        getErrorBytes();
  }
  /**
   * Protobuf type {@code Trace}
   */
  public  static final class Trace extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Trace)
      TraceOrBuilder {
    // Use Trace.newBuilder() to construct.
    private Trace(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Trace() {
      subtracesCount_ = "";
      traceAddress_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      transactionHash_ = "";
      transactionPosition_ = "";
      type_ = "";
      action_ = 0;
      error_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Trace(
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

              subtracesCount_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                traceAddress_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000002;
              }
              traceAddress_.add(s);
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              transactionHash_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              transactionPosition_ = s;
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              type_ = s;
              break;
            }
            case 48: {
              int rawValue = input.readEnum();

              action_ = rawValue;
              break;
            }
            case 58: {
              Messages.Call.Builder subBuilder = null;
              if (call_ != null) {
                subBuilder = call_.toBuilder();
              }
              call_ = input.readMessage(Messages.Call.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(call_);
                call_ = subBuilder.buildPartial();
              }

              break;
            }
            case 66: {
              Messages.Create.Builder subBuilder = null;
              if (create_ != null) {
                subBuilder = create_.toBuilder();
              }
              create_ = input.readMessage(Messages.Create.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(create_);
                create_ = subBuilder.buildPartial();
              }

              break;
            }
            case 74: {
              Messages.Reward.Builder subBuilder = null;
              if (reward_ != null) {
                subBuilder = reward_.toBuilder();
              }
              reward_ = input.readMessage(Messages.Reward.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(reward_);
                reward_ = subBuilder.buildPartial();
              }

              break;
            }
            case 82: {
              Messages.Suicide.Builder subBuilder = null;
              if (suicide_ != null) {
                subBuilder = suicide_.toBuilder();
              }
              suicide_ = input.readMessage(Messages.Suicide.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(suicide_);
                suicide_ = subBuilder.buildPartial();
              }

              break;
            }
            case 90: {
              Messages.Result.Builder subBuilder = null;
              if (result_ != null) {
                subBuilder = result_.toBuilder();
              }
              result_ = input.readMessage(Messages.Result.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(result_);
                result_ = subBuilder.buildPartial();
              }

              break;
            }
            case 98: {
              java.lang.String s = input.readStringRequireUtf8();

              error_ = s;
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
          traceAddress_ = traceAddress_.getUnmodifiableView();
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Messages.internal_static_Trace_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Trace_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Trace.class, Messages.Trace.Builder.class);
    }

    /**
     * Protobuf enum {@code Trace.Action}
     */
    public enum Action
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>CALL = 0;</code>
       */
      CALL(0),
      /**
       * <code>CREATE = 1;</code>
       */
      CREATE(1),
      /**
       * <code>REWARD = 2;</code>
       */
      REWARD(2),
      /**
       * <code>SUICIDE = 3;</code>
       */
      SUICIDE(3),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>CALL = 0;</code>
       */
      public static final int CALL_VALUE = 0;
      /**
       * <code>CREATE = 1;</code>
       */
      public static final int CREATE_VALUE = 1;
      /**
       * <code>REWARD = 2;</code>
       */
      public static final int REWARD_VALUE = 2;
      /**
       * <code>SUICIDE = 3;</code>
       */
      public static final int SUICIDE_VALUE = 3;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new java.lang.IllegalArgumentException(
              "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static Action valueOf(int value) {
        return forNumber(value);
      }

      public static Action forNumber(int value) {
        switch (value) {
          case 0: return CALL;
          case 1: return CREATE;
          case 2: return REWARD;
          case 3: return SUICIDE;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<Action>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          Action> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<Action>() {
              public Action findValueByNumber(int number) {
                return Action.forNumber(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return Messages.Trace.getDescriptor().getEnumTypes().get(0);
      }

      private static final Action[] VALUES = values();

      public static Action valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private Action(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:Trace.Action)
    }

    private int bitField0_;
    public static final int SUBTRACES_COUNT_FIELD_NUMBER = 1;
    private volatile java.lang.Object subtracesCount_;
    /**
     * <code>optional string subtraces_count = 1;</code>
     */
    public java.lang.String getSubtracesCount() {
      java.lang.Object ref = subtracesCount_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        subtracesCount_ = s;
        return s;
      }
    }
    /**
     * <code>optional string subtraces_count = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSubtracesCountBytes() {
      java.lang.Object ref = subtracesCount_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        subtracesCount_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TRACE_ADDRESS_FIELD_NUMBER = 2;
    private com.google.protobuf.LazyStringList traceAddress_;
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getTraceAddressList() {
      return traceAddress_;
    }
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    public int getTraceAddressCount() {
      return traceAddress_.size();
    }
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    public java.lang.String getTraceAddress(int index) {
      return traceAddress_.get(index);
    }
    /**
     * <code>repeated string trace_address = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTraceAddressBytes(int index) {
      return traceAddress_.getByteString(index);
    }

    public static final int TRANSACTION_HASH_FIELD_NUMBER = 3;
    private volatile java.lang.Object transactionHash_;
    /**
     * <code>optional string transaction_hash = 3;</code>
     */
    public java.lang.String getTransactionHash() {
      java.lang.Object ref = transactionHash_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        transactionHash_ = s;
        return s;
      }
    }
    /**
     * <code>optional string transaction_hash = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTransactionHashBytes() {
      java.lang.Object ref = transactionHash_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        transactionHash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TRANSACTION_POSITION_FIELD_NUMBER = 4;
    private volatile java.lang.Object transactionPosition_;
    /**
     * <code>optional string transaction_position = 4;</code>
     */
    public java.lang.String getTransactionPosition() {
      java.lang.Object ref = transactionPosition_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        transactionPosition_ = s;
        return s;
      }
    }
    /**
     * <code>optional string transaction_position = 4;</code>
     */
    public com.google.protobuf.ByteString
        getTransactionPositionBytes() {
      java.lang.Object ref = transactionPosition_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        transactionPosition_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TYPE_FIELD_NUMBER = 5;
    private volatile java.lang.Object type_;
    /**
     * <code>optional string type = 5;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      }
    }
    /**
     * <code>optional string type = 5;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ACTION_FIELD_NUMBER = 6;
    private int action_;
    /**
     * <code>optional .Trace.Action action = 6;</code>
     */
    public int getActionValue() {
      return action_;
    }
    /**
     * <code>optional .Trace.Action action = 6;</code>
     */
    public Messages.Trace.Action getAction() {
      Messages.Trace.Action result = Messages.Trace.Action.valueOf(action_);
      return result == null ? Messages.Trace.Action.UNRECOGNIZED : result;
    }

    public static final int CALL_FIELD_NUMBER = 7;
    private Messages.Call call_;
    /**
     * <code>optional .Call call = 7;</code>
     */
    public boolean hasCall() {
      return call_ != null;
    }
    /**
     * <code>optional .Call call = 7;</code>
     */
    public Messages.Call getCall() {
      return call_ == null ? Messages.Call.getDefaultInstance() : call_;
    }
    /**
     * <code>optional .Call call = 7;</code>
     */
    public Messages.CallOrBuilder getCallOrBuilder() {
      return getCall();
    }

    public static final int CREATE_FIELD_NUMBER = 8;
    private Messages.Create create_;
    /**
     * <code>optional .Create create = 8;</code>
     */
    public boolean hasCreate() {
      return create_ != null;
    }
    /**
     * <code>optional .Create create = 8;</code>
     */
    public Messages.Create getCreate() {
      return create_ == null ? Messages.Create.getDefaultInstance() : create_;
    }
    /**
     * <code>optional .Create create = 8;</code>
     */
    public Messages.CreateOrBuilder getCreateOrBuilder() {
      return getCreate();
    }

    public static final int REWARD_FIELD_NUMBER = 9;
    private Messages.Reward reward_;
    /**
     * <code>optional .Reward reward = 9;</code>
     */
    public boolean hasReward() {
      return reward_ != null;
    }
    /**
     * <code>optional .Reward reward = 9;</code>
     */
    public Messages.Reward getReward() {
      return reward_ == null ? Messages.Reward.getDefaultInstance() : reward_;
    }
    /**
     * <code>optional .Reward reward = 9;</code>
     */
    public Messages.RewardOrBuilder getRewardOrBuilder() {
      return getReward();
    }

    public static final int SUICIDE_FIELD_NUMBER = 10;
    private Messages.Suicide suicide_;
    /**
     * <code>optional .Suicide suicide = 10;</code>
     */
    public boolean hasSuicide() {
      return suicide_ != null;
    }
    /**
     * <code>optional .Suicide suicide = 10;</code>
     */
    public Messages.Suicide getSuicide() {
      return suicide_ == null ? Messages.Suicide.getDefaultInstance() : suicide_;
    }
    /**
     * <code>optional .Suicide suicide = 10;</code>
     */
    public Messages.SuicideOrBuilder getSuicideOrBuilder() {
      return getSuicide();
    }

    public static final int RESULT_FIELD_NUMBER = 11;
    private Messages.Result result_;
    /**
     * <code>optional .Result result = 11;</code>
     */
    public boolean hasResult() {
      return result_ != null;
    }
    /**
     * <code>optional .Result result = 11;</code>
     */
    public Messages.Result getResult() {
      return result_ == null ? Messages.Result.getDefaultInstance() : result_;
    }
    /**
     * <code>optional .Result result = 11;</code>
     */
    public Messages.ResultOrBuilder getResultOrBuilder() {
      return getResult();
    }

    public static final int ERROR_FIELD_NUMBER = 12;
    private volatile java.lang.Object error_;
    /**
     * <code>optional string error = 12;</code>
     */
    public java.lang.String getError() {
      java.lang.Object ref = error_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        error_ = s;
        return s;
      }
    }
    /**
     * <code>optional string error = 12;</code>
     */
    public com.google.protobuf.ByteString
        getErrorBytes() {
      java.lang.Object ref = error_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        error_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getSubtracesCountBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, subtracesCount_);
      }
      for (int i = 0; i < traceAddress_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, traceAddress_.getRaw(i));
      }
      if (!getTransactionHashBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, transactionHash_);
      }
      if (!getTransactionPositionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, transactionPosition_);
      }
      if (!getTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, type_);
      }
      if (action_ != Messages.Trace.Action.CALL.getNumber()) {
        output.writeEnum(6, action_);
      }
      if (call_ != null) {
        output.writeMessage(7, getCall());
      }
      if (create_ != null) {
        output.writeMessage(8, getCreate());
      }
      if (reward_ != null) {
        output.writeMessage(9, getReward());
      }
      if (suicide_ != null) {
        output.writeMessage(10, getSuicide());
      }
      if (result_ != null) {
        output.writeMessage(11, getResult());
      }
      if (!getErrorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 12, error_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getSubtracesCountBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, subtracesCount_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < traceAddress_.size(); i++) {
          dataSize += computeStringSizeNoTag(traceAddress_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getTraceAddressList().size();
      }
      if (!getTransactionHashBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, transactionHash_);
      }
      if (!getTransactionPositionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, transactionPosition_);
      }
      if (!getTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, type_);
      }
      if (action_ != Messages.Trace.Action.CALL.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(6, action_);
      }
      if (call_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(7, getCall());
      }
      if (create_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(8, getCreate());
      }
      if (reward_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(9, getReward());
      }
      if (suicide_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(10, getSuicide());
      }
      if (result_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(11, getResult());
      }
      if (!getErrorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, error_);
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
      if (!(obj instanceof Messages.Trace)) {
        return super.equals(obj);
      }
      Messages.Trace other = (Messages.Trace) obj;

      boolean result = true;
      result = result && getSubtracesCount()
          .equals(other.getSubtracesCount());
      result = result && getTraceAddressList()
          .equals(other.getTraceAddressList());
      result = result && getTransactionHash()
          .equals(other.getTransactionHash());
      result = result && getTransactionPosition()
          .equals(other.getTransactionPosition());
      result = result && getType()
          .equals(other.getType());
      result = result && action_ == other.action_;
      result = result && (hasCall() == other.hasCall());
      if (hasCall()) {
        result = result && getCall()
            .equals(other.getCall());
      }
      result = result && (hasCreate() == other.hasCreate());
      if (hasCreate()) {
        result = result && getCreate()
            .equals(other.getCreate());
      }
      result = result && (hasReward() == other.hasReward());
      if (hasReward()) {
        result = result && getReward()
            .equals(other.getReward());
      }
      result = result && (hasSuicide() == other.hasSuicide());
      if (hasSuicide()) {
        result = result && getSuicide()
            .equals(other.getSuicide());
      }
      result = result && (hasResult() == other.hasResult());
      if (hasResult()) {
        result = result && getResult()
            .equals(other.getResult());
      }
      result = result && getError()
          .equals(other.getError());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + SUBTRACES_COUNT_FIELD_NUMBER;
      hash = (53 * hash) + getSubtracesCount().hashCode();
      if (getTraceAddressCount() > 0) {
        hash = (37 * hash) + TRACE_ADDRESS_FIELD_NUMBER;
        hash = (53 * hash) + getTraceAddressList().hashCode();
      }
      hash = (37 * hash) + TRANSACTION_HASH_FIELD_NUMBER;
      hash = (53 * hash) + getTransactionHash().hashCode();
      hash = (37 * hash) + TRANSACTION_POSITION_FIELD_NUMBER;
      hash = (53 * hash) + getTransactionPosition().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType().hashCode();
      hash = (37 * hash) + ACTION_FIELD_NUMBER;
      hash = (53 * hash) + action_;
      if (hasCall()) {
        hash = (37 * hash) + CALL_FIELD_NUMBER;
        hash = (53 * hash) + getCall().hashCode();
      }
      if (hasCreate()) {
        hash = (37 * hash) + CREATE_FIELD_NUMBER;
        hash = (53 * hash) + getCreate().hashCode();
      }
      if (hasReward()) {
        hash = (37 * hash) + REWARD_FIELD_NUMBER;
        hash = (53 * hash) + getReward().hashCode();
      }
      if (hasSuicide()) {
        hash = (37 * hash) + SUICIDE_FIELD_NUMBER;
        hash = (53 * hash) + getSuicide().hashCode();
      }
      if (hasResult()) {
        hash = (37 * hash) + RESULT_FIELD_NUMBER;
        hash = (53 * hash) + getResult().hashCode();
      }
      hash = (37 * hash) + ERROR_FIELD_NUMBER;
      hash = (53 * hash) + getError().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Trace parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Trace parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Trace parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Trace parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Trace parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Trace parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Trace parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Trace parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Trace parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Trace parseFrom(
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
    public static Builder newBuilder(Messages.Trace prototype) {
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
     * Protobuf type {@code Trace}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Trace)
        Messages.TraceOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Trace_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Trace_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Trace.class, Messages.Trace.Builder.class);
      }

      // Construct using Messages.Trace.newBuilder()
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
        subtracesCount_ = "";

        traceAddress_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        transactionHash_ = "";

        transactionPosition_ = "";

        type_ = "";

        action_ = 0;

        if (callBuilder_ == null) {
          call_ = null;
        } else {
          call_ = null;
          callBuilder_ = null;
        }
        if (createBuilder_ == null) {
          create_ = null;
        } else {
          create_ = null;
          createBuilder_ = null;
        }
        if (rewardBuilder_ == null) {
          reward_ = null;
        } else {
          reward_ = null;
          rewardBuilder_ = null;
        }
        if (suicideBuilder_ == null) {
          suicide_ = null;
        } else {
          suicide_ = null;
          suicideBuilder_ = null;
        }
        if (resultBuilder_ == null) {
          result_ = null;
        } else {
          result_ = null;
          resultBuilder_ = null;
        }
        error_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Trace_descriptor;
      }

      public Messages.Trace getDefaultInstanceForType() {
        return Messages.Trace.getDefaultInstance();
      }

      public Messages.Trace build() {
        Messages.Trace result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Trace buildPartial() {
        Messages.Trace result = new Messages.Trace(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.subtracesCount_ = subtracesCount_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          traceAddress_ = traceAddress_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.traceAddress_ = traceAddress_;
        result.transactionHash_ = transactionHash_;
        result.transactionPosition_ = transactionPosition_;
        result.type_ = type_;
        result.action_ = action_;
        if (callBuilder_ == null) {
          result.call_ = call_;
        } else {
          result.call_ = callBuilder_.build();
        }
        if (createBuilder_ == null) {
          result.create_ = create_;
        } else {
          result.create_ = createBuilder_.build();
        }
        if (rewardBuilder_ == null) {
          result.reward_ = reward_;
        } else {
          result.reward_ = rewardBuilder_.build();
        }
        if (suicideBuilder_ == null) {
          result.suicide_ = suicide_;
        } else {
          result.suicide_ = suicideBuilder_.build();
        }
        if (resultBuilder_ == null) {
          result.result_ = result_;
        } else {
          result.result_ = resultBuilder_.build();
        }
        result.error_ = error_;
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
        if (other instanceof Messages.Trace) {
          return mergeFrom((Messages.Trace)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Trace other) {
        if (other == Messages.Trace.getDefaultInstance()) return this;
        if (!other.getSubtracesCount().isEmpty()) {
          subtracesCount_ = other.subtracesCount_;
          onChanged();
        }
        if (!other.traceAddress_.isEmpty()) {
          if (traceAddress_.isEmpty()) {
            traceAddress_ = other.traceAddress_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureTraceAddressIsMutable();
            traceAddress_.addAll(other.traceAddress_);
          }
          onChanged();
        }
        if (!other.getTransactionHash().isEmpty()) {
          transactionHash_ = other.transactionHash_;
          onChanged();
        }
        if (!other.getTransactionPosition().isEmpty()) {
          transactionPosition_ = other.transactionPosition_;
          onChanged();
        }
        if (!other.getType().isEmpty()) {
          type_ = other.type_;
          onChanged();
        }
        if (other.action_ != 0) {
          setActionValue(other.getActionValue());
        }
        if (other.hasCall()) {
          mergeCall(other.getCall());
        }
        if (other.hasCreate()) {
          mergeCreate(other.getCreate());
        }
        if (other.hasReward()) {
          mergeReward(other.getReward());
        }
        if (other.hasSuicide()) {
          mergeSuicide(other.getSuicide());
        }
        if (other.hasResult()) {
          mergeResult(other.getResult());
        }
        if (!other.getError().isEmpty()) {
          error_ = other.error_;
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
        Messages.Trace parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Trace) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object subtracesCount_ = "";
      /**
       * <code>optional string subtraces_count = 1;</code>
       */
      public java.lang.String getSubtracesCount() {
        java.lang.Object ref = subtracesCount_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          subtracesCount_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string subtraces_count = 1;</code>
       */
      public com.google.protobuf.ByteString
          getSubtracesCountBytes() {
        java.lang.Object ref = subtracesCount_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          subtracesCount_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string subtraces_count = 1;</code>
       */
      public Builder setSubtracesCount(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        subtracesCount_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string subtraces_count = 1;</code>
       */
      public Builder clearSubtracesCount() {
        
        subtracesCount_ = getDefaultInstance().getSubtracesCount();
        onChanged();
        return this;
      }
      /**
       * <code>optional string subtraces_count = 1;</code>
       */
      public Builder setSubtracesCountBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        subtracesCount_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList traceAddress_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureTraceAddressIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          traceAddress_ = new com.google.protobuf.LazyStringArrayList(traceAddress_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public com.google.protobuf.ProtocolStringList
          getTraceAddressList() {
        return traceAddress_.getUnmodifiableView();
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public int getTraceAddressCount() {
        return traceAddress_.size();
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public java.lang.String getTraceAddress(int index) {
        return traceAddress_.get(index);
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public com.google.protobuf.ByteString
          getTraceAddressBytes(int index) {
        return traceAddress_.getByteString(index);
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public Builder setTraceAddress(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureTraceAddressIsMutable();
        traceAddress_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public Builder addTraceAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureTraceAddressIsMutable();
        traceAddress_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public Builder addAllTraceAddress(
          java.lang.Iterable<java.lang.String> values) {
        ensureTraceAddressIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, traceAddress_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public Builder clearTraceAddress() {
        traceAddress_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string trace_address = 2;</code>
       */
      public Builder addTraceAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureTraceAddressIsMutable();
        traceAddress_.add(value);
        onChanged();
        return this;
      }

      private java.lang.Object transactionHash_ = "";
      /**
       * <code>optional string transaction_hash = 3;</code>
       */
      public java.lang.String getTransactionHash() {
        java.lang.Object ref = transactionHash_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          transactionHash_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string transaction_hash = 3;</code>
       */
      public com.google.protobuf.ByteString
          getTransactionHashBytes() {
        java.lang.Object ref = transactionHash_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          transactionHash_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string transaction_hash = 3;</code>
       */
      public Builder setTransactionHash(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        transactionHash_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string transaction_hash = 3;</code>
       */
      public Builder clearTransactionHash() {
        
        transactionHash_ = getDefaultInstance().getTransactionHash();
        onChanged();
        return this;
      }
      /**
       * <code>optional string transaction_hash = 3;</code>
       */
      public Builder setTransactionHashBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        transactionHash_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object transactionPosition_ = "";
      /**
       * <code>optional string transaction_position = 4;</code>
       */
      public java.lang.String getTransactionPosition() {
        java.lang.Object ref = transactionPosition_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          transactionPosition_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string transaction_position = 4;</code>
       */
      public com.google.protobuf.ByteString
          getTransactionPositionBytes() {
        java.lang.Object ref = transactionPosition_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          transactionPosition_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string transaction_position = 4;</code>
       */
      public Builder setTransactionPosition(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        transactionPosition_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string transaction_position = 4;</code>
       */
      public Builder clearTransactionPosition() {
        
        transactionPosition_ = getDefaultInstance().getTransactionPosition();
        onChanged();
        return this;
      }
      /**
       * <code>optional string transaction_position = 4;</code>
       */
      public Builder setTransactionPositionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        transactionPosition_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object type_ = "";
      /**
       * <code>optional string type = 5;</code>
       */
      public java.lang.String getType() {
        java.lang.Object ref = type_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          type_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string type = 5;</code>
       */
      public com.google.protobuf.ByteString
          getTypeBytes() {
        java.lang.Object ref = type_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          type_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string type = 5;</code>
       */
      public Builder setType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string type = 5;</code>
       */
      public Builder clearType() {
        
        type_ = getDefaultInstance().getType();
        onChanged();
        return this;
      }
      /**
       * <code>optional string type = 5;</code>
       */
      public Builder setTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        type_ = value;
        onChanged();
        return this;
      }

      private int action_ = 0;
      /**
       * <code>optional .Trace.Action action = 6;</code>
       */
      public int getActionValue() {
        return action_;
      }
      /**
       * <code>optional .Trace.Action action = 6;</code>
       */
      public Builder setActionValue(int value) {
        action_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional .Trace.Action action = 6;</code>
       */
      public Messages.Trace.Action getAction() {
        Messages.Trace.Action result = Messages.Trace.Action.valueOf(action_);
        return result == null ? Messages.Trace.Action.UNRECOGNIZED : result;
      }
      /**
       * <code>optional .Trace.Action action = 6;</code>
       */
      public Builder setAction(Messages.Trace.Action value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        action_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .Trace.Action action = 6;</code>
       */
      public Builder clearAction() {
        
        action_ = 0;
        onChanged();
        return this;
      }

      private Messages.Call call_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Call, Messages.Call.Builder, Messages.CallOrBuilder> callBuilder_;
      /**
       * <code>optional .Call call = 7;</code>
       */
      public boolean hasCall() {
        return callBuilder_ != null || call_ != null;
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Messages.Call getCall() {
        if (callBuilder_ == null) {
          return call_ == null ? Messages.Call.getDefaultInstance() : call_;
        } else {
          return callBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Builder setCall(Messages.Call value) {
        if (callBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          call_ = value;
          onChanged();
        } else {
          callBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Builder setCall(
          Messages.Call.Builder builderForValue) {
        if (callBuilder_ == null) {
          call_ = builderForValue.build();
          onChanged();
        } else {
          callBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Builder mergeCall(Messages.Call value) {
        if (callBuilder_ == null) {
          if (call_ != null) {
            call_ =
              Messages.Call.newBuilder(call_).mergeFrom(value).buildPartial();
          } else {
            call_ = value;
          }
          onChanged();
        } else {
          callBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Builder clearCall() {
        if (callBuilder_ == null) {
          call_ = null;
          onChanged();
        } else {
          call_ = null;
          callBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Messages.Call.Builder getCallBuilder() {
        
        onChanged();
        return getCallFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      public Messages.CallOrBuilder getCallOrBuilder() {
        if (callBuilder_ != null) {
          return callBuilder_.getMessageOrBuilder();
        } else {
          return call_ == null ?
              Messages.Call.getDefaultInstance() : call_;
        }
      }
      /**
       * <code>optional .Call call = 7;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Call, Messages.Call.Builder, Messages.CallOrBuilder> 
          getCallFieldBuilder() {
        if (callBuilder_ == null) {
          callBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.Call, Messages.Call.Builder, Messages.CallOrBuilder>(
                  getCall(),
                  getParentForChildren(),
                  isClean());
          call_ = null;
        }
        return callBuilder_;
      }

      private Messages.Create create_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Create, Messages.Create.Builder, Messages.CreateOrBuilder> createBuilder_;
      /**
       * <code>optional .Create create = 8;</code>
       */
      public boolean hasCreate() {
        return createBuilder_ != null || create_ != null;
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Messages.Create getCreate() {
        if (createBuilder_ == null) {
          return create_ == null ? Messages.Create.getDefaultInstance() : create_;
        } else {
          return createBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Builder setCreate(Messages.Create value) {
        if (createBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          create_ = value;
          onChanged();
        } else {
          createBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Builder setCreate(
          Messages.Create.Builder builderForValue) {
        if (createBuilder_ == null) {
          create_ = builderForValue.build();
          onChanged();
        } else {
          createBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Builder mergeCreate(Messages.Create value) {
        if (createBuilder_ == null) {
          if (create_ != null) {
            create_ =
              Messages.Create.newBuilder(create_).mergeFrom(value).buildPartial();
          } else {
            create_ = value;
          }
          onChanged();
        } else {
          createBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Builder clearCreate() {
        if (createBuilder_ == null) {
          create_ = null;
          onChanged();
        } else {
          create_ = null;
          createBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Messages.Create.Builder getCreateBuilder() {
        
        onChanged();
        return getCreateFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      public Messages.CreateOrBuilder getCreateOrBuilder() {
        if (createBuilder_ != null) {
          return createBuilder_.getMessageOrBuilder();
        } else {
          return create_ == null ?
              Messages.Create.getDefaultInstance() : create_;
        }
      }
      /**
       * <code>optional .Create create = 8;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Create, Messages.Create.Builder, Messages.CreateOrBuilder> 
          getCreateFieldBuilder() {
        if (createBuilder_ == null) {
          createBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.Create, Messages.Create.Builder, Messages.CreateOrBuilder>(
                  getCreate(),
                  getParentForChildren(),
                  isClean());
          create_ = null;
        }
        return createBuilder_;
      }

      private Messages.Reward reward_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Reward, Messages.Reward.Builder, Messages.RewardOrBuilder> rewardBuilder_;
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public boolean hasReward() {
        return rewardBuilder_ != null || reward_ != null;
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Messages.Reward getReward() {
        if (rewardBuilder_ == null) {
          return reward_ == null ? Messages.Reward.getDefaultInstance() : reward_;
        } else {
          return rewardBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Builder setReward(Messages.Reward value) {
        if (rewardBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          reward_ = value;
          onChanged();
        } else {
          rewardBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Builder setReward(
          Messages.Reward.Builder builderForValue) {
        if (rewardBuilder_ == null) {
          reward_ = builderForValue.build();
          onChanged();
        } else {
          rewardBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Builder mergeReward(Messages.Reward value) {
        if (rewardBuilder_ == null) {
          if (reward_ != null) {
            reward_ =
              Messages.Reward.newBuilder(reward_).mergeFrom(value).buildPartial();
          } else {
            reward_ = value;
          }
          onChanged();
        } else {
          rewardBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Builder clearReward() {
        if (rewardBuilder_ == null) {
          reward_ = null;
          onChanged();
        } else {
          reward_ = null;
          rewardBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Messages.Reward.Builder getRewardBuilder() {
        
        onChanged();
        return getRewardFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      public Messages.RewardOrBuilder getRewardOrBuilder() {
        if (rewardBuilder_ != null) {
          return rewardBuilder_.getMessageOrBuilder();
        } else {
          return reward_ == null ?
              Messages.Reward.getDefaultInstance() : reward_;
        }
      }
      /**
       * <code>optional .Reward reward = 9;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Reward, Messages.Reward.Builder, Messages.RewardOrBuilder> 
          getRewardFieldBuilder() {
        if (rewardBuilder_ == null) {
          rewardBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.Reward, Messages.Reward.Builder, Messages.RewardOrBuilder>(
                  getReward(),
                  getParentForChildren(),
                  isClean());
          reward_ = null;
        }
        return rewardBuilder_;
      }

      private Messages.Suicide suicide_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Suicide, Messages.Suicide.Builder, Messages.SuicideOrBuilder> suicideBuilder_;
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public boolean hasSuicide() {
        return suicideBuilder_ != null || suicide_ != null;
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Messages.Suicide getSuicide() {
        if (suicideBuilder_ == null) {
          return suicide_ == null ? Messages.Suicide.getDefaultInstance() : suicide_;
        } else {
          return suicideBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Builder setSuicide(Messages.Suicide value) {
        if (suicideBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          suicide_ = value;
          onChanged();
        } else {
          suicideBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Builder setSuicide(
          Messages.Suicide.Builder builderForValue) {
        if (suicideBuilder_ == null) {
          suicide_ = builderForValue.build();
          onChanged();
        } else {
          suicideBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Builder mergeSuicide(Messages.Suicide value) {
        if (suicideBuilder_ == null) {
          if (suicide_ != null) {
            suicide_ =
              Messages.Suicide.newBuilder(suicide_).mergeFrom(value).buildPartial();
          } else {
            suicide_ = value;
          }
          onChanged();
        } else {
          suicideBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Builder clearSuicide() {
        if (suicideBuilder_ == null) {
          suicide_ = null;
          onChanged();
        } else {
          suicide_ = null;
          suicideBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Messages.Suicide.Builder getSuicideBuilder() {
        
        onChanged();
        return getSuicideFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      public Messages.SuicideOrBuilder getSuicideOrBuilder() {
        if (suicideBuilder_ != null) {
          return suicideBuilder_.getMessageOrBuilder();
        } else {
          return suicide_ == null ?
              Messages.Suicide.getDefaultInstance() : suicide_;
        }
      }
      /**
       * <code>optional .Suicide suicide = 10;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Suicide, Messages.Suicide.Builder, Messages.SuicideOrBuilder> 
          getSuicideFieldBuilder() {
        if (suicideBuilder_ == null) {
          suicideBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.Suicide, Messages.Suicide.Builder, Messages.SuicideOrBuilder>(
                  getSuicide(),
                  getParentForChildren(),
                  isClean());
          suicide_ = null;
        }
        return suicideBuilder_;
      }

      private Messages.Result result_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Result, Messages.Result.Builder, Messages.ResultOrBuilder> resultBuilder_;
      /**
       * <code>optional .Result result = 11;</code>
       */
      public boolean hasResult() {
        return resultBuilder_ != null || result_ != null;
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Messages.Result getResult() {
        if (resultBuilder_ == null) {
          return result_ == null ? Messages.Result.getDefaultInstance() : result_;
        } else {
          return resultBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Builder setResult(Messages.Result value) {
        if (resultBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          result_ = value;
          onChanged();
        } else {
          resultBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Builder setResult(
          Messages.Result.Builder builderForValue) {
        if (resultBuilder_ == null) {
          result_ = builderForValue.build();
          onChanged();
        } else {
          resultBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Builder mergeResult(Messages.Result value) {
        if (resultBuilder_ == null) {
          if (result_ != null) {
            result_ =
              Messages.Result.newBuilder(result_).mergeFrom(value).buildPartial();
          } else {
            result_ = value;
          }
          onChanged();
        } else {
          resultBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Builder clearResult() {
        if (resultBuilder_ == null) {
          result_ = null;
          onChanged();
        } else {
          result_ = null;
          resultBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Messages.Result.Builder getResultBuilder() {
        
        onChanged();
        return getResultFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      public Messages.ResultOrBuilder getResultOrBuilder() {
        if (resultBuilder_ != null) {
          return resultBuilder_.getMessageOrBuilder();
        } else {
          return result_ == null ?
              Messages.Result.getDefaultInstance() : result_;
        }
      }
      /**
       * <code>optional .Result result = 11;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Messages.Result, Messages.Result.Builder, Messages.ResultOrBuilder> 
          getResultFieldBuilder() {
        if (resultBuilder_ == null) {
          resultBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Messages.Result, Messages.Result.Builder, Messages.ResultOrBuilder>(
                  getResult(),
                  getParentForChildren(),
                  isClean());
          result_ = null;
        }
        return resultBuilder_;
      }

      private java.lang.Object error_ = "";
      /**
       * <code>optional string error = 12;</code>
       */
      public java.lang.String getError() {
        java.lang.Object ref = error_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          error_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string error = 12;</code>
       */
      public com.google.protobuf.ByteString
          getErrorBytes() {
        java.lang.Object ref = error_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          error_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string error = 12;</code>
       */
      public Builder setError(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        error_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string error = 12;</code>
       */
      public Builder clearError() {
        
        error_ = getDefaultInstance().getError();
        onChanged();
        return this;
      }
      /**
       * <code>optional string error = 12;</code>
       */
      public Builder setErrorBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        error_ = value;
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


      // @@protoc_insertion_point(builder_scope:Trace)
    }

    // @@protoc_insertion_point(class_scope:Trace)
    private static final Messages.Trace DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Trace();
    }

    public static Messages.Trace getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Trace>
        PARSER = new com.google.protobuf.AbstractParser<Trace>() {
      public Trace parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Trace(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Trace> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Trace> getParserForType() {
      return PARSER;
    }

    public Messages.Trace getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface RewardOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Reward)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string author = 1;</code>
     */
    java.lang.String getAuthor();
    /**
     * <code>optional string author = 1;</code>
     */
    com.google.protobuf.ByteString
        getAuthorBytes();

    /**
     * <code>optional string value = 2;</code>
     */
    java.lang.String getValue();
    /**
     * <code>optional string value = 2;</code>
     */
    com.google.protobuf.ByteString
        getValueBytes();

    /**
     * <code>optional string type = 3;</code>
     */
    java.lang.String getType();
    /**
     * <code>optional string type = 3;</code>
     */
    com.google.protobuf.ByteString
        getTypeBytes();
  }
  /**
   * Protobuf type {@code Reward}
   */
  public  static final class Reward extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Reward)
      RewardOrBuilder {
    // Use Reward.newBuilder() to construct.
    private Reward(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Reward() {
      author_ = "";
      value_ = "";
      type_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Reward(
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

              author_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              value_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              type_ = s;
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
      return Messages.internal_static_Reward_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Reward_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Reward.class, Messages.Reward.Builder.class);
    }

    public static final int AUTHOR_FIELD_NUMBER = 1;
    private volatile java.lang.Object author_;
    /**
     * <code>optional string author = 1;</code>
     */
    public java.lang.String getAuthor() {
      java.lang.Object ref = author_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        author_ = s;
        return s;
      }
    }
    /**
     * <code>optional string author = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAuthorBytes() {
      java.lang.Object ref = author_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        author_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 2;
    private volatile java.lang.Object value_;
    /**
     * <code>optional string value = 2;</code>
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      }
    }
    /**
     * <code>optional string value = 2;</code>
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TYPE_FIELD_NUMBER = 3;
    private volatile java.lang.Object type_;
    /**
     * <code>optional string type = 3;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      }
    }
    /**
     * <code>optional string type = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getAuthorBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, author_);
      }
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, value_);
      }
      if (!getTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, type_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getAuthorBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, author_);
      }
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, value_);
      }
      if (!getTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, type_);
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
      if (!(obj instanceof Messages.Reward)) {
        return super.equals(obj);
      }
      Messages.Reward other = (Messages.Reward) obj;

      boolean result = true;
      result = result && getAuthor()
          .equals(other.getAuthor());
      result = result && getValue()
          .equals(other.getValue());
      result = result && getType()
          .equals(other.getType());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + AUTHOR_FIELD_NUMBER;
      hash = (53 * hash) + getAuthor().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Reward parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Reward parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Reward parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Reward parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Reward parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Reward parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Reward parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Reward parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Reward parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Reward parseFrom(
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
    public static Builder newBuilder(Messages.Reward prototype) {
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
     * Protobuf type {@code Reward}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Reward)
        Messages.RewardOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Reward_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Reward_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Reward.class, Messages.Reward.Builder.class);
      }

      // Construct using Messages.Reward.newBuilder()
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
        author_ = "";

        value_ = "";

        type_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Reward_descriptor;
      }

      public Messages.Reward getDefaultInstanceForType() {
        return Messages.Reward.getDefaultInstance();
      }

      public Messages.Reward build() {
        Messages.Reward result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Reward buildPartial() {
        Messages.Reward result = new Messages.Reward(this);
        result.author_ = author_;
        result.value_ = value_;
        result.type_ = type_;
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
        if (other instanceof Messages.Reward) {
          return mergeFrom((Messages.Reward)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Reward other) {
        if (other == Messages.Reward.getDefaultInstance()) return this;
        if (!other.getAuthor().isEmpty()) {
          author_ = other.author_;
          onChanged();
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
          onChanged();
        }
        if (!other.getType().isEmpty()) {
          type_ = other.type_;
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
        Messages.Reward parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Reward) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object author_ = "";
      /**
       * <code>optional string author = 1;</code>
       */
      public java.lang.String getAuthor() {
        java.lang.Object ref = author_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          author_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string author = 1;</code>
       */
      public com.google.protobuf.ByteString
          getAuthorBytes() {
        java.lang.Object ref = author_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          author_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string author = 1;</code>
       */
      public Builder setAuthor(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        author_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string author = 1;</code>
       */
      public Builder clearAuthor() {
        
        author_ = getDefaultInstance().getAuthor();
        onChanged();
        return this;
      }
      /**
       * <code>optional string author = 1;</code>
       */
      public Builder setAuthorBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        author_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object value_ = "";
      /**
       * <code>optional string value = 2;</code>
       */
      public java.lang.String getValue() {
        java.lang.Object ref = value_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          value_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string value = 2;</code>
       */
      public com.google.protobuf.ByteString
          getValueBytes() {
        java.lang.Object ref = value_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          value_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string value = 2;</code>
       */
      public Builder setValue(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 2;</code>
       */
      public Builder clearValue() {
        
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 2;</code>
       */
      public Builder setValueBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        value_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object type_ = "";
      /**
       * <code>optional string type = 3;</code>
       */
      public java.lang.String getType() {
        java.lang.Object ref = type_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          type_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string type = 3;</code>
       */
      public com.google.protobuf.ByteString
          getTypeBytes() {
        java.lang.Object ref = type_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          type_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string type = 3;</code>
       */
      public Builder setType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string type = 3;</code>
       */
      public Builder clearType() {
        
        type_ = getDefaultInstance().getType();
        onChanged();
        return this;
      }
      /**
       * <code>optional string type = 3;</code>
       */
      public Builder setTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        type_ = value;
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


      // @@protoc_insertion_point(builder_scope:Reward)
    }

    // @@protoc_insertion_point(class_scope:Reward)
    private static final Messages.Reward DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Reward();
    }

    public static Messages.Reward getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Reward>
        PARSER = new com.google.protobuf.AbstractParser<Reward>() {
      public Reward parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Reward(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Reward> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Reward> getParserForType() {
      return PARSER;
    }

    public Messages.Reward getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface CallOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Call)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string type = 1;</code>
     */
    java.lang.String getType();
    /**
     * <code>optional string type = 1;</code>
     */
    com.google.protobuf.ByteString
        getTypeBytes();

    /**
     * <code>optional string from = 2;</code>
     */
    java.lang.String getFrom();
    /**
     * <code>optional string from = 2;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    /**
     * <code>optional string gas = 3;</code>
     */
    java.lang.String getGas();
    /**
     * <code>optional string gas = 3;</code>
     */
    com.google.protobuf.ByteString
        getGasBytes();

    /**
     * <code>optional string input = 4;</code>
     */
    java.lang.String getInput();
    /**
     * <code>optional string input = 4;</code>
     */
    com.google.protobuf.ByteString
        getInputBytes();

    /**
     * <code>optional string to = 5;</code>
     */
    java.lang.String getTo();
    /**
     * <code>optional string to = 5;</code>
     */
    com.google.protobuf.ByteString
        getToBytes();

    /**
     * <code>optional string value = 6;</code>
     */
    java.lang.String getValue();
    /**
     * <code>optional string value = 6;</code>
     */
    com.google.protobuf.ByteString
        getValueBytes();
  }
  /**
   * Protobuf type {@code Call}
   */
  public  static final class Call extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Call)
      CallOrBuilder {
    // Use Call.newBuilder() to construct.
    private Call(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Call() {
      type_ = "";
      from_ = "";
      gas_ = "";
      input_ = "";
      to_ = "";
      value_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Call(
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

              type_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              from_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              gas_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              input_ = s;
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              to_ = s;
              break;
            }
            case 50: {
              java.lang.String s = input.readStringRequireUtf8();

              value_ = s;
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
      return Messages.internal_static_Call_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Call_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Call.class, Messages.Call.Builder.class);
    }

    public static final int TYPE_FIELD_NUMBER = 1;
    private volatile java.lang.Object type_;
    /**
     * <code>optional string type = 1;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      }
    }
    /**
     * <code>optional string type = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int FROM_FIELD_NUMBER = 2;
    private volatile java.lang.Object from_;
    /**
     * <code>optional string from = 2;</code>
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        from_ = s;
        return s;
      }
    }
    /**
     * <code>optional string from = 2;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GAS_FIELD_NUMBER = 3;
    private volatile java.lang.Object gas_;
    /**
     * <code>optional string gas = 3;</code>
     */
    public java.lang.String getGas() {
      java.lang.Object ref = gas_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gas_ = s;
        return s;
      }
    }
    /**
     * <code>optional string gas = 3;</code>
     */
    public com.google.protobuf.ByteString
        getGasBytes() {
      java.lang.Object ref = gas_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gas_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INPUT_FIELD_NUMBER = 4;
    private volatile java.lang.Object input_;
    /**
     * <code>optional string input = 4;</code>
     */
    public java.lang.String getInput() {
      java.lang.Object ref = input_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        input_ = s;
        return s;
      }
    }
    /**
     * <code>optional string input = 4;</code>
     */
    public com.google.protobuf.ByteString
        getInputBytes() {
      java.lang.Object ref = input_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        input_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TO_FIELD_NUMBER = 5;
    private volatile java.lang.Object to_;
    /**
     * <code>optional string to = 5;</code>
     */
    public java.lang.String getTo() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        to_ = s;
        return s;
      }
    }
    /**
     * <code>optional string to = 5;</code>
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 6;
    private volatile java.lang.Object value_;
    /**
     * <code>optional string value = 6;</code>
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      }
    }
    /**
     * <code>optional string value = 6;</code>
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, type_);
      }
      if (!getFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, from_);
      }
      if (!getGasBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, gas_);
      }
      if (!getInputBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, input_);
      }
      if (!getToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, to_);
      }
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, value_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, type_);
      }
      if (!getFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, from_);
      }
      if (!getGasBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, gas_);
      }
      if (!getInputBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, input_);
      }
      if (!getToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, to_);
      }
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, value_);
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
      if (!(obj instanceof Messages.Call)) {
        return super.equals(obj);
      }
      Messages.Call other = (Messages.Call) obj;

      boolean result = true;
      result = result && getType()
          .equals(other.getType());
      result = result && getFrom()
          .equals(other.getFrom());
      result = result && getGas()
          .equals(other.getGas());
      result = result && getInput()
          .equals(other.getInput());
      result = result && getTo()
          .equals(other.getTo());
      result = result && getValue()
          .equals(other.getValue());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType().hashCode();
      hash = (37 * hash) + FROM_FIELD_NUMBER;
      hash = (53 * hash) + getFrom().hashCode();
      hash = (37 * hash) + GAS_FIELD_NUMBER;
      hash = (53 * hash) + getGas().hashCode();
      hash = (37 * hash) + INPUT_FIELD_NUMBER;
      hash = (53 * hash) + getInput().hashCode();
      hash = (37 * hash) + TO_FIELD_NUMBER;
      hash = (53 * hash) + getTo().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Call parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Call parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Call parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Call parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Call parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Call parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Call parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Call parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Call parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Call parseFrom(
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
    public static Builder newBuilder(Messages.Call prototype) {
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
     * Protobuf type {@code Call}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Call)
        Messages.CallOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Call_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Call_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Call.class, Messages.Call.Builder.class);
      }

      // Construct using Messages.Call.newBuilder()
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
        type_ = "";

        from_ = "";

        gas_ = "";

        input_ = "";

        to_ = "";

        value_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Call_descriptor;
      }

      public Messages.Call getDefaultInstanceForType() {
        return Messages.Call.getDefaultInstance();
      }

      public Messages.Call build() {
        Messages.Call result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Call buildPartial() {
        Messages.Call result = new Messages.Call(this);
        result.type_ = type_;
        result.from_ = from_;
        result.gas_ = gas_;
        result.input_ = input_;
        result.to_ = to_;
        result.value_ = value_;
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
        if (other instanceof Messages.Call) {
          return mergeFrom((Messages.Call)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Call other) {
        if (other == Messages.Call.getDefaultInstance()) return this;
        if (!other.getType().isEmpty()) {
          type_ = other.type_;
          onChanged();
        }
        if (!other.getFrom().isEmpty()) {
          from_ = other.from_;
          onChanged();
        }
        if (!other.getGas().isEmpty()) {
          gas_ = other.gas_;
          onChanged();
        }
        if (!other.getInput().isEmpty()) {
          input_ = other.input_;
          onChanged();
        }
        if (!other.getTo().isEmpty()) {
          to_ = other.to_;
          onChanged();
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
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
        Messages.Call parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Call) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object type_ = "";
      /**
       * <code>optional string type = 1;</code>
       */
      public java.lang.String getType() {
        java.lang.Object ref = type_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          type_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string type = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTypeBytes() {
        java.lang.Object ref = type_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          type_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string type = 1;</code>
       */
      public Builder setType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string type = 1;</code>
       */
      public Builder clearType() {
        
        type_ = getDefaultInstance().getType();
        onChanged();
        return this;
      }
      /**
       * <code>optional string type = 1;</code>
       */
      public Builder setTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        type_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object from_ = "";
      /**
       * <code>optional string from = 2;</code>
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public Builder clearFrom() {
        
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        from_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object gas_ = "";
      /**
       * <code>optional string gas = 3;</code>
       */
      public java.lang.String getGas() {
        java.lang.Object ref = gas_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gas_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string gas = 3;</code>
       */
      public com.google.protobuf.ByteString
          getGasBytes() {
        java.lang.Object ref = gas_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gas_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string gas = 3;</code>
       */
      public Builder setGas(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gas_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas = 3;</code>
       */
      public Builder clearGas() {
        
        gas_ = getDefaultInstance().getGas();
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas = 3;</code>
       */
      public Builder setGasBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gas_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object input_ = "";
      /**
       * <code>optional string input = 4;</code>
       */
      public java.lang.String getInput() {
        java.lang.Object ref = input_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          input_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string input = 4;</code>
       */
      public com.google.protobuf.ByteString
          getInputBytes() {
        java.lang.Object ref = input_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          input_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string input = 4;</code>
       */
      public Builder setInput(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        input_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string input = 4;</code>
       */
      public Builder clearInput() {
        
        input_ = getDefaultInstance().getInput();
        onChanged();
        return this;
      }
      /**
       * <code>optional string input = 4;</code>
       */
      public Builder setInputBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        input_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object to_ = "";
      /**
       * <code>optional string to = 5;</code>
       */
      public java.lang.String getTo() {
        java.lang.Object ref = to_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          to_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public com.google.protobuf.ByteString
          getToBytes() {
        java.lang.Object ref = to_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          to_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public Builder setTo(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        to_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public Builder clearTo() {
        
        to_ = getDefaultInstance().getTo();
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 5;</code>
       */
      public Builder setToBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        to_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object value_ = "";
      /**
       * <code>optional string value = 6;</code>
       */
      public java.lang.String getValue() {
        java.lang.Object ref = value_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          value_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string value = 6;</code>
       */
      public com.google.protobuf.ByteString
          getValueBytes() {
        java.lang.Object ref = value_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          value_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string value = 6;</code>
       */
      public Builder setValue(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 6;</code>
       */
      public Builder clearValue() {
        
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 6;</code>
       */
      public Builder setValueBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        value_ = value;
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


      // @@protoc_insertion_point(builder_scope:Call)
    }

    // @@protoc_insertion_point(class_scope:Call)
    private static final Messages.Call DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Call();
    }

    public static Messages.Call getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Call>
        PARSER = new com.google.protobuf.AbstractParser<Call>() {
      public Call parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Call(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Call> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Call> getParserForType() {
      return PARSER;
    }

    public Messages.Call getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface CreateOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Create)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string from = 1;</code>
     */
    java.lang.String getFrom();
    /**
     * <code>optional string from = 1;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    /**
     * <code>optional string gas = 2;</code>
     */
    java.lang.String getGas();
    /**
     * <code>optional string gas = 2;</code>
     */
    com.google.protobuf.ByteString
        getGasBytes();

    /**
     * <code>optional string init = 3;</code>
     */
    java.lang.String getInit();
    /**
     * <code>optional string init = 3;</code>
     */
    com.google.protobuf.ByteString
        getInitBytes();

    /**
     * <code>optional string value = 4;</code>
     */
    java.lang.String getValue();
    /**
     * <code>optional string value = 4;</code>
     */
    com.google.protobuf.ByteString
        getValueBytes();
  }
  /**
   * Protobuf type {@code Create}
   */
  public  static final class Create extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Create)
      CreateOrBuilder {
    // Use Create.newBuilder() to construct.
    private Create(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Create() {
      from_ = "";
      gas_ = "";
      init_ = "";
      value_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Create(
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

              from_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              gas_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              init_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              value_ = s;
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
      return Messages.internal_static_Create_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Create_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Create.class, Messages.Create.Builder.class);
    }

    public static final int FROM_FIELD_NUMBER = 1;
    private volatile java.lang.Object from_;
    /**
     * <code>optional string from = 1;</code>
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        from_ = s;
        return s;
      }
    }
    /**
     * <code>optional string from = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GAS_FIELD_NUMBER = 2;
    private volatile java.lang.Object gas_;
    /**
     * <code>optional string gas = 2;</code>
     */
    public java.lang.String getGas() {
      java.lang.Object ref = gas_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gas_ = s;
        return s;
      }
    }
    /**
     * <code>optional string gas = 2;</code>
     */
    public com.google.protobuf.ByteString
        getGasBytes() {
      java.lang.Object ref = gas_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gas_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INIT_FIELD_NUMBER = 3;
    private volatile java.lang.Object init_;
    /**
     * <code>optional string init = 3;</code>
     */
    public java.lang.String getInit() {
      java.lang.Object ref = init_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        init_ = s;
        return s;
      }
    }
    /**
     * <code>optional string init = 3;</code>
     */
    public com.google.protobuf.ByteString
        getInitBytes() {
      java.lang.Object ref = init_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        init_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 4;
    private volatile java.lang.Object value_;
    /**
     * <code>optional string value = 4;</code>
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      }
    }
    /**
     * <code>optional string value = 4;</code>
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, from_);
      }
      if (!getGasBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, gas_);
      }
      if (!getInitBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, init_);
      }
      if (!getValueBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, value_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, from_);
      }
      if (!getGasBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, gas_);
      }
      if (!getInitBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, init_);
      }
      if (!getValueBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, value_);
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
      if (!(obj instanceof Messages.Create)) {
        return super.equals(obj);
      }
      Messages.Create other = (Messages.Create) obj;

      boolean result = true;
      result = result && getFrom()
          .equals(other.getFrom());
      result = result && getGas()
          .equals(other.getGas());
      result = result && getInit()
          .equals(other.getInit());
      result = result && getValue()
          .equals(other.getValue());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + FROM_FIELD_NUMBER;
      hash = (53 * hash) + getFrom().hashCode();
      hash = (37 * hash) + GAS_FIELD_NUMBER;
      hash = (53 * hash) + getGas().hashCode();
      hash = (37 * hash) + INIT_FIELD_NUMBER;
      hash = (53 * hash) + getInit().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Create parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Create parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Create parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Create parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Create parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Create parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Create parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Create parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Create parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Create parseFrom(
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
    public static Builder newBuilder(Messages.Create prototype) {
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
     * Protobuf type {@code Create}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Create)
        Messages.CreateOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Create_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Create_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Create.class, Messages.Create.Builder.class);
      }

      // Construct using Messages.Create.newBuilder()
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
        from_ = "";

        gas_ = "";

        init_ = "";

        value_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Create_descriptor;
      }

      public Messages.Create getDefaultInstanceForType() {
        return Messages.Create.getDefaultInstance();
      }

      public Messages.Create build() {
        Messages.Create result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Create buildPartial() {
        Messages.Create result = new Messages.Create(this);
        result.from_ = from_;
        result.gas_ = gas_;
        result.init_ = init_;
        result.value_ = value_;
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
        if (other instanceof Messages.Create) {
          return mergeFrom((Messages.Create)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Create other) {
        if (other == Messages.Create.getDefaultInstance()) return this;
        if (!other.getFrom().isEmpty()) {
          from_ = other.from_;
          onChanged();
        }
        if (!other.getGas().isEmpty()) {
          gas_ = other.gas_;
          onChanged();
        }
        if (!other.getInit().isEmpty()) {
          init_ = other.init_;
          onChanged();
        }
        if (!other.getValue().isEmpty()) {
          value_ = other.value_;
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
        Messages.Create parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Create) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object from_ = "";
      /**
       * <code>optional string from = 1;</code>
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public Builder clearFrom() {
        
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        from_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object gas_ = "";
      /**
       * <code>optional string gas = 2;</code>
       */
      public java.lang.String getGas() {
        java.lang.Object ref = gas_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gas_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string gas = 2;</code>
       */
      public com.google.protobuf.ByteString
          getGasBytes() {
        java.lang.Object ref = gas_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gas_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string gas = 2;</code>
       */
      public Builder setGas(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gas_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas = 2;</code>
       */
      public Builder clearGas() {
        
        gas_ = getDefaultInstance().getGas();
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas = 2;</code>
       */
      public Builder setGasBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gas_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object init_ = "";
      /**
       * <code>optional string init = 3;</code>
       */
      public java.lang.String getInit() {
        java.lang.Object ref = init_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          init_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string init = 3;</code>
       */
      public com.google.protobuf.ByteString
          getInitBytes() {
        java.lang.Object ref = init_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          init_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string init = 3;</code>
       */
      public Builder setInit(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        init_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string init = 3;</code>
       */
      public Builder clearInit() {
        
        init_ = getDefaultInstance().getInit();
        onChanged();
        return this;
      }
      /**
       * <code>optional string init = 3;</code>
       */
      public Builder setInitBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        init_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object value_ = "";
      /**
       * <code>optional string value = 4;</code>
       */
      public java.lang.String getValue() {
        java.lang.Object ref = value_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          value_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string value = 4;</code>
       */
      public com.google.protobuf.ByteString
          getValueBytes() {
        java.lang.Object ref = value_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          value_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string value = 4;</code>
       */
      public Builder setValue(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 4;</code>
       */
      public Builder clearValue() {
        
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }
      /**
       * <code>optional string value = 4;</code>
       */
      public Builder setValueBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        value_ = value;
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


      // @@protoc_insertion_point(builder_scope:Create)
    }

    // @@protoc_insertion_point(class_scope:Create)
    private static final Messages.Create DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Create();
    }

    public static Messages.Create getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Create>
        PARSER = new com.google.protobuf.AbstractParser<Create>() {
      public Create parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Create(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Create> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Create> getParserForType() {
      return PARSER;
    }

    public Messages.Create getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface SuicideOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Suicide)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string address = 1;</code>
     */
    java.lang.String getAddress();
    /**
     * <code>optional string address = 1;</code>
     */
    com.google.protobuf.ByteString
        getAddressBytes();

    /**
     * <code>optional string balance = 2;</code>
     */
    java.lang.String getBalance();
    /**
     * <code>optional string balance = 2;</code>
     */
    com.google.protobuf.ByteString
        getBalanceBytes();

    /**
     * <code>optional string refund_address = 3;</code>
     */
    java.lang.String getRefundAddress();
    /**
     * <code>optional string refund_address = 3;</code>
     */
    com.google.protobuf.ByteString
        getRefundAddressBytes();
  }
  /**
   * Protobuf type {@code Suicide}
   */
  public  static final class Suicide extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Suicide)
      SuicideOrBuilder {
    // Use Suicide.newBuilder() to construct.
    private Suicide(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Suicide() {
      address_ = "";
      balance_ = "";
      refundAddress_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Suicide(
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

              address_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              balance_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              refundAddress_ = s;
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
      return Messages.internal_static_Suicide_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Suicide_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Suicide.class, Messages.Suicide.Builder.class);
    }

    public static final int ADDRESS_FIELD_NUMBER = 1;
    private volatile java.lang.Object address_;
    /**
     * <code>optional string address = 1;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      }
    }
    /**
     * <code>optional string address = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BALANCE_FIELD_NUMBER = 2;
    private volatile java.lang.Object balance_;
    /**
     * <code>optional string balance = 2;</code>
     */
    public java.lang.String getBalance() {
      java.lang.Object ref = balance_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        balance_ = s;
        return s;
      }
    }
    /**
     * <code>optional string balance = 2;</code>
     */
    public com.google.protobuf.ByteString
        getBalanceBytes() {
      java.lang.Object ref = balance_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        balance_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REFUND_ADDRESS_FIELD_NUMBER = 3;
    private volatile java.lang.Object refundAddress_;
    /**
     * <code>optional string refund_address = 3;</code>
     */
    public java.lang.String getRefundAddress() {
      java.lang.Object ref = refundAddress_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        refundAddress_ = s;
        return s;
      }
    }
    /**
     * <code>optional string refund_address = 3;</code>
     */
    public com.google.protobuf.ByteString
        getRefundAddressBytes() {
      java.lang.Object ref = refundAddress_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        refundAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getAddressBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, address_);
      }
      if (!getBalanceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, balance_);
      }
      if (!getRefundAddressBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, refundAddress_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getAddressBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, address_);
      }
      if (!getBalanceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, balance_);
      }
      if (!getRefundAddressBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, refundAddress_);
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
      if (!(obj instanceof Messages.Suicide)) {
        return super.equals(obj);
      }
      Messages.Suicide other = (Messages.Suicide) obj;

      boolean result = true;
      result = result && getAddress()
          .equals(other.getAddress());
      result = result && getBalance()
          .equals(other.getBalance());
      result = result && getRefundAddress()
          .equals(other.getRefundAddress());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getAddress().hashCode();
      hash = (37 * hash) + BALANCE_FIELD_NUMBER;
      hash = (53 * hash) + getBalance().hashCode();
      hash = (37 * hash) + REFUND_ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getRefundAddress().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Suicide parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Suicide parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Suicide parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Suicide parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Suicide parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Suicide parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Suicide parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Suicide parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Suicide parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Suicide parseFrom(
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
    public static Builder newBuilder(Messages.Suicide prototype) {
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
     * Protobuf type {@code Suicide}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Suicide)
        Messages.SuicideOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Suicide_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Suicide_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Suicide.class, Messages.Suicide.Builder.class);
      }

      // Construct using Messages.Suicide.newBuilder()
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
        address_ = "";

        balance_ = "";

        refundAddress_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Suicide_descriptor;
      }

      public Messages.Suicide getDefaultInstanceForType() {
        return Messages.Suicide.getDefaultInstance();
      }

      public Messages.Suicide build() {
        Messages.Suicide result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Suicide buildPartial() {
        Messages.Suicide result = new Messages.Suicide(this);
        result.address_ = address_;
        result.balance_ = balance_;
        result.refundAddress_ = refundAddress_;
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
        if (other instanceof Messages.Suicide) {
          return mergeFrom((Messages.Suicide)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Suicide other) {
        if (other == Messages.Suicide.getDefaultInstance()) return this;
        if (!other.getAddress().isEmpty()) {
          address_ = other.address_;
          onChanged();
        }
        if (!other.getBalance().isEmpty()) {
          balance_ = other.balance_;
          onChanged();
        }
        if (!other.getRefundAddress().isEmpty()) {
          refundAddress_ = other.refundAddress_;
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
        Messages.Suicide parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Suicide) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object address_ = "";
      /**
       * <code>optional string address = 1;</code>
       */
      public java.lang.String getAddress() {
        java.lang.Object ref = address_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          address_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public com.google.protobuf.ByteString
          getAddressBytes() {
        java.lang.Object ref = address_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          address_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public Builder setAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        address_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public Builder clearAddress() {
        
        address_ = getDefaultInstance().getAddress();
        onChanged();
        return this;
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public Builder setAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        address_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object balance_ = "";
      /**
       * <code>optional string balance = 2;</code>
       */
      public java.lang.String getBalance() {
        java.lang.Object ref = balance_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          balance_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string balance = 2;</code>
       */
      public com.google.protobuf.ByteString
          getBalanceBytes() {
        java.lang.Object ref = balance_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          balance_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string balance = 2;</code>
       */
      public Builder setBalance(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        balance_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string balance = 2;</code>
       */
      public Builder clearBalance() {
        
        balance_ = getDefaultInstance().getBalance();
        onChanged();
        return this;
      }
      /**
       * <code>optional string balance = 2;</code>
       */
      public Builder setBalanceBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        balance_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object refundAddress_ = "";
      /**
       * <code>optional string refund_address = 3;</code>
       */
      public java.lang.String getRefundAddress() {
        java.lang.Object ref = refundAddress_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          refundAddress_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string refund_address = 3;</code>
       */
      public com.google.protobuf.ByteString
          getRefundAddressBytes() {
        java.lang.Object ref = refundAddress_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          refundAddress_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string refund_address = 3;</code>
       */
      public Builder setRefundAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        refundAddress_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string refund_address = 3;</code>
       */
      public Builder clearRefundAddress() {
        
        refundAddress_ = getDefaultInstance().getRefundAddress();
        onChanged();
        return this;
      }
      /**
       * <code>optional string refund_address = 3;</code>
       */
      public Builder setRefundAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        refundAddress_ = value;
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


      // @@protoc_insertion_point(builder_scope:Suicide)
    }

    // @@protoc_insertion_point(class_scope:Suicide)
    private static final Messages.Suicide DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Suicide();
    }

    public static Messages.Suicide getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Suicide>
        PARSER = new com.google.protobuf.AbstractParser<Suicide>() {
      public Suicide parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Suicide(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Suicide> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Suicide> getParserForType() {
      return PARSER;
    }

    public Messages.Suicide getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ResultOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Result)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string address = 1;</code>
     */
    java.lang.String getAddress();
    /**
     * <code>optional string address = 1;</code>
     */
    com.google.protobuf.ByteString
        getAddressBytes();

    /**
     * <code>optional string code = 2;</code>
     */
    java.lang.String getCode();
    /**
     * <code>optional string code = 2;</code>
     */
    com.google.protobuf.ByteString
        getCodeBytes();

    /**
     * <code>optional string gas_used = 3;</code>
     */
    java.lang.String getGasUsed();
    /**
     * <code>optional string gas_used = 3;</code>
     */
    com.google.protobuf.ByteString
        getGasUsedBytes();

    /**
     * <code>optional string output = 4;</code>
     */
    java.lang.String getOutput();
    /**
     * <code>optional string output = 4;</code>
     */
    com.google.protobuf.ByteString
        getOutputBytes();
  }
  /**
   * Protobuf type {@code Result}
   */
  public  static final class Result extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Result)
      ResultOrBuilder {
    // Use Result.newBuilder() to construct.
    private Result(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Result() {
      address_ = "";
      code_ = "";
      gasUsed_ = "";
      output_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Result(
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

              address_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              code_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              gasUsed_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              output_ = s;
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
      return Messages.internal_static_Result_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Messages.internal_static_Result_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Messages.Result.class, Messages.Result.Builder.class);
    }

    public static final int ADDRESS_FIELD_NUMBER = 1;
    private volatile java.lang.Object address_;
    /**
     * <code>optional string address = 1;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      }
    }
    /**
     * <code>optional string address = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CODE_FIELD_NUMBER = 2;
    private volatile java.lang.Object code_;
    /**
     * <code>optional string code = 2;</code>
     */
    public java.lang.String getCode() {
      java.lang.Object ref = code_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        code_ = s;
        return s;
      }
    }
    /**
     * <code>optional string code = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCodeBytes() {
      java.lang.Object ref = code_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GAS_USED_FIELD_NUMBER = 3;
    private volatile java.lang.Object gasUsed_;
    /**
     * <code>optional string gas_used = 3;</code>
     */
    public java.lang.String getGasUsed() {
      java.lang.Object ref = gasUsed_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gasUsed_ = s;
        return s;
      }
    }
    /**
     * <code>optional string gas_used = 3;</code>
     */
    public com.google.protobuf.ByteString
        getGasUsedBytes() {
      java.lang.Object ref = gasUsed_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gasUsed_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int OUTPUT_FIELD_NUMBER = 4;
    private volatile java.lang.Object output_;
    /**
     * <code>optional string output = 4;</code>
     */
    public java.lang.String getOutput() {
      java.lang.Object ref = output_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        output_ = s;
        return s;
      }
    }
    /**
     * <code>optional string output = 4;</code>
     */
    public com.google.protobuf.ByteString
        getOutputBytes() {
      java.lang.Object ref = output_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        output_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getAddressBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, address_);
      }
      if (!getCodeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, code_);
      }
      if (!getGasUsedBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, gasUsed_);
      }
      if (!getOutputBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, output_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getAddressBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, address_);
      }
      if (!getCodeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, code_);
      }
      if (!getGasUsedBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, gasUsed_);
      }
      if (!getOutputBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, output_);
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
      if (!(obj instanceof Messages.Result)) {
        return super.equals(obj);
      }
      Messages.Result other = (Messages.Result) obj;

      boolean result = true;
      result = result && getAddress()
          .equals(other.getAddress());
      result = result && getCode()
          .equals(other.getCode());
      result = result && getGasUsed()
          .equals(other.getGasUsed());
      result = result && getOutput()
          .equals(other.getOutput());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getAddress().hashCode();
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCode().hashCode();
      hash = (37 * hash) + GAS_USED_FIELD_NUMBER;
      hash = (53 * hash) + getGasUsed().hashCode();
      hash = (37 * hash) + OUTPUT_FIELD_NUMBER;
      hash = (53 * hash) + getOutput().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Messages.Result parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Result parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Result parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Messages.Result parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Messages.Result parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Result parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Result parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Messages.Result parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Messages.Result parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Messages.Result parseFrom(
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
    public static Builder newBuilder(Messages.Result prototype) {
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
     * Protobuf type {@code Result}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Result)
        Messages.ResultOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Messages.internal_static_Result_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Messages.internal_static_Result_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Messages.Result.class, Messages.Result.Builder.class);
      }

      // Construct using Messages.Result.newBuilder()
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
        address_ = "";

        code_ = "";

        gasUsed_ = "";

        output_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Messages.internal_static_Result_descriptor;
      }

      public Messages.Result getDefaultInstanceForType() {
        return Messages.Result.getDefaultInstance();
      }

      public Messages.Result build() {
        Messages.Result result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Messages.Result buildPartial() {
        Messages.Result result = new Messages.Result(this);
        result.address_ = address_;
        result.code_ = code_;
        result.gasUsed_ = gasUsed_;
        result.output_ = output_;
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
        if (other instanceof Messages.Result) {
          return mergeFrom((Messages.Result)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Messages.Result other) {
        if (other == Messages.Result.getDefaultInstance()) return this;
        if (!other.getAddress().isEmpty()) {
          address_ = other.address_;
          onChanged();
        }
        if (!other.getCode().isEmpty()) {
          code_ = other.code_;
          onChanged();
        }
        if (!other.getGasUsed().isEmpty()) {
          gasUsed_ = other.gasUsed_;
          onChanged();
        }
        if (!other.getOutput().isEmpty()) {
          output_ = other.output_;
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
        Messages.Result parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Messages.Result) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object address_ = "";
      /**
       * <code>optional string address = 1;</code>
       */
      public java.lang.String getAddress() {
        java.lang.Object ref = address_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          address_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public com.google.protobuf.ByteString
          getAddressBytes() {
        java.lang.Object ref = address_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          address_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public Builder setAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        address_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public Builder clearAddress() {
        
        address_ = getDefaultInstance().getAddress();
        onChanged();
        return this;
      }
      /**
       * <code>optional string address = 1;</code>
       */
      public Builder setAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        address_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object code_ = "";
      /**
       * <code>optional string code = 2;</code>
       */
      public java.lang.String getCode() {
        java.lang.Object ref = code_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          code_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string code = 2;</code>
       */
      public com.google.protobuf.ByteString
          getCodeBytes() {
        java.lang.Object ref = code_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          code_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string code = 2;</code>
       */
      public Builder setCode(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        code_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string code = 2;</code>
       */
      public Builder clearCode() {
        
        code_ = getDefaultInstance().getCode();
        onChanged();
        return this;
      }
      /**
       * <code>optional string code = 2;</code>
       */
      public Builder setCodeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        code_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object gasUsed_ = "";
      /**
       * <code>optional string gas_used = 3;</code>
       */
      public java.lang.String getGasUsed() {
        java.lang.Object ref = gasUsed_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gasUsed_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string gas_used = 3;</code>
       */
      public com.google.protobuf.ByteString
          getGasUsedBytes() {
        java.lang.Object ref = gasUsed_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gasUsed_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string gas_used = 3;</code>
       */
      public Builder setGasUsed(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gasUsed_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas_used = 3;</code>
       */
      public Builder clearGasUsed() {
        
        gasUsed_ = getDefaultInstance().getGasUsed();
        onChanged();
        return this;
      }
      /**
       * <code>optional string gas_used = 3;</code>
       */
      public Builder setGasUsedBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gasUsed_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object output_ = "";
      /**
       * <code>optional string output = 4;</code>
       */
      public java.lang.String getOutput() {
        java.lang.Object ref = output_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          output_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string output = 4;</code>
       */
      public com.google.protobuf.ByteString
          getOutputBytes() {
        java.lang.Object ref = output_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          output_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string output = 4;</code>
       */
      public Builder setOutput(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        output_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string output = 4;</code>
       */
      public Builder clearOutput() {
        
        output_ = getDefaultInstance().getOutput();
        onChanged();
        return this;
      }
      /**
       * <code>optional string output = 4;</code>
       */
      public Builder setOutputBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        output_ = value;
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


      // @@protoc_insertion_point(builder_scope:Result)
    }

    // @@protoc_insertion_point(class_scope:Result)
    private static final Messages.Result DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Messages.Result();
    }

    public static Messages.Result getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Result>
        PARSER = new com.google.protobuf.AbstractParser<Result>() {
      public Result parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Result(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Result> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Result> getParserForType() {
      return PARSER;
    }

    public Messages.Result getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Block_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Block_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Transaction_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Transaction_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SRV_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SRV_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Receipt_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Receipt_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Trace_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Trace_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Reward_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Reward_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Call_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Call_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Create_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Create_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Suicide_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Suicide_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Result_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Result_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016messages.proto\"\204\001\n\005Block\022\014\n\004hash\030\001 \001(\t" +
      "\022\016\n\006number\030\002 \001(\t\022\021\n\ttimestamp\030\003 \001(\t\022\"\n\014t" +
      "ransactions\030\004 \003(\0132\014.Transaction\022\026\n\006trace" +
      "s\030\005 \003(\0132\006.Trace\022\016\n\006author\030\006 \001(\t\"\240\002\n\013Tran" +
      "saction\022\031\n\007receipt\030\001 \001(\0132\010.Receipt\022\017\n\007ch" +
      "ainId\030\002 \001(\004\022\026\n\006traces\030\003 \003(\0132\006.Trace\022\014\n\004f" +
      "rom\030\004 \001(\t\022\013\n\003gas\030\005 \001(\t\022\021\n\tgas_price\030\006 \001(" +
      "\t\022\014\n\004hash\030\007 \001(\t\022\r\n\005input\030\010 \001(\t\022\r\n\005nonce\030" +
      "\t \001(\t\022\022\n\npublic_key\030\n \001(\t\022\n\n\002to\030\013 \001(\t\022\r\n" +
      "\005index\030\014 \001(\t\022\021\n\tindex_raw\030\r \001(\t\022\r\n\005value",
      "\030\016 \001(\t\022\021\n\003srv\030\017 \001(\0132\004.SRV\022\017\n\007creates\030\020 \001" +
      "(\t\"&\n\003SRV\022\t\n\001s\030\001 \001(\t\022\t\n\001r\030\002 \001(\t\022\t\n\001v\030\003 \001" +
      "(\004\"+\n\007Receipt\022\020\n\010gas_used\030\001 \001(\t\022\016\n\006statu" +
      "s\030\002 \001(\t\"\337\002\n\005Trace\022\027\n\017subtraces_count\030\001 \001" +
      "(\t\022\025\n\rtrace_address\030\002 \003(\t\022\030\n\020transaction" +
      "_hash\030\003 \001(\t\022\034\n\024transaction_position\030\004 \001(" +
      "\t\022\014\n\004type\030\005 \001(\t\022\035\n\006action\030\006 \001(\0162\r.Trace." +
      "Action\022\023\n\004call\030\007 \001(\0132\005.Call\022\027\n\006create\030\010 " +
      "\001(\0132\007.Create\022\027\n\006reward\030\t \001(\0132\007.Reward\022\031\n" +
      "\007suicide\030\n \001(\0132\010.Suicide\022\027\n\006result\030\013 \001(\013",
      "2\007.Result\022\r\n\005error\030\014 \001(\t\"7\n\006Action\022\010\n\004CA" +
      "LL\020\000\022\n\n\006CREATE\020\001\022\n\n\006REWARD\020\002\022\013\n\007SUICIDE\020" +
      "\003\"5\n\006Reward\022\016\n\006author\030\001 \001(\t\022\r\n\005value\030\002 \001" +
      "(\t\022\014\n\004type\030\003 \001(\t\"Y\n\004Call\022\014\n\004type\030\001 \001(\t\022\014" +
      "\n\004from\030\002 \001(\t\022\013\n\003gas\030\003 \001(\t\022\r\n\005input\030\004 \001(\t" +
      "\022\n\n\002to\030\005 \001(\t\022\r\n\005value\030\006 \001(\t\"@\n\006Create\022\014\n" +
      "\004from\030\001 \001(\t\022\013\n\003gas\030\002 \001(\t\022\014\n\004init\030\003 \001(\t\022\r" +
      "\n\005value\030\004 \001(\t\"C\n\007Suicide\022\017\n\007address\030\001 \001(" +
      "\t\022\017\n\007balance\030\002 \001(\t\022\026\n\016refund_address\030\003 \001" +
      "(\t\"I\n\006Result\022\017\n\007address\030\001 \001(\t\022\014\n\004code\030\002 ",
      "\001(\t\022\020\n\010gas_used\030\003 \001(\t\022\016\n\006output\030\004 \001(\tB\nB" +
      "\010Messagesb\006proto3"
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
    internal_static_Block_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Block_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Block_descriptor,
        new java.lang.String[] { "Hash", "Number", "Timestamp", "Transactions", "Traces", "Author", });
    internal_static_Transaction_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Transaction_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Transaction_descriptor,
        new java.lang.String[] { "Receipt", "ChainId", "Traces", "From", "Gas", "GasPrice", "Hash", "Input", "Nonce", "PublicKey", "To", "Index", "IndexRaw", "Value", "Srv", "Creates", });
    internal_static_SRV_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_SRV_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SRV_descriptor,
        new java.lang.String[] { "S", "R", "V", });
    internal_static_Receipt_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Receipt_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Receipt_descriptor,
        new java.lang.String[] { "GasUsed", "Status", });
    internal_static_Trace_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Trace_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Trace_descriptor,
        new java.lang.String[] { "SubtracesCount", "TraceAddress", "TransactionHash", "TransactionPosition", "Type", "Action", "Call", "Create", "Reward", "Suicide", "Result", "Error", });
    internal_static_Reward_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Reward_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Reward_descriptor,
        new java.lang.String[] { "Author", "Value", "Type", });
    internal_static_Call_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Call_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Call_descriptor,
        new java.lang.String[] { "Type", "From", "Gas", "Input", "To", "Value", });
    internal_static_Create_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Create_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Create_descriptor,
        new java.lang.String[] { "From", "Gas", "Init", "Value", });
    internal_static_Suicide_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Suicide_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Suicide_descriptor,
        new java.lang.String[] { "Address", "Balance", "RefundAddress", });
    internal_static_Result_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Result_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Result_descriptor,
        new java.lang.String[] { "Address", "Code", "GasUsed", "Output", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
