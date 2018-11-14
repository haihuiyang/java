package com.yhh.example;

import com.google.common.collect.Lists;

import java.util.List;

public class TypeErasure {

//    public static Integer method(List<String> strs) {
//        strs.forEach(System.out::println);
//        return 1;
//    }

    public static Double method(List<Integer> ints) {
        ints.forEach(System.out::println);
        return 1.0;
    }

    public static void main(String[] args) {
//        method(Lists.newArrayList("sd"));
        method(Lists.newArrayList(2, 3));
    }
}
