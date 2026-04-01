package com.east.demo.service.util.common;

import org.junit.jupiter.api.Test;

class CommonUtilTest {


    @Test
    void getTransferCode() {
        for (Long i = 1L; i < 11; i++) {
            long l = CommonUtil.encryptLong(i);
            String transferCode = CommonUtil.base32Encode(l);
            System.out.println(transferCode);
        }
    }

}