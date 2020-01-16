package com.yhh.example.concurrency;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.locks.LockSupport;

/**
 * @author happyfeet
 * @since Jan 15, 2020
 */
public class ThreadStateChangeTest {

    private static Object lock = new Object();

    private static Object waitAndNotify = new Object();

    public static void main(String[] args) {

        newState();

        runnableState();

        waitingState();

        timeWaitingState();

        blockedState();

        terminatedState();

        waitAndNotify();

        parkAndUnpark();

        LockSupport.park();// 友情提示：该程序需要手动 Stop. (Command + F2)
    }

    private static void parkAndUnpark() {

        Thread parkThread = new Thread(() -> {
            System.out.println("park.");
            LockSupport.park();
            System.out.println("unpark.");
        }, "parkThread");

        parkThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after sleep 1 second");

        LockSupport.unpark(parkThread);
    }

    private static void waitAndNotify() {

        Thread waitThread = new Thread(() -> {
            synchronized (waitAndNotify) {
                System.out.println("I'm wait thread.");
                try {
                    System.out.println("waiting...");
                    waitAndNotify.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("notified.");
            }
        }, "waitThread");

        Thread notifyThread = new Thread(() -> {
            synchronized (waitAndNotify) {
                System.out.println("I'm notified thread.");
                waitAndNotify.notify();
                System.out.println("notify wait thread.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after sleep 1 second.");
            }
        }, "notifyThread");

        waitThread.start();
        try {
            Thread.sleep(20);// 确保 waitThread 在 notifyThread 之前执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }

    private static void terminatedState() {
        Thread terminatedThread = new Thread("05-terminatedThread");
        terminatedThread.start();
        try {
            terminatedThread.join();// 等待 terminatedThread 执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(terminatedThread.getState());
    }

    private static void blockedState() {

        Thread holdLockThread = new Thread(() -> {
            synchronized (lock) {
                while (true) {

                }
            }
        }, "holdLockThread");

        holdLockThread.start();

        Thread blockedThread = new Thread(() -> {
            synchronized (lock) {
                while (true) {

                }
            }
        }, "04-blockedThread");

        blockedThread.start();

        System.out.println(blockedThread.getState());
    }

    private static void timeWaitingState() {
        Thread timeWaitingThread = new Thread(() -> {
            LockSupport.parkUntil(LocalDateTime.now().plusDays(1).toEpochSecond(ZoneOffset.of("+8")) * 1000);
        }, "03-timeWaitingThread");

        timeWaitingThread.start();

        System.out.println(timeWaitingThread.getState());
    }

    private static void waitingState() {
        Thread waitingThread = new Thread(() -> {
            LockSupport.park();
        }, "02-waitingThread");

        waitingThread.start();

        System.out.println(waitingThread.getState());
    }

    private static void runnableState() {
        Thread runnableThread = new Thread(() -> {
            while (true) {

            }
        }, "01-runnableThread");

        runnableThread.start();

        System.out.println(runnableThread.getState());
    }

    private static void newState() {
        Thread newThread = new Thread("00-newThread");
        System.out.println(newThread.getState());
    }

}
