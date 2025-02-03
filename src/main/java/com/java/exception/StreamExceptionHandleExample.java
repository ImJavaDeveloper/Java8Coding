package com.java.exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class StreamExceptionHandleExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1234", "23x", "98");
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        //Approach 1
        list.forEach(x -> {
                    try {
                        System.out.println(Integer.parseInt(x));
                    } catch (Exception ex) {
                        System.out.println("Exception Occurred:" + ex.getMessage());
                    }
                }
        );

        //Approach 2
        list.forEach(StreamExceptionHandleExample::handleException);

        //Approach 3
        list.forEach(handleException(x -> System.out.println(Integer.parseInt(x))));

        //Approach 4
        list1.forEach(handleExceptionConsumer(x -> System.out.println(Integer.parseInt(String.valueOf(x)))));

    }

    static void handleException(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception e) {
            System.out.println("Exception Occurred:" + e.getMessage());
        }
    }

    static Consumer<String> handleException(Consumer<String> handler) {
        return r -> {
            try {
                handler.accept(r);
            } catch (Exception e) {
                System.out.println("Exception Occurred:" + e.getMessage());
            }
        };
    }

    static <T> Consumer<T> handleExceptionConsumer(Consumer<T> handler) {
        return r -> {
            try {
                handler.accept(r);
            } catch (Exception e) {
                System.out.println("Exception Occurred:" + e.getMessage());
            }
        };
    }

    static <T> Consumer<T> handleCheckedException(Consumer<T> handler) {
        return r -> {
            try {
                handler.accept(r);
            } catch (Exception e) {
                System.out.println("Exception Occurred:" + e.getMessage());
            }
        };
    }

    public static <T, R> Function<T, R> wrap(CheckedFunction<T, R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}

