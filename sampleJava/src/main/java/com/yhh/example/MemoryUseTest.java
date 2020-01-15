package com.yhh.example;

import com.javamex.classmexer.MemoryUtil;
import com.yhh.common.UnsafeUtils;

import java.lang.reflect.Field;

/**
 * VM options: -XX:+UseCompressedOops
 *
 *  -javaagent:classmexerDirAbsolutePath/classmexer-0.03.jar
 */
public class MemoryUseTest {

    public static void main(String[] args) {

        MemoryUse obj = new MemoryUse();
        System.out.println("obj shallow size is : " + MemoryUtil.memoryUsageOf(obj));
        System.out.println("obj deep size is : " + MemoryUtil.deepMemoryUsageOf(obj) + "\n");

        System.out.println("obj offset is : ");
        for (Field field : obj.getClass().getDeclaredFields()) {
            System.out.println("\t offset : " + UnsafeUtils.getUnsafe().objectFieldOffset(field) + ", field name : " + field.getName());
        }

    }

    static class MemoryUse {
        long long0;
        int int0;
        long long1;
        byte byte0;
        short short0;
        String str0 = "hello world";
    }
}