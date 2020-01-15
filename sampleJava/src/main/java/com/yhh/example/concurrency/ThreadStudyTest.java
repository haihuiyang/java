package com.yhh.example.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author HappyFeet
 * @since Jan 04, 2020
 */

public class ThreadStudyTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadImp threadImp = new ThreadImp();
        Thread t = new Thread(threadImp);
        t.setName("Fred");
        t.start();

        Thread.sleep(1000);

        System.out.println("t.isAlive() is " + t.isAlive());

        Thread.sleep(1000);

        System.out.println("t.isAlive() is " + t.isAlive());

//        t.run();
//        threadImp.run();

//        Thread thread = new Thread();
//        thread.start();
//        thread.run();
//        System.out.println("thread.start()");

//        threadYieldTest();
    }

    private static void threadYieldTest() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i is " + i + " threadName is " + Thread.currentThread().getName());
            }
        }, "A");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i is " + i + " threadName is " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    Thread.yield();
                }
            }
        }, "B");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ThreadImp implements Runnable {
        @Override
        public void run() {
            System.out.println("Current Thread: " + Thread.currentThread());
        }
    }
}
