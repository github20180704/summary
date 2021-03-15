package com.arvon.summary.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Arvon
 * @date 2021/3/15 10:31
 */
public class ArrayListNotSafeDemo {
    //arraylist 并发修改异常   java.util.ConcurrentModificationException

    /**
     * 1.并发修改异常   java.util.ConcurrentModificationException
     * 2.解决办法
     * 2.1 new Vector<>();  加了同步锁
     * 2.2 Collections.synchronizedList(new ArrayList<>());
     * 2.3 new CopyOnWriteArrayList<>(); 写时复制  写的时候加锁  写完复制出来
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
