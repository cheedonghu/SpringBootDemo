package com.east.demo.service.commonrecord.business.check;

import com.east.demo.service.commonrecord.business.check.checksouce.AbstractCheck;
import com.east.demo.service.commonrecord.business.check.checksouce.CheckSource;
import org.springframework.stereotype.Service;

/**
 * 对账模拟
 *
 * @author: east
 * @date: 2026/4/9 15:25
 */
@Service
public class CheckService {

    public void check(CheckSource channel) {
        AbstractCheck channelProcessor = CheckFactory.getProcessor(channel);

        channelProcessor.process();
    }

}
