package com.east.demo.service.commonrecord.business.client.bo;

/**
 * 客户导入校验基类
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 15:48
 */
public class ClientNameVerification extends ClientBaseVerification {
    private String name;

    public ClientNameVerification(String name) {
        this.name = name;
    }

    /**
     * @return 返回客户名称校验结果，无问题则返回空
     */
    @Override
    public String verify() {
        return "";
    }
}
