package com.east.demo.other.model.advanced.designpattern.publishandsubscribe;

/**
 * 特定事件
 *
 * @author: east
 * @date: 2023/10/26
 */

public class MyEvent {
    private String eventMsg;

    public MyEvent(String eventMsg) {
        this.eventMsg = eventMsg;
    }

    public String getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }
}
