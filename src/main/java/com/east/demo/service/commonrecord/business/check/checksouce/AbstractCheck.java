package com.east.demo.service.commonrecord.business.check.checksouce;

import lombok.extern.slf4j.Slf4j;


/**
 * 对账模板
 */
@Slf4j
public abstract class AbstractCheck {

    public void process() {
        preCheck();
        check();
        postCheck();
    }

    public abstract void preCheck();

    public abstract void check();

    public void postCheck() {
        log.info("核销成功，进行通用后处理");
        // kafkaProducerService.sendMessage("");
        log.info("发送Kafka通知");
    }
}
