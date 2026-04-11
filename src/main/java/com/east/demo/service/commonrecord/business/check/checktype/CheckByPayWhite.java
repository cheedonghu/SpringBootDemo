package com.east.demo.service.commonrecord.business.check.checktype;

import org.springframework.stereotype.Service;

/**
 * 付方白名单对账
 *
 * @author: east
 * @date: 2026/4/9 15:33
 */
@Service
public class CheckByPayWhite implements Check {
    /**
     * 账单发起的对账
     */
    @Override
    public void billCheck() {
        System.out.println("账单发起了对账，通过付方白名单寻找流水");
    }

    /**
     * 流水发起的对账
     */
    @Override
    public void hostCheck() {
        System.out.println("流水发起了对账，通过付方白名单寻找账单");
    }

}
