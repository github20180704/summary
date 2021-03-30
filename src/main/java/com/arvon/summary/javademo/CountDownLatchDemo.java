package com.arvon.summary.javademo;

import com.arvon.summary.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author Arvon
 * @date 2021/3/15 18:12
 * //等线程执行完 等待的线程才执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国:被灭");
                downLatch.countDown();
            }, CountryEnum.getForEachCountry(i).getMsg()).start();
        }
        //等待

        downLatch.await();
        System.out.println(Thread.currentThread().getName() + "----秦国统一六国");
    }
}
