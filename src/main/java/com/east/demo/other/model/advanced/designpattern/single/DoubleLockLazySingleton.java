package com.east.demo.other.model.advanced.designpattern.single;

/**
 * 双重校验拿锁获取单例
 *
 * @author: east
 * @date: 2023/12/3
 */

public class DoubleLockLazySingleton {

    /**
     * 使用 volatile 可以禁止 JVM 的指令重排，原因：
     * <p>
     * singleton=new DoubleLockLazySingleton();
     * 这段代码分为三步执行：
     * 1. 为DoubleLockLazySingleton对象分配内存空间
     * 2. 实例化DoubleLockLazySingleton对象
     * 3. 将singleton指向DoubleLockLazySingleton对象内存地址
     * <p>
     * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出现问题，
     * 但是在多线程环境下会导致一个线程获得还没有初始化的实例。
     */
    private static volatile DoubleLockLazySingleton singleton;

    private DoubleLockLazySingleton() {
    }

    public static DoubleLockLazySingleton getInstance() {
        if (singleton == null) {
            // 这里拿到锁并不保证singleton还未初始化
            synchronized (DoubleLockLazySingleton.class) {
                // 这里再次判断是因为有种特殊情况：拿到锁了，但是释放锁的是上一个已经初始化singleton的线程。
                if (singleton == null) {
                    singleton = new DoubleLockLazySingleton();
                }
            }
        }
        return singleton;
    }
}
