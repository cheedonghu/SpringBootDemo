package com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo;


/**
 * 下单落表的最基本信息
 * 账单信息
 * 其他信息自行继承本类实现
 *
 * @author: east
 * @date: 2023/11/25
 */
public class BaseSavedInfo {
    protected OrderInfo orderInfo; //这里实际应该是表数据，而不是bo，这里临时替代一下

    public BaseSavedInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "SavedInfo{" +
                "orderInfo=" + orderInfo +
                '}';
    }
}
