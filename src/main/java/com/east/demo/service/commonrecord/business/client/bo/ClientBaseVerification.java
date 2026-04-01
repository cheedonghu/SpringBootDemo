package com.east.demo.service.commonrecord.business.client.bo;

import cn.hutool.core.util.StrUtil;

/**
 * 客户导入校验基类
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 15:48
 */
public abstract class ClientBaseVerification {
    private String errorMsg;
    private boolean success;


    public abstract String verify();

    public void toVerify() {
        String msg = verify();
        if (StrUtil.isNotBlank(msg)) {
            success = false;
            errorMsg = msg;
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }
}
