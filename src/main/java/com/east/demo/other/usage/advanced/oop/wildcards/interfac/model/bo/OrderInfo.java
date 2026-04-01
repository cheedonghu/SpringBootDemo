package com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo;


import java.math.BigDecimal;

/**
 * 账单通用数据
 */
public class OrderInfo {
    protected BigDecimal amt;
    protected String serial;
    protected String rcvNo;

    public OrderInfo(BigDecimal amt, String serial, String rcvNo) {
        this.amt = amt;
        this.serial = serial;
        this.rcvNo = rcvNo;
    }

    public OrderInfo() {
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "amt=" + amt +
                ", serial='" + serial + '\'' +
                ", rcvNo='" + rcvNo + '\'' +
                '}';
    }
}