package com.east.demo.service.commonrecord.business.check.checksouce;

/**
 * 对账来源发起方
 *
 * @author: east
 * @date: 2026/4/9 15:40
 */
public enum CheckSource {
    HOST("流水"),
    BILL("账单"),
    ;
    private String code;

    CheckSource(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
