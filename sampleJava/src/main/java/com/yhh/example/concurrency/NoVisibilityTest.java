package com.yhh.example.concurrency;

import com.yhh.common.PrintUtils;

import java.util.stream.IntStream;

public class NoVisibilityTest {

    private static boolean ready = false;
    private static int number = 0;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            PrintUtils.println(number);
        }
    }

    public static void main(String[] ages) {
        IntStream.range(1, 10).forEach(i -> new ReaderThread().start());
//        new ReaderThread().start();
        IntStream.range(1, 1000).forEach(i -> i = 0);
        number = 42;
        ready = true;
    }
}
