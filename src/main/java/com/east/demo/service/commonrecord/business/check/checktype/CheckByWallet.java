package com.east.demo.service.commonrecord.business.check.checktype;

import com.east.demo.common.exception.BaseException;
import com.east.demo.common.exception.ErrorEnum;
import org.springframework.stereotype.Service;

/**
 * 余额对账
 *
 * @author: east
 * @date: 2026/4/9 15:33
 */
@Service
public class CheckByWallet implements Check {
    /**
     * 账单发起的对账
     */
    @Override
    public void billCheck() {
        System.out.println("账单发起了余额对账，首先判断余额支付是否支持");
    }

    /**
     * 流水发起的对账
     */
    @Override
    public void hostCheck() {
        throw new BaseException(ErrorEnum.FAIL, () -> "暂不支持");
    }

}
