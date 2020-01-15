package com.yhh.example;

public class VolatileTest {

    private volatile int volatileCount = 0;
    private int count = 0;

    public static void main(String[] args) {

        VolatileTest volatileTest = new VolatileTest();

        volatileTest.increase();
        volatileTest.decrease();

    }

    private void decrease() {
        count--;
    }

    private void increase() {
        volatileCount++;
    }

}