package com.east.demo.service.commonrecord.business.client;

import com.east.demo.service.commonrecord.business.client.bo.ClientBaseVerification;
import com.east.demo.service.commonrecord.business.client.bo.ClientInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 15:45
 */
@Service
@Slf4j
public class ClientImportService {
    public void clientVerification(List<ClientInfo> clientInfos) {
        List<ClientBaseVerification> clientNameVerifications = new ArrayList<>();
        List<ClientBaseVerification> clientNoVerifications = new ArrayList<>();
        List<ClientBaseVerification> clientPaymentVerifications = new ArrayList<>();
        for (ClientInfo clientInfo : clientInfos) {
            clientNameVerifications.add(clientInfo.toClientNameVerificationWrap());
            clientNoVerifications.add(clientInfo.toClientNoVerificationWrap());
            clientPaymentVerifications.add(clientInfo.toClientPaymentVerification());
        }

        CompletableFuture<Void> clientNameVerificationFuture = CompletableFuture.runAsync(() -> {
            clientNameVerifications.forEach(ClientBaseVerification::toVerify);
        });
        CompletableFuture<Void> clientNoVerificationFuture = CompletableFuture.runAsync(() -> {
            clientNoVerifications.forEach(ClientBaseVerification::toVerify);
        });
        CompletableFuture<Void> clientPaymentVerificationFuture = CompletableFuture.runAsync(() -> {
            clientPaymentVerifications.forEach(ClientBaseVerification::toVerify);
        });

        CompletableFuture.allOf(clientNameVerificationFuture, clientNoVerificationFuture, clientPaymentVerificationFuture).join();

        // 若任一校验包装类不通过，则返回失败结果，并给出错误原因
        boolean clientNameVerificationResult = clientNameVerifications.stream().anyMatch(x -> !x.isSuccess());
        boolean clientNoVerificationResult = clientNoVerifications.stream().anyMatch(x -> !x.isSuccess());
        boolean clientPaymentVerificationResult = clientPaymentVerifications.stream().anyMatch(x -> !x.isSuccess());

        log.info("三字段校验结果：{}", clientNoVerificationResult && clientNameVerificationResult && clientPaymentVerificationResult);


    }
}
