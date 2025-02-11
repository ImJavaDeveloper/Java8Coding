package com.java.stream.exception;

import java.util.LinkedHashMap;

@FunctionalInterface
public interface CheckedFunction<T, R> {
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    R apply(T t) throws Exception;
}

