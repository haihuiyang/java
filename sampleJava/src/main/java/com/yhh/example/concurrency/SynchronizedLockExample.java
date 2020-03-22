package com.yhh.example.concurrency;

import static com.yhh.common.PrintUtils.println;

/**
 * @author happyfeet
 * @since Feb 03, 2020
 */
public class SynchronizedLockExample {

    private final Object lock = new Object();

    public static void main(String[] args) {

        SynchronizedLockExample lockExample = new SynchronizedLockExample();

        Thread thread1 = new Thread(() -> lockExample.synchronizedOnCodeBlock(), "thread-1");

        Thread thread2 = new Thread(() -> lockExample.synchronizedOnCodeBlock(), "thread-2");

        Thread thread3 = new Thread(() -> lockExample.synchronizedOnInstanceMethod(), "thread-3");

        Thread thread4 = new Thread(() -> lockExample.synchronizedOnInstanceMethod(), "thread-4");

        sleepOneSecond();
        thread1.start();
        sleepOneSecond();
        thread2.start();
        sleepOneSecond();
        thread3.start();
        sleepOneSecond();
        thread4.start();

        while (true) {

        }
    }

    private synchronized void synchronizedOnInstanceMethod() {
        println("I'm in synchronizedOnInstanceMethod, thread name is {}.", Thread.currentThread().getName());
        while (true) {
            // do something
        }
    }

    private void synchronizedOnCodeBlock() {
        synchronized (lock) {
            println("I'm in synchronizedOnCodeBlock, thread name is {}.", Thread.currentThread().getName());
            while (true) {
                // do something
            }
        }
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void method1() {
        // do something
    }

    private synchronized void method2() {
        // do something
    }

    private synchronized void method3() {
        // do something
    }
}
