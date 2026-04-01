package com.east.demo.other.model.base;

/**
 * 实现了Comparable接口的类
 *
 * @author: east
 * @date: 2023/10/23
 */

public class TheClassImpComparable implements Comparable<TheClassImpComparable> {

    private Integer age;
    private String name;

    public TheClassImpComparable(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(TheClassImpComparable o) {
//        return this.getName().compareTo(o.getName());
//    }

    @Override
    public int compareTo(TheClassImpComparable o) {
        return this.getAge().compareTo(o.getAge());
    }

    @Override
    public String toString() {
        return "TheClassImpComparable{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
