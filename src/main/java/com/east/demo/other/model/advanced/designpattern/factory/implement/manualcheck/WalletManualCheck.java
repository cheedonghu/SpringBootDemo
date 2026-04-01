package com.east.demo.other.model.advanced.designpattern.factory.implement.manualcheck;

import com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck.ManualCheckInterface;

/**
 * 钱包对账
 *
 * @author: east
 * @date: 2023/10/23
 */

public class WalletManualCheck implements ManualCheckInterface {
    @Override
    public void preCheck() {
        System.out.println("I will do wallet check pre check");
    }

    @Override
    public void doCheck() {
        System.out.println("I will do wallet check");
    }

    @Override
    public void doNotify() {
        System.out.println("I will notify other system after check");
    }

    @Override
    public void cancelCheck() {
        System.out.println("sorry this check type reject cancel operation");
    }

    public void doWholeCheck() {
        preCheck();
        doCheck();
        doNotify();
    }
}
