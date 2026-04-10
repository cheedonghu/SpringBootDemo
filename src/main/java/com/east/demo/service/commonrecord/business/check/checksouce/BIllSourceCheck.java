package com.east.demo.service.commonrecord.business.check.checksouce;

import com.east.demo.service.commonrecord.business.check.CheckTypeFactory;
import com.east.demo.service.commonrecord.business.check.checktype.Check;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 订单发起的对账
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 21:21
 */
@Service
@Slf4j
public class BIllSourceCheck extends AbstractCheck {
    /**
     *
     */
    @Override
    public void preCheck() {
        log.info("this is bill preCheck");
    }

    /**
     *
     */
    @Override
    public void check() {
        for (Check check : CheckTypeFactory.getProcessor()) {
            check.billCheck();
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
