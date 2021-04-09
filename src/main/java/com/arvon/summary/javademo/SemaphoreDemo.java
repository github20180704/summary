package com.arvon.summary.javademo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Arvon
 * @date 2021/3/30 10:39
 * Semaphore 抢占释放  (抢占车位)
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//模拟三个车位
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//抢占
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"停车三秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }
            },String.valueOf(i)).start();
        }
    }


}
