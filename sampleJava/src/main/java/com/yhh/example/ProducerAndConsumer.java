package com.yhh.example;

import java.util.ArrayList;
import java.util.List;

import static com.yhh.common.PrintUtils.println;

/**
 * @author happyfeet
 * @since Mar 14, 2020
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();
        Object lock = new Object();

        Consumer consumer = new Consumer(lock, data);
        Producer producer = new Producer(lock, data);

        Thread consumerThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.consumer();
            }
        }, "consumer-1");
        Thread consumerThread2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.consumer();
            }
        }, "consumer-2");
        Thread consumerThread3 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.consumer();
            }
        }, "consumer-3");
        Thread producerThread = new Thread(() -> {
            int i = 1;
            while (i > 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producer.producer(i++);
            }
        }, "producer");

        consumerThread.start();
        consumerThread2.start();
        consumerThread3.start();
        producerThread.start();

        while (true) {

        }
    }

    private static class Consumer {
        private final Object lock;
        private List<Integer> dataList;

        private Consumer(Object lock,
                         List<Integer> dataList) {
            this.lock = lock;
            this.dataList = dataList;
        }

        public void consumer() {
            synchronized (lock) {
                while (dataList.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                println("data is {}.", dataList.remove(0));
                lock.notify();
            }
        }
    }

    private static class Producer {
        private final Object lock;
        private List<Integer> dataList;

        private Producer(Object lock,
                         List<Integer> dataList) {
            this.lock = lock;
            this.dataList = dataList;
        }

        public void producer(int i) {
            synchronized (lock) {
                while (dataList.size() == 20) {
                    try {
                        println("data size is {}, need wait", 20);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                println("offer data is {}.", i);
                dataList.add(i);
                lock.notify();
            }
        }
    }
}
