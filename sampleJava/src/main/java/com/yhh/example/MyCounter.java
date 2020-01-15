package com.yhh.example;

import com.yhh.common.UnsafeUtils;
import sun.misc.Unsafe;

/**
 * @author HappyFeet
 * @since Dec 28, 2019
 */

public class MyCounter {

    private static final Unsafe unsafe = UnsafeUtils.getUnsafe();// 这个是自己写的一个 Utils，通过反射获取 unsafe 的实例
    private static final long countOffset;

    static {
        try {
            countOffset = unsafe.objectFieldOffset(MyCounter.class.getDeclaredField("count"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private volatile int count;

    public static void main(String[] args) {

        MyCounter unsafeCount = new MyCounter();
        MyCounter synchronizedCount = new MyCounter();
        MyCounter casCount = new MyCounter();

        unsafeCount(unsafeCount);
        synchronizedCount(synchronizedCount);
        casCount(casCount);

        while (Thread.activeCount() > 2) {// 注意 IntelliJ 以 run 模式跑需要指定为 2，debug 模式则指定为 1。
            Thread.yield();
        }
        unsafeCount.increment();

        System.out.println("unsafe count is : " + unsafeCount.getCount());
        System.out.println("synchronized count is : " + synchronizedCount.getCount());
        System.out.println("cas count is : " + casCount.getCount());
    }

    private static void unsafeCount(final MyCounter counter) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void synchronizedCount(final MyCounter counter) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.synchronizedIncrement();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.synchronizedIncrement();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void casCount(final MyCounter counter) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.casIncrement();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.casIncrement();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    public int increment() {
        return count++;
    }

    public synchronized int synchronizedIncrement() {
        return count++;
    }

    public int casIncrement() {
        int originCount;
        do {
            originCount = unsafe.getIntVolatile(this, countOffset);
        } while (!unsafe.compareAndSwapInt(this, countOffset, originCount, originCount + 1));

        return originCount + 1;
    }

    public int getCount() {
        return count;
    }

}
