package com.yhh.example.concurrency;

/**
 * @author happyfeet
 * @since Jan 19, 2020
 */
public class SynchronizedUsageExample {

    private static int staticCount;
    private final Object lock = new Object();
    private int count;

    public static synchronized int synchronizedOnStaticMethod() {
        return staticCount++;
    }

    public synchronized void synchronizedOnInstanceMethod() {
        count++;
    }

    public int synchronizedOnCodeBlock() {
        synchronized (lock) {
            return count++;
        }
    }
}
