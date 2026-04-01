package com.east.demo.other.model.advanced.designpattern.publishandsubscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 发布者
 * 这里的注册和发布都可以再次抽象
 * 参考Spring：ApplicationEventMulticaster；ApplicationListenerRegistry类
 *
 * @author: east
 * @date: 2023/10/26
 */

public class Publisher {
    private List<Subscriber> subscriberList = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void publishEvent(MyEvent myEvent) {
        for (Subscriber subscriber : getSubscriberList()) {
            subscriber.handleEvent(myEvent);
        }
    }

    private List<Subscriber> getSubscriberList() {
        return subscriberList;
    }
}
