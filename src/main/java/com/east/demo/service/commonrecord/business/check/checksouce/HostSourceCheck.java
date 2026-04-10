package com.east.demo.service.commonrecord.business.check.checksouce;

import com.east.demo.service.commonrecord.business.check.CheckTypeFactory;
import com.east.demo.service.commonrecord.business.check.checktype.Check;
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
public class HostSourceCheck extends AbstractCheck {
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
        for (Check check : CheckTypeFactory.getProcessor()) {
            check.hostCheck();
        }
    }

    /**
     *
     */
    @Override
    public void postCheck() {
        super.postCheck();
    }
}
