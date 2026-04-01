package com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck;

/**
 * 手工核对工厂接口，
 * <p>
 * 后续有新的核对方式出现则其工厂类只需要实现此街口
 * <p>
 * 简单工厂，工厂，抽象工厂一个好的解释：https://www.cnblogs.com/jing99/p/12595494.html
 *
 * @author: east
 * @date: 2023/10/25
 */

public interface ManualCheckFactoryInterface {
    ManualCheckInterface createManualCheck();
}
