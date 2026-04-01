package com.east.demo.other.model.advanced.designpattern.publishandsubscribe;

/**
 * 订阅者
 *
 * @author: east
 * @date: 2023/10/26
 */

public class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void handleEvent(MyEvent myEvent) {
        System.out.println(this.name + " begin to handle event: " + myEvent.getEventMsg());
    }
}
