package com.java.miscellaneous;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FindDuplicateChars {

    public char[] getDuplicateChars(String input) {
        String inp = input.replace(" ", "");

        //Using Java8
        List<Character> list = inp.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() != 1)
                .map(Map.Entry::getKey)
                .toList();
        int i = 0;
        char[] chars = new char[list.size()];
        for (Character c : list)
            chars[i++] = c;

        return chars;

    }

    public String getDuplicateCharToString(String input) {
        String inp = input.replace(" ", "");

        //Using Java8
        return inp.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() != 1)
                .map(Map.Entry::getKey)
                .map(x -> String.valueOf(x.charValue()))
                .collect(Collectors.joining(","));


    }
}

class Main {

    public static void main(String[] args) {
        FindDuplicateChars findDuplicateChars = new FindDuplicateChars();
        String test = " I am not Java Programmer";

        System.out.println(findDuplicateChars.getDuplicateChars(test));
        System.out.println(findDuplicateChars.getDuplicateCharToString(test));

    }
}
