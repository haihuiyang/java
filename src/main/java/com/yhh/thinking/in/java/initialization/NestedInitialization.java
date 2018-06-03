package com.yhh.thinking.in.java.initialization;

public class NestedInitialization {

    public static void main(String[] args) {
        staticFunction();
        /*
        output:
            2
            3
            a=110,b=0
            1
            4
         */
    }

    static NestedInitialization st = new NestedInitialization();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    NestedInitialization() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;

}
