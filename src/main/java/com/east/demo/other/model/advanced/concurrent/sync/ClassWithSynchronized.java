package com.east.demo.other.model.advanced.concurrent.sync;

/**
 * 有synchronized修饰的方法
 *
 * @author: east
 * @date: 2023/10/24
 */

public class ClassWithSynchronized {
    public synchronized void funcA() {
        System.out.println("thread: " + Thread.currentThread().getId() + " do sth in synchronized funA");
        try {
            Thread.sleep(4000);
            System.out.println("thread: " + Thread.currentThread().getId() + " end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void funcB() {
        synchronized (this) {
            System.out.println("thread: " + Thread.currentThread().getId() + " do sth in synchronized funB");
            try {
                Thread.sleep(4000);
                System.out.println("thread: " + Thread.currentThread().getId() + " end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
