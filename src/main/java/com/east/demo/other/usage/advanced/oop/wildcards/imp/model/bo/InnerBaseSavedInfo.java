package com.east.demo.other.usage.advanced.oop.wildcards.imp.model.bo;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.BaseSavedInfo;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.OrderInfo;

/**
 * 下单落表信息
 * 账单信息
 * 其他信息自行继承本类实现
 *
 * @author: east
 * @date: 2023/11/25
 */
public class InnerBaseSavedInfo extends BaseSavedInfo {
    protected String specialMsg;


    public InnerBaseSavedInfo(OrderInfo orderInfo, String specialMsg) {
        super(orderInfo);
        this.specialMsg = specialMsg;
    }

    public String getSpecialMsg() {
        return specialMsg;
    }

    @Override
    public String toString() {
        return "InnerSavedInfo{" +
                "specialMsg='" + specialMsg + '\'' +
                ", orderInfo=" + orderInfo +
                '}';
    }
}
