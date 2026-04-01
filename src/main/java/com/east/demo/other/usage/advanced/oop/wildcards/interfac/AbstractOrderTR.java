package com.east.demo.other.usage.advanced.oop.wildcards.interfac;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.BaseSavedInfo;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.req.OrderRequest;

/**
 * 模板类接口作为成员变量，通过模板指定接口类型
 *
 * @author: east
 * @date: 2023/11/24
 */
public abstract class AbstractOrderTR<T extends OrderRequest<?>, R extends BaseSavedInfo> {
    // 用模板指定了参数的类型
    protected SaveT<R> save;

    public AbstractOrderTR(SaveT<R> save) {
        this.save = save;
    }


    /**
     * 下单
     */
    public abstract void order(T orderRequest);
}
