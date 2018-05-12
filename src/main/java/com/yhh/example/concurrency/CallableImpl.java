package com.yhh.example.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableImpl implements Callable {

    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        TimeUnit.SECONDS.sleep(1);
        return threadName;
    }
}
