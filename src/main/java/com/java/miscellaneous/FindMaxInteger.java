package com.java.miscellaneous;

import java.util.Arrays;
import java.util.List;

public class FindMaxInteger {

    public int getMax(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();

        //return Arrays.stream(nums).mapToObj(x -> x).max(Integer::compareTo).get();

    }


    public int getMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).get();
    }


}

class TestFindMaxInetger {
    public static void main(String[] args) {

        int[] a = {1, 2, 4, 6, 7, 8};

        List<Integer> list = Arrays.stream(a).boxed().toList();
        FindMaxInteger findMaxInteger = new FindMaxInteger();
        System.out.println(findMaxInteger.getMax(a));
        System.out.println(findMaxInteger.getMax((list)));

    }
}
