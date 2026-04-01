package com.east.demo.other.model.advanced.designpattern.factory.implement.manualcheck;

import com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck.ManualCheckFactoryInterface;
import com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck.ManualCheckInterface;

/**
 * 钱包核对工厂实现类
 *
 * @author: east
 * @date: 2023/10/26
 */

public class WalletCheckFactory implements ManualCheckFactoryInterface {
    @Override
    public ManualCheckInterface createManualCheck() {
        return new WalletManualCheck();
    }
}
