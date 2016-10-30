package com.yhh.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanghaihui on 10/22/16.
 */
public class TestArrayList {

    private static List<String> list = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc"));

    public static void main(String[] args) {

        TestArrayList example = new TestArrayList();

//        example.testArrayAsList();

        example.testAdd();
        Stack stack = new Stack();
    }

    public void testArrayAsList() {
        Object[] array = new Object[10];

        List<Object> arrayList = new ArrayList<>(Arrays.asList(array));

        arrayList.stream().forEach(a -> System.out.println(a));

        List<Object> arrayList1 = Arrays.asList(array);

        arrayList1.add("2");
        //通过Arrays.asList(array);方式转换的list的size固定了，不支持增删操作，会报java.lang.UnsupportedOperationException
    }

    public void testAdd() {

        list.add("ddd");

        list.stream().forEach(s -> System.out.println(s));

    }

}
