package com.tbe.gtml.commons.util;

import java.util.Collection;

public class LambdaUtils {

     public static <T> java.util.stream.Stream<T> collectionAsStream(Collection<T> collection){
        return collection.stream().flatMap(s -> java.util.stream.Stream.ofNullable(s));
    }

}
