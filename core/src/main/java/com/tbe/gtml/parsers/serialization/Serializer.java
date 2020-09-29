package com.tbe.gtml.parsers.serialization;

public interface Serializer<T> {
    byte[] toBytes(T object) throws SerDeException;
}
