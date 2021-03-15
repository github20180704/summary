package com.arvon.summary.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arvon
 * @date 2021/3/1 14:28
 * CAS 比较并交换   compareAndSet
 */
public class CasDemo {
    public static void main(String[] args) {
        //保证原子性
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2021) + "值为:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2023) + "值为:" + atomicInteger.get());
    }
}
