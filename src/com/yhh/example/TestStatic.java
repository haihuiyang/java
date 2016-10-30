package com.yhh.example;

public class TestStatic {
    private static String staticField;
    private String instanceField;

    static {
        staticField = "this is my first blog.";
        System.out.println(staticField);
    }

    {
        System.out.println("instance has been created.");
    }

    public static void main(String[] args) {
        TestStatic obj1 = new TestStatic();
        TestStatic obj2 = new TestStatic();
        TestStatic obj3 = new TestStatic();

        Integer integer;

        
    }
}
