package com.yhh.thinking.in.java.initialization;

public class Exercise1 {
    private String str;
    private String str2 = "str2";

    public Exercise1() {
        System.out.println(str);
    }

    public Exercise1(String str) {
        System.out.println(str2);
        System.out.println(this.str);
        this.str = str;
        System.out.println(this.str);
    }

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();//str is not initialized, it's null.

        Exercise1 exercise2 = new Exercise1("str1");
        //str2 在进入构造函数之前就已经初始化完成了，而str1是在构造函数初始化的
    }
}
