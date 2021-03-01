package com.arvon.summary.volatileJmm;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author Arvon
 * @date 2021/2/28 12:20
 */
class MyData {
    volatile int number = 0;

    void addNumber() {
        this.number = 60;
    }

    void addNumberPlus() {
        this.number++;
    }
}

public class VolatileTest {
    public static void main(String[] args) {
        MyData myData=new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j <=1000; j++) {
                   myData.addNumberPlus();
                }
            }, String.valueOf(i)).start();
        }
        if(Thread.activeCount()>2){
          Thread.yield();
        }
        System.out.println("mydate=:"+myData.number);
    }

    //保证可见性
    private static void seeOkVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myData.addNumber();
            System.out.println(Thread.currentThread().getName() + ":update number to:" + myData.number);
        }, "AAA").start();
        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + ":mydate=:" + myData.number);
    }
}
