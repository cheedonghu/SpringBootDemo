package com.east.demo.service.commonrecord.business.check.checktype;

/**
 * 核对方式：转账码、虚拟户，付方白名单
 *
 * @author: east
 * @date: 2026/4/9 15:28
 */
public enum CheckType {
    TRANSCODE("转账码"),
    VRACCNO("虚拟户"),
    PAY_WHITE("付方白名单"),
    WALLET("余额钱包"),

    ;
    private String code;

    CheckType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
