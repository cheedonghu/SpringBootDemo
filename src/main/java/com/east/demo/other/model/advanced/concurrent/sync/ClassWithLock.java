package com.east.demo.other.model.advanced.concurrent.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 *
 * @author: east
 * @date: 2023/12/3
 */

public class ClassWithLock {
    public void tryLockUsage() {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        try {
            if (reentrantLock.tryLock(30, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getId() + " Get Lock Successfully");
                System.out.println(Thread.currentThread().getId() + ": Waiting thread is " + reentrantLock.getQueueLength());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void lockUsage() {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        try {
            reentrantLock.lockInterruptibly();
            System.out.println(Thread.currentThread().getId() + " Get Lock Successfully");
            System.out.println(Thread.currentThread().getId() + ": Waiting thread is " + reentrantLock.getQueueLength());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + " Get Lock Failed");
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {

//        ClassWithLock classWithLock1 = new ClassWithLock();
//        ClassWithLock classWithLock2 = new ClassWithLock();
//        Thread thread1 = new Thread(classWithLock1::lockUsage);
//        Thread thread2 = new Thread(classWithLock1::lockUsage);
//        thread1.start();
//        thread2.start();

        ClassWithLock classWithLock1 = new ClassWithLock();
        ClassWithLock classWithLock2 = new ClassWithLock();
        Thread thread1 = new Thread(classWithLock1::tryLockUsage);
        Thread thread2 = new Thread(classWithLock1::tryLockUsage);
        thread1.start();
        thread2.start();
    }
}
