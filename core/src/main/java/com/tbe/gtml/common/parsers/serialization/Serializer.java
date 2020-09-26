package com.tbe.gtml.common.parsers.serialization;

public interface Serializer<T> {
    byte[] toBytes(T object) throws SerDeException;
}
