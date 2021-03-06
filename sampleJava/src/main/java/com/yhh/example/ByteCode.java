package com.yhh.example;

/**
 * @author HappyFeet
 * @since Jan 14, 2020
 */

public class ByteCode {

    private String name;
    private int age;

    public ByteCode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean age(int add) {
        synchronized (this) {
            return age > 18;
        }
    }

    public static void main(String[] args) {
        final ByteCode code = new ByteCode("HappyFeet", 20);
        final boolean gt = code.age(10);
        System.out.println(gt);
    }
}
