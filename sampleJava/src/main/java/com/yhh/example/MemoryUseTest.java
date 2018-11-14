package com.yhh.example;

import com.javamex.classmexer.MemoryUtil;

/**
 * VM options: -XX:+UseCompressedOops
 */
public class MemoryUseTest {

    public static void main(String[] args) {

        System.out.println(MemoryUtil.memoryUsageOf(new ObjectUse1()));
        System.out.println(MemoryUtil.memoryUsageOf(new ObjectUse2()));
        System.out.println(MemoryUtil.memoryUsageOf(new ObjectUse3()));
        System.out.println(MemoryUtil.memoryUsageOf(new ObjectUse4()));
        System.out.println(MemoryUtil.memoryUsageOf(new ObjectUse5[10]));
    }

    static class ObjectUse1 {
        short a;
    }

    static class ObjectUse2 {
        int a;
    }

    static class ObjectUse3 {
        long a;
    }

    static class ObjectUse4 {
        Object a;
    }

    static class ObjectUse5 {
        long a;
    }

}