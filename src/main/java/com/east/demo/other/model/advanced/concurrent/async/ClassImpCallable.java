package com.east.demo.other.model.advanced.concurrent.async;

import java.util.concurrent.Callable;

/**
 * 实现Callable接口的多线程实现类
 *
 * @author: east
 * @date: 2023/10/24
 */

public class ClassImpCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("ClassImpCallable: Thread Id : " + Thread.currentThread().getId() + "times : " + i);
        }
        return "ClassImpCallable";
    }
}
