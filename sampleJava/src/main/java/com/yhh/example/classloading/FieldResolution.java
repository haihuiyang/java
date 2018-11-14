package com.yhh.example.classloading;

public class FieldResolution {

    interface InterFace0 {
        int A = 0;
    }

    interface Interface1 extends InterFace0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
        /*如果把Sub中的`public static int A = 4;`注释，编译器则会报
            Error:(26, 31) java: reference to A is ambiguous
            both variable A in com.yhh.example.classloading.FieldResolution.Parent and variable A in com.yhh.example.classloading.FieldResolution.Interface2 match
        */
    }

}
