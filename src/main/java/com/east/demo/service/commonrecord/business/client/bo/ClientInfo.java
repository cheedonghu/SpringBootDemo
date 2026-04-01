package com.east.demo.service.commonrecord.business.client.bo;

import lombok.Data;

/**
 *
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 15:57
 */
@Data
public class ClientInfo {
    private String name;
    private String no;
    private String payment;


    public ClientBaseVerification toClientNameVerificationWrap() {
        return new ClientNameVerification(name);
    }

    public ClientNoVerification toClientNoVerificationWrap() {
        return new ClientNoVerification(name, no);
    }

    public ClientPaymentVerification toClientPaymentVerification() {
        return new ClientPaymentVerification(name, payment);
    }
}
