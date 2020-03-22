package com.yhh.example;

/**
 * VM options: -XX:+UseCompressedOops
 *
 *  -javaagent:classmexerDirAbsolutePath/classmexer-0.03.jar
 */
public class MemoryUseTest {

    public static void main(String[] args) {


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