package com.yhh.example.concurrency;

import com.yhh.common.UnsafeUtils;
import sun.misc.Unsafe;

/**
 * @author HappyFeet
 * @since Dec 21, 2019
 */

public class CasTest {

    private static final Unsafe unsafe = UnsafeUtils.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (CasTest.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private int value;

    public CasTest(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws InterruptedException {

        CasTest casTest = new CasTest(0);

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("value is : " + casTest.getValue());
                }

            }
        });
        thread3.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    casTest.getAndIncrement();
                }

            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    casTest.getAndIncrement();
                }

            }
        });
        thread2.start();

        thread2.join();
        thread1.join();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    casTest.getAndIncrement();
                }

            }
        });
        thread4.start();

        thread4.join();

        thread3.stop();

        System.out.println(casTest.getValue());

    }

    public int getValue() {
        return value;
    }

    public final int getAndIncrement() {
//        return value++;

        int pre;
        do {
            pre = unsafe.getInt(this, valueOffset);
        } while (!unsafe.compareAndSwapInt(this, valueOffset, pre, pre + 1));

        return pre;

//        return unsafe.getAndAddInt(this, valueOffset, 1);
    }

}
