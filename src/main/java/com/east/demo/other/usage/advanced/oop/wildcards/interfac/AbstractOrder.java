package com.east.demo.other.usage.advanced.oop.wildcards.interfac;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.req.OrderRequest;

/**
 * 模板方法所属的正常接口作为成员变量
 *
 * @author: east
 * @date: 2023/11/24
 */
public abstract class AbstractOrder<T extends OrderRequest<?>> {
    // Outer渠道，save使用模板类
    protected Save save;

    public AbstractOrder(Save save) {
        this.save = save;
    }

    /**
     * 下单
     */
    public abstract void order(T orderRequest);
}
