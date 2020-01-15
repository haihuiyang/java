package com.yhh.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author HappyFeet
 * @since Dec 28, 2019
 */

public class Counter {

    private volatile int count;
    private volatile AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        counter.increment();
        counter.atomicIncrement();

//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                counter.increment();
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                counter.increment();
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();

        System.out.println("count is " + counter.getCount());
    }

    public synchronized int increment() {
        return count++;
    }

    public int atomicIncrement() {
        return atomicCount.incrementAndGet();
    }

    public int getCount() {
        return count;
    }
}
