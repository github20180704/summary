package com.arvon.summary.javademo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arvon
 * @date 2021/3/15 17:23
 */
public class LockDemo {
    public static void main(String[] args) {
        //默认非公平锁 false true公平锁(按顺序 来抢占锁)
        Lock   lock=new ReentrantLock(true);
    }
}
