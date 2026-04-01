package com.east.demo.other.usage.advanced.oop.wildcards.interfac;


import com.east.demo.other.usage.advanced.oop.wildcards.interfac.model.bo.BaseSavedInfo;

/**
 * 保存下单相关信息， 模板方法
 *
 * @author: east
 * @date: 2023/11/23
 */
public interface Save {
    /**
     * 保存下单数据
     *
     * @param savedInfo 相关信息:账单表，统计表
     */
    public <T extends BaseSavedInfo> void save(T savedInfo);
}
