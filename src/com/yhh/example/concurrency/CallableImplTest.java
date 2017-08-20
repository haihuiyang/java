package com.yhh.example.concurrency;

import com.yhh.common.PrintUtils;
import org.junit.Test;

public class CallableImplTest {

    @Test
    public void testCall() throws Exception {
        CallableImpl callable = new CallableImpl();
        String threadName = callable.call();
        PrintUtils.println("Done! threadName is " + threadName + ".");
    }
}
