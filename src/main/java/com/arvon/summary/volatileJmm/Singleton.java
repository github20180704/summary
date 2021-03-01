package com.arvon.summary.volatileJmm;

/**
 * @author Arvon
 * @date 2021/2/28 15:55
 * 1.构造器私有化
 * 2.私有静态成员变量
 */
public class Singleton {
    //禁止指令重排
    private static volatile Singleton instance = null;

    private Singleton() {
        System.out.println(Thread.currentThread().getName() + "创建一个实例:Singleton");
    }

    public static Singleton getInstance() {
        //DCL 双端检锁模式
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程下单例模式
//        singleThread();
        //多线程下单例模式
        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                Singleton.getInstance();
            }, String.valueOf(i)).start();
        }
    }

    private static void singleThread() {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }
}
