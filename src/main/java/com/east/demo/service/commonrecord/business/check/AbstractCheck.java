package com.east.demo.service.commonrecord.business.check;

import com.east.demo.service.middle.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/1 21:18
 */

@Slf4j
public abstract class AbstractCheck {
    @Autowired
    KafkaProducerService kafkaProducerService;

    public abstract void preCheck();

    public abstract void check();

    public void postCheck() {
        log.info("核销成功，进行通用后处理");
        // kafkaProducerService.sendMessage("");
        log.info("发送Kafka通知");
    }
}
