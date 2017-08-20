package com.yhh.example.concurrency;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.util.concurrent.*;

public class ConcurrencyTest {

    @Test
    public void testDifferentBetweenRunAndStartInThread() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            PrintUtils.println("CurrentThread name is " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.run();
        thread.start();

        /*
        result:
        CurrentThread name is main
        CurrentThread name is main
        CurrentThread name is Thread-0
         */

        /*
        Thread的run()方法和普通的方法调用一样，main线程按顺序调用run()顺序执行了它；
        Thread的start()方法新建了一个线程Thread-0来执行run()方法
         */
    }

    @Test
    public void testStartInThread() {
        Runnable runnable = getRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        /*
        result:
        Foo Thread-0
         */
    }

    @Test
    public void testJoinInThread() {
        Runnable runnable = getRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         /*
        result:
        Foo Thread-0
        Bar Thread-0
         */

        /*
        java的线程分为两种，一种是daemon线程，另一种是user线程，daemon线程随着main线程的结束
        而自动结束，而main线程会等待所有user线程结束之后再结束自己。

        Bar Thread-0没有打印出来，这是因为Thread.start()方法启动的是一个daemon线程，
        当main线程结束后，daemon线程自动结束，由于在main线程结束时，daemon线程由
        sleep状态直接结束，所以Bar Thread-0不会打印出来。

        如果想让main线程等待子线程完成之后再结束，只需要在main线程中join子线程就行了。
         */
    }

    private Runnable getRunnable() {
        return () -> {
            try {
                String name = Thread.currentThread().getName();
                PrintUtils.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                PrintUtils.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    @Test
    public void testConcurrencyWithTenThread() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            PrintUtils.println(threadName);
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(runnable);
        }

        /*
        result:
        pool-1-thread-4
        pool-1-thread-5
        pool-1-thread-2
        pool-1-thread-3
        pool-1-thread-1
        pool-1-thread-6
        pool-1-thread-7
        pool-1-thread-8
        pool-1-thread-9
        pool-1-thread-10

        pool-1-thread-1
        pool-1-thread-4
        pool-1-thread-6
        pool-1-thread-5
        pool-1-thread-3
        pool-1-thread-2
        pool-1-thread-7
        pool-1-thread-8
        pool-1-thread-9
        pool-1-thread-10
         */

        /*
        十个线程并发执行，每次执行的结果都不一样。
         */
    }

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Callable callableImpl = new CallableImpl();
            Future<String> future = executorService.submit(callableImpl);
            for (int j = 0; j < 10000; j++) {

            }
            PrintUtils.println(future.get());
        }

        /*
        result:
        pool-1-thread-1
        pool-1-thread-2
        pool-1-thread-3
        pool-1-thread-4
        pool-1-thread-5
        pool-1-thread-6
        pool-1-thread-7
        pool-1-thread-8
        pool-1-thread-9
        pool-1-thread-10
         */

        /*
        Future模式可以在连续流程中满足数据驱动的并发需求，既获得了并发执行的性能提升，又不失连续流程的简洁优雅。一个生动的比喻是：
        我有一个任务，提交给了Future，Future替我完成这个任务；期间我自己可以去做任何想做的事情；一段时间之后，我就便可以从Future那儿取出结果。
        结果始终是有序的，即按照执行的顺序输出。原因是，future.get()是以同步阻塞的方式得到future的结果的。
         */
    }
}
