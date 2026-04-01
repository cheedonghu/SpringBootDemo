package com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.req;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.OrderInfo;

/**
 * 下单报文接口
 *
 * @author: east
 * @date: 2023/11/23
 */
public interface OrderRequest<T extends OrderInfo> {
    /**
     * 将不同渠道报文转为T的统一格式数据（比如转为落表所需数据）
     *
     * @return T 统一数据
     */
    public T generateOrderInfo();
}
