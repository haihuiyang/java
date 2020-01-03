package com.yhh.example.concurrency;

import com.yhh.common.UnsafeUtils;
import sun.misc.Unsafe;

import static com.yhh.common.PrintUtils.println;

/**
 * @author HappyFeet
 * @since Jan 02, 2020
 */

public class CasABAProblem {

    private static final Unsafe unsafe = UnsafeUtils.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (CasABAProblem.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int value = 0;

    /*
    执行程序，结果如下：
        2020-01-02T22:57:48.565 thread thread2 : sleep 200 millis
        2020-01-02T22:57:48.565 thread thread1 : value is 0, and sleep 1000 millis.
        2020-01-02T22:57:48.566 thread thread3 : cas is true, value from 0 to 100 after CAS.
        2020-01-02T22:57:48.783 thread thread2 : cas is true, value from 100 to 0 after CAS.
        2020-01-02T22:57:49.585 thread thread1 : cas is true, value from 0 to 50 after CAS.
     */

    public static void main(String[] args) throws InterruptedException {

        CasABAProblem abaProblem = new CasABAProblem();

        Thread thread1 = new Thread(() -> {
            int millis = 1000;
            int value = abaProblem.getValue();
            println("value is {}, and sleep {} millis.", value, millis);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                // do nothing
            }
            boolean cas = unsafe.compareAndSwapInt(abaProblem, valueOffset, value, value + 50);
            println("cas is {}, value from {} to {} after CAS.", cas, value, abaProblem.getValue());
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            int millis = 200;
            println("sleep {} millis", millis);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                // do nothing
            }

            int value = abaProblem.getValue();
            boolean cas = unsafe.compareAndSwapInt(abaProblem, valueOffset, value, value - 100);
            println("cas is {}, value from {} to {} after CAS.", cas, value, abaProblem.getValue());
        }, "thread2");

        Thread thread3 = new Thread(() -> {
            int value = abaProblem.getValue();
            boolean cas = unsafe.compareAndSwapInt(abaProblem, valueOffset, value, value + 100);
            println("cas is {}, value from {} to {} after CAS.", cas, value, abaProblem.getValue());
        }, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();

    }

    public int getValue() {
        return value;
    }
}
