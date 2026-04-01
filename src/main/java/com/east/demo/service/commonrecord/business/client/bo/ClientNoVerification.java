package com.east.demo.service.commonrecord.business.client.bo;

/**
 * 客户导入校验基类
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 15:48
 */
public class ClientNoVerification extends ClientBaseVerification {
    private String name;
    private String no;

    public ClientNoVerification(String name, String no) {
        this.name = name;
        this.no = no;
    }

    /**
     * @return 返回客户编号校验是否合法
     */
    @Override
    public String verify() {
        return "";
    }
}
