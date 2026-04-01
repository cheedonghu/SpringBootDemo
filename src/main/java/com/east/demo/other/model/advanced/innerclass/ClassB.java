package com.east.demo.other.model.advanced.innerclass;

/**
 * @author: east
 * @date: 2023/10/23
 */

public class ClassB extends ClassA {
    static {
        System.out.print("a");
    }

    public ClassB() {
        System.out.print("b");
    }
}
