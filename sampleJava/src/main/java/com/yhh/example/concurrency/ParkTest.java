package com.yhh.example.concurrency;

import java.util.concurrent.locks.LockSupport;


/**
 * @author happyfeet
 * @since Mar 19, 2020
 */
public class ParkTest {

    private static volatile boolean flag = true;

    public static void main(String[] args) {

        exampleOne();

//        exampleTwo();

//        exampleThree();

    }

    private static void exampleThree() {
        Thread thread = new Thread(() -> {

            System.out.println("before first park");
            LockSupport.park();
            System.out.println("after first park");
            LockSupport.park();
            System.out.println("after second park");
            System.out.println("isInterrupted is " + Thread.interrupted());
            System.out.println("isInterrupted is " + Thread.interrupted());
            LockSupport.park();
            System.out.println("after third park");
        });

        thread.start();

        sleep(200);

        thread.interrupt();
    }

    private static void exampleTwo() {
        Thread thread = new Thread(() -> {
            while (flag) {

            }

            System.out.println("before first park");
            LockSupport.park();
            System.out.println("after first park");
            LockSupport.park();
            System.out.println("after second park");

        });

        thread.start();

        LockSupport.unpark(thread);
        LockSupport.unpark(thread);

        flag = false;
    }

    public static void exampleOne() {
        Thread thread = new Thread(() -> {
            while (flag) {

            }

            System.out.println("before first park");
            LockSupport.park();
            System.out.println("after first park");
            LockSupport.park();
            System.out.println("after second park");

        });

        thread.start();

        flag = false;

        sleep(20);

        System.out.println("before unpark");
        LockSupport.unpark(thread);
    }

    /*
    output:
            before first park
            before unpark
            after first park
     */

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
