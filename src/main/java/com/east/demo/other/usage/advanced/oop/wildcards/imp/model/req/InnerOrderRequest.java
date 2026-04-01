package com.east.demo.other.usage.advanced.oop.wildcards.imp.model.req;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.OrderInfo;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.req.OrderRequest;

import java.math.BigDecimal;

/**
 * 内部渠道下单
 *
 * @author: east
 * @date: 2023/11/23
 */
public class InnerOrderRequest implements OrderRequest<OrderInfo> {
    protected BigDecimal amt;
    protected String serial;
    protected String rcvNo;

    public InnerOrderRequest(BigDecimal amt, String serial, String rcvNo) {
        this.amt = amt;
        this.serial = serial;
        this.rcvNo = rcvNo;
    }

    /**
     * 生成账单信息
     *
     * @return 账单信息
     */
    @Override
    public OrderInfo generateOrderInfo() {
        return new OrderInfo(amt, serial, rcvNo);
    }
}
