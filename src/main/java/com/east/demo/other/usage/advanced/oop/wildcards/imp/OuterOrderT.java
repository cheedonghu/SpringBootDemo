package com.east.demo.other.usage.advanced.oop.wildcards.imp;

import com.east.demo.other.usage.advanced.oop.wildcards.imp.model.bo.OuterBaseSavedInfo;
import com.east.demo.other.usage.advanced.oop.wildcards.imp.model.req.OuterOrderRequest;
import com.east.demo.other.usage.advanced.oop.wildcards.imp.save.OuterSaveOrderImp;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.AbstractOrderT;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.SaveT;

import java.math.BigDecimal;

/**
 * 内部下单实现类
 *
 * @author: east
 * @date: 2023/11/24
 */
public class OuterOrderT extends AbstractOrderT<OuterOrderRequest> {
    protected SaveT<OuterBaseSavedInfo> save; // note 通配符如果不在模板指定，则只有在这里明确指定，save的方法才能正常调用

    public OuterOrderT(OuterSaveOrderImp save) {
        super(save);
        this.save = save;
    }

    @Override
    public void order(OuterOrderRequest outerOrderRequest) {
        try {

            // 校验等逻辑....

            // 落表
            // 通过父类调用  note: 这里没有通过模板指定（如果也不在成员函数指定的话则会报错，? extends通配只是占位，不指定类型则无法操作
            save.save(new OuterBaseSavedInfo(outerOrderRequest.generateOrderInfo()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OuterSaveOrderImp saveOrderAction = new OuterSaveOrderImp();
        OuterOrderT orderAction = new OuterOrderT(saveOrderAction);
        orderAction.order(new OuterOrderRequest(BigDecimal.ONE, "outSerialT", "rcvNo"));
    }

}

