package com.yhh.common;

import java.time.LocalDateTime;

public class PrintUtils {

    public static void println(String string) {
        System.out.println(string);
    }

    public static void println(String format, Object... args) {
        String newFormat = format.replaceAll("\\{\\}", "%s");
        System.out.println(LocalDateTime.now() + " thread " + Thread.currentThread().getName() + " : " + String.format(newFormat, args));
    }

    public static void println(Integer integer) {
        System.out.println(integer);
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
