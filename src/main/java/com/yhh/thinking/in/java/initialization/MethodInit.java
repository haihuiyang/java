package com.yhh.thinking.in.java.initialization;

public class MethodInit {
    private int i = f();

    int f() {
        return 11;
    }
}

class MethodInit2 {
    int i = f();
    int j = g(i);

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
}

class MethodInit3 {
    //    int j = g(i);//Illegal forward reference
    // 非法向前引用: 在一个变量定义前使用该变量
    int i = f();

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
}