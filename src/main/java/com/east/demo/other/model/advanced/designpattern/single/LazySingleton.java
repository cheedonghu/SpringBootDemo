package com.east.demo.other.model.advanced.designpattern.single;

/**
 * 单例-懒汉
 * <p>
 * 关键点：1.构造方法private 2.获取实例static 3.获取实例时初始化对象
 *
 * @author: east
 * @date: 2023/10/26
 */

public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void function() {
        System.out.println("this is LazySingleton's function");
    }
}
