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
public class HostCheck extends AbstractCheck {
    /**
     *
     */
    @Override
    public void preCheck() {
        log.info("this is host preCheck");
    }

    /**
     *
     */
    @Override
    public void check() {
        log.info("this is host check");
    }

    /**
     *
     */
    @Override
    public void postCheck() {
        super.postCheck();
    }
}
