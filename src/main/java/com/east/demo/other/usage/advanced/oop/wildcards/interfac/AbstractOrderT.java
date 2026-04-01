package com.east.demo.other.usage.advanced.oop.wildcards.interfac;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.BaseSavedInfo;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.req.OrderRequest;

/**
 * 模板类接口作为成员变量，未通过模板指定接口类型
 *
 * @author: east
 * @date: 2023/11/24
 */
public abstract class AbstractOrderT<T extends OrderRequest<?>> {

    // 不通过模板指定，仅用通配符参数限定，
    protected SaveT<? extends BaseSavedInfo> save; // note 如果实现类中不指定SaveT的类型，则save接口无法使用
    // 原因： 编译器没那么聪明根据子类传入的saveT子对象推断出SaveT模板具体对应哪一个类，只能在这里明确指定或者子类重写

    public AbstractOrderT(SaveT<? extends BaseSavedInfo> save) {
        this.save = save;
    }


    /**
     * 下单
     */
    public abstract void order(T orderRequest);
}
