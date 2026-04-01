package com.east.demo.service.commonrecord.business.check;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 流水对账
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 21:21
 */
@Service
@Slf4j
public class WalletCheck extends AbstractCheck {
    /**
     *
     */
    @Override
    public void preCheck() {
        log.info("this is wallet preCheck");
    }

    /**
     *
     */
    @Override
    public void check() {
        log.info("this is wallet check");
    }

    /**
     *
     */
    @Override
    public void postCheck() {
        super.postCheck();
        log.info("this is wallet specific postCheck");
    }
}
