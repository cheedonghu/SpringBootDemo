package com.east.demo.other.model.advanced.designpattern.abstractfactory.interfacee;

/**
 * 抽象工厂
 * <p>
 * 路由器-小米，华为
 * 手机-小米，华为
 *
 * @author: east
 * @date: 2024/2/26
 */
public interface AbstractFactory {
    public Phone createPhone();

    public Router createRouter();
}
