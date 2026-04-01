package com.east.demo.other.usage.advanced.oop.wildcards.imp.save;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.Save;
import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.BaseSavedInfo;

/**
 * 内部渠道保存账单
 * Save接口的实现类
 *
 * @author: east
 * @date: 2023/11/24
 */
public class InnerSaveOrder implements Save {

    /**
     * 保存下单数据
     *
     * @param savedInfo 相关信息:账单表，统计表
     */
    @Override
    public <T extends BaseSavedInfo> void save(T savedInfo) {

        // 落表
        System.out.println("内部渠道下单信息开始落表");
        //        InnerSavedInfo innerSavedInfo=(InnerSavedInfo) savedInfo;
//        System.out.println("内部渠道特有数据获取: "+innerSavedInfo.getSpecialMsg());
        // todo 这里有个很大的问题就是如果不通过强制类型转换无法拿到特定种类的数据
        System.out.println(savedInfo.toString());
    }
}
