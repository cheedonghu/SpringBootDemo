package com.east.demo.other.model.advanced.concurrent.async;

/**
 * 实现了Runnable 的多线程实现类
 *
 * @author: east
 * @date: 2023/10/24
 */

public class ClassImpRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ClassImpRunnable: Thread Id : " + Thread.currentThread().getId() + "times : " + i);
        }
    }
}
