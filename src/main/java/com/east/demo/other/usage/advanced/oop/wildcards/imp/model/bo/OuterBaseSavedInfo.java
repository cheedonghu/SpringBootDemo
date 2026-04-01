package com.east.demo.other.usage.advanced.oop.wildcards.imp.model.bo;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.BaseSavedInfo;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.OrderInfo;

/**
 * 外部下单落表类
 *
 * @author: east
 * @date: 2023/11/25
 */

public class OuterBaseSavedInfo extends BaseSavedInfo {
    public OuterBaseSavedInfo(OrderInfo orderInfo) {
        super(orderInfo);
    }
    // 外部渠道额外保存的表数据
}
