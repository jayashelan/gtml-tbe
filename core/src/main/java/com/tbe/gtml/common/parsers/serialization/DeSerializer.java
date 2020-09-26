package com.tbe.gtml.common.parsers.serialization;

public interface DeSerializer<T> {
    T fromBytes(byte[] bytes) throws SerDeException;
}
