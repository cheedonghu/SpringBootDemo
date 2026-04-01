package com.east.demo.other.model.advanced.designpattern.factory.interfaceinfo.manualcheck;

/**
 * 对账接口:不管何种对账方式都要实现这三个步骤：
 * 1.先与检查，然后进行2.核对操作（改表数据） 3.通知下游系统
 * <p>
 * 后续新增核对方式只需要实现此接口即可
 *
 * @author: east
 * @date: 2023/10/23
 */

public interface ManualCheckInterface {
    public void preCheck();

    public void doCheck();

    public void doNotify();

    public void cancelCheck();
}
