package com.yhh.example.concurrency;

import com.yhh.common.PrintUtils;

import java.util.concurrent.TimeUnit;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        PrintUtils.println(threadName);
        try {
            TimeUnit.SECONDS.sleep(1);
            PrintUtils.println("Sleep " + 1 + " second.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
