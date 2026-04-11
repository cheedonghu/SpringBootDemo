package com.east.demo.service.commonrecord.business.check.checktype;

/**
 * 对账
 *
 * @author: east
 * @date: 2026/4/9 15:32
 */
public interface Check {
    /**
     * 账单发起的对账
     */
    void billCheck();

    /**
     * 流水发起的对账
     */
    void hostCheck();

}
