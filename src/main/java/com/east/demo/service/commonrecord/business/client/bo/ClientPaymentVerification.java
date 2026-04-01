package com.east.demo.service.commonrecord.business.client.bo;

/**
 * 客户导入校验基类
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 15:48
 */
public class ClientPaymentVerification extends ClientBaseVerification {

    private String name;
    private String payInfo;

    public ClientPaymentVerification(String name, String payInfo) {
        this.name = name;
        this.payInfo = payInfo;
    }


    /**
     * 返回付款信息是否合法
     */
    @Override
    public String verify() {
        return "";
    }
}
