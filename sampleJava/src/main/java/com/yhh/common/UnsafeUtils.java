package com.yhh.common;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author HappyFeet
 * @since Dec 21, 2019
 */

public class UnsafeUtils {

    private static Unsafe unsafe;

    // 为了获取 field 的 offset
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
        }
    }

    private UnsafeUtils() {
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }

}
