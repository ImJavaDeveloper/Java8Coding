package com.java.stream.exception;

@FunctionalInterface
public interface CheckedFunction<T, R> {
    R apply(T t) throws Exception;
}
