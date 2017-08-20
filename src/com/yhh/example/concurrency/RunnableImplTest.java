package com.yhh.example.concurrency;

import org.junit.Test;

public class RunnableImplTest {
    @Test
    public void testCall() throws Exception {
        RunnableImpl runnable = new RunnableImpl();
        runnable.run();
    }
}
