package com.east.demo.other.model.advanced.serializable;

import java.io.Serializable;

/**
 * 实现Serializable接口的类
 *
 * @author: east
 * @date: 2023/10/24
 */

public class ClassWithSerializable implements Serializable {
    private static final long serialVersionUID = 10001L;

    private String name;
    private String age;

    public ClassWithSerializable(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
