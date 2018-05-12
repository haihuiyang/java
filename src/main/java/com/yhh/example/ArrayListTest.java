package com.yhh.example;

import com.google.common.collect.Lists;
import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    @Test
    public void testArraysAsList() {
        List<String> notFixedList = Lists.newArrayList(Arrays.asList("aaa", "bbb", "ccc"));

        notFixedList.add(null);
        notFixedList.add("ddd");
        notFixedList.forEach(System.out::println);

        List<String> fixedList = Arrays.asList("aaa", "bbb", "ccc");
        fixedList.add("ddd");
        /*
        result:
            aaa
            bbb
            ccc
            null
            ddd

            java.lang.UnsupportedOperationException
                at java.util.AbstractList.add(AbstractList.java:148)
                at java.util.AbstractList.add(AbstractList.java:108)
                at com.yhh.example.TestArrayList1.testArraysAsList(TestArrayList1.java:44)
         */

        /*
        直接使用Arrays.asList("aaa", "bbb", "ccc")得到的List的size是固定的，不能对其做add和remove操作（会抛出java.lang.UnsupportedOperationException异常）。
        其根本原因是Arrays.asList()调用的是Arrays里面的一个内部类，不是java.util.ArrayList，这个内部类是不能进行add和remove操作的。
        如果相对返回的list做增删操作，正确的做法是Lists.newArrayList(Arrays.asList("aaa", "bbb", "ccc"));
         */
    }

    @Test
    public void testListInitial() {
        List<String> stringList = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
            add("d");
        }};
        stringList.forEach(PrintUtils::println);
        /*
        result:
            a
            b
            c
            d
         */
    }

    @Test
    public void testAddNull() {
        List<String> testList = new ArrayList<String>() {{
            add("aa");
            add("bb");
            add("cc");
        }};

        testList.add(null);
        testList.forEach(PrintUtils::println);

        /*
        result:
            aa
            bb
            cc
            null
         */
    }
}
