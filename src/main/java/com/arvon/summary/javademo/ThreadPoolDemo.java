package com.arvon.summary.javademo;

import java.util.concurrent.*;

/**
 * @author Arvon
 * @date 2021/4/7 12:53
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
