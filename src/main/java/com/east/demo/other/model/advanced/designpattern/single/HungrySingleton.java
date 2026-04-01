package com.east.demo.other.model.advanced.designpattern.single;

/**
 * 单例-饿汉
 * <p>
 * 关键点：1.构造方法private  2. 实例获取方法static 3.一开始便初始化实例
 * <p>
 * 一开始便将唯一实例初始化好，后续需要直接返回
 *
 * @author: east
 * @date: 2023/10/26
 */

public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    // 获取实例需要是静态方法，因为在这之前无法拿到对象
    public static HungrySingleton getInstance() {
        return instance;
    }

    public void function() {
        System.out.println("this is HungrySingleton's function");
    }
}
