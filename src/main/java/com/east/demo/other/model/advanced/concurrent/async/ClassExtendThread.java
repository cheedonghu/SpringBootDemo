package com.east.demo.other.model.advanced.concurrent.async;

/**
 * 继承了Thread的多线程实现类
 *
 * @author: east
 * @date: 2023/10/24
 */

public class ClassExtendThread extends Thread {
    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("ClassExtendThread: Thread Id : " + Thread.currentThread().getId() + "times : " + i);
        }
    }
}
