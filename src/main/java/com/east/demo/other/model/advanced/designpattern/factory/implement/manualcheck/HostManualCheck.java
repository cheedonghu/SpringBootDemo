package com.east.demo.other.model.advanced.designpattern.factory.implement.manualcheck;

import com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck.ManualCheckInterface;

/**
 * 流水对账
 *
 * @author: east
 * @date: 2023/10/23
 */

public class HostManualCheck implements ManualCheckInterface {
    @Override
    public void preCheck() {
        System.out.println("I will do host check pre check");
    }

    @Override
    public void doCheck() {
        System.out.println("I will do host check");
    }

    @Override
    public void doNotify() {
        System.out.println("I will notify other system after check");
    }

    @Override
    public void cancelCheck() {
        System.out.println("I will cancel this check");
    }

    public void doWholeCheck() {
        this.preCheck();
        this.doCheck();
        this.doNotify();
    }

}
