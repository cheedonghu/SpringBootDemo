package com.east.demo.other.model.advanced.designpattern.abstractfactory.implement;

import com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee.AbstractFactory;
import com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee.Phone;
import com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee.Router;

/**
 * 华为工厂
 *
 * @author: east
 * @date: 2024/3/22
 */
public class HWFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new HWPhone();
    }

    @Override
    public Router createRouter() {
        return new HWRouter();
    }
}
