package com.arvon.summary.javademo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Arvon
 * @date 2021/3/30 10:26
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("....召唤神龙");
        });
        for (int i = 1; i <=7 ; i++) {
            int timInt=i;
            new Thread(()->{
                System.out.println("召唤第"+timInt+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
