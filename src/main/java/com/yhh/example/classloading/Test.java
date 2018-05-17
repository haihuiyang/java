package com.yhh.example.classloading;

public class Test {

    static {
        i = 0;//静态语句块可以给后面定义的类变量赋值，但是不能访问（编译器会报"非法向前引用"）
        //System.out.println(i); Illegal forward reference.
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println(Test.i);
    }

}
