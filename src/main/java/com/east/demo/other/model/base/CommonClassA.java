package com.east.demo.other.model.base;

/**
 * @description:
 * @author: east
 * @date: 2023/10/22
 */

public class CommonClassA {
    private String string;

    public CommonClassA(String string) {
        this.string = string;
    }

    public CommonClassA() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static void commonFun() {
        for (int i = 0; i < 10; i++) {
            System.out.println("common function: Thread Id : " + Thread.currentThread().getId() + "times : " + i);
        }
    }
}
