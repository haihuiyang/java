package com.yhh.example.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

public class RunnableImplTest {
    @Test
    public void testCall() throws Exception {
        RunnableImpl runnable = new RunnableImpl();
        runnable.run();
    }

    public static void main(String[] args) throws InterruptedException {
//        RunnableImpl runnable = new RunnableImpl();
//        runnable.run();

//        new MyThread().start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                3,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(32),
                new ThreadFactoryBuilder().setNameFormat("THREAD_POOL_EXECUTOR3-%d").build(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        ) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(t.getName());
                super.beforeExecute(t, r);
            }
        };

        Future<String> valueFuture = executor.submit(newCallable(1));
        Future<String> valueFuture1 = executor.submit(newCallable(2));
        Future<String> valueFuture2 = executor.submit(newCallable(3));
        Future<String> valueFuture3 = executor.submit(newCallable(4));

        try {
            String value = valueFuture.get();
            System.out.println(value);

            Future<String> valueFuture5 = executor.submit(newCallable(5));
            Future<String> valueFuture6 = executor.submit(newCallable(6));

            String value1 = valueFuture1.get();
            String value2 = valueFuture2.get();
            String value3 = valueFuture3.get();

            System.out.println(value1);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static Callable<String> newCallable(Integer index) {
        return () -> {
            TimeUnit.MINUTES.sleep(index
            );
            return index.toString();
        };
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("aaa");
        }
    }
}
