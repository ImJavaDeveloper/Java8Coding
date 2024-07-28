package com.java.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindSumOfList {

    public static int getSum(List<Integer> list) {
        return list.stream().collect(Collectors.summingInt(Integer::intValue));
        //long val=list.stream().mapToLong(Integer::longValue).sum();
    }

    public static long getSumLong(List<Integer> list) {
        return list.stream().mapToLong(Integer::longValue).sum();
    }
}

class TestFindSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 6, 23, 4, 9);
        System.out.println(FindSumOfList.getSum(list));
        System.out.println(FindSumOfList.getSumLong(list));
    }
}
