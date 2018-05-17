package com.yhh.thinking.in.java.initialization;

public class Finalize {

    @Override
    protected void finalize() {
        System.out.println("finalize occur.");
    }

    public static void main(String[] args) {
        Finalize finalize = new Finalize();

        System.gc();
        System.out.println("first gc().");

        finalize = null;

        System.gc();
        System.out.println("second gc().");

        //当调用gc的时候，如果一个对象没有任何引用，则会被清理，会调用finalize方法
    }

}
