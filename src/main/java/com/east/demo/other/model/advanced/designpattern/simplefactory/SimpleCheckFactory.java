package com.east.demo.other.model.advanced.designpattern.simplefactory;

import com.east.demo.other.model.advanced.designpattern.factory.implement.manualcheck.HostManualCheck;
import com.east.demo.other.model.advanced.designpattern.factory.implement.manualcheck.WalletManualCheck;
import com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck.ManualCheckInterface;
import com.east.demo.other.model.special.exception.BaseException;

import java.util.Objects;

/**
 * 简单工程模式下的 对账工厂
 * <p>
 * 每次添加新的核对方式则需要修改当前工厂代码
 *
 * @author: east
 * @date: 2023/10/25
 */

public class SimpleCheckFactory {
    public static ManualCheckInterface createManualCheck(String checkType) {
        if (Objects.equals("HOST", checkType)) {
            return new HostManualCheck();
        } else if (Objects.equals("WALLET", checkType)) {
            return new WalletManualCheck();
        } else {
            throw new BaseException();
        }
    }
}
