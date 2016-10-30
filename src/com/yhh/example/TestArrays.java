package com.yhh.example;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yanghaihui on 10/24/16.
 */
public class TestArrays {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg");

        String[] str = (String[]) list.toArray();

        System.out.println(Arrays.binarySearch(str, "ddd"));//binarySearch

        String[] newStr = Arrays.copyOf(str, 4);//copyArray

        Arrays.stream(newStr).forEach(s -> System.out.print(s + " "));//stream

        System.out.println();

        Integer[] integers = {2, 4, 52, 6, 24, 72, 23, 22, 11};

        Arrays.sort(integers);//sort

        Arrays.stream(integers).forEach(i -> System.out.print(i + " "));

        System.out.println();

        Integer[] newIntegers = {2, 4, 52, 6, 24, 72, 23, 22, 11};

        Arrays.sort(newIntegers);

        if (Arrays.equals(integers, newIntegers)) {
            System.out.println("integers is equals newIntegers.");//equals
        }

        Character[] chars = {'a', 'b', 'c'};

        Arrays.fill(chars, 'd');//fill

        Arrays.stream(chars).forEach(c -> System.out.print(c + " "));

    }
}
