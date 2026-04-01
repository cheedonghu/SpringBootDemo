package com.east.demo.other.model.advanced.designpattern.abstractfactory.implement;

import com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee.AbstractFactory;
import com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee.Phone;
import com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee.Router;

/**
 * 小米工厂
 *
 * @author: east
 * @date: 2024/3/22
 */
public class XMFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new XMPhone();
    }

    @Override
    public Router createRouter() {
        return new XMRouter();
    }
}
