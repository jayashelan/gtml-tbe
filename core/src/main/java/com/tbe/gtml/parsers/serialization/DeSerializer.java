package com.tbe.gtml.parsers.serialization;

public interface DeSerializer<T> {
    T fromBytes(byte[] bytes) throws SerDeException;
}
