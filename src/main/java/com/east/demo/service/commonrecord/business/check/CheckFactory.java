package com.east.demo.service.commonrecord.business.check;

import com.east.demo.service.commonrecord.business.check.checksouce.AbstractCheck;
import com.east.demo.service.commonrecord.business.check.checksouce.BIllSourceCheck;
import com.east.demo.service.commonrecord.business.check.checksouce.CheckSource;
import com.east.demo.service.commonrecord.business.check.checksouce.HostSourceCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 对账工厂，根据渠道选择对账实现
 *
 * @author: east
 * @date: 2026/4/9 15:39
 */
@Component
public class CheckFactory {
    // 使用 Map 存储处理器实例，避免重复创建
    private static final Map<CheckSource, AbstractCheck> PROCESSOR_MAP = new HashMap<>(3);

    @Autowired
    HostSourceCheck hostSourceCheck;
    @Autowired
    BIllSourceCheck bIllSourceCheck;


    // static {
    //     // 注册业务逻辑 (实际项目中，这里可以配合 Spring 的 @PostConstruct 自动注入) 还可以通过SpringUtil拿出所有AbstractCheck类型bean直接注入
    //     PROCESSOR_MAP.put(CheckChannel.HOST, new HostChannelCheck());
    //     PROCESSOR_MAP.put(CheckChannel.WALLET, new WalletChannelCheck());
    // }

    @PostConstruct
    public void init() {
        PROCESSOR_MAP.put(CheckSource.HOST, hostSourceCheck);
        PROCESSOR_MAP.put(CheckSource.BILL, bIllSourceCheck);
    }

    /**
     * 根据渠道和类型获取对应的处理器
     */
    public static AbstractCheck getProcessor(CheckSource channel) {
        AbstractCheck processor = PROCESSOR_MAP.get(channel);
        if (processor == null) {
            throw new IllegalArgumentException("未找到匹配的业务处理器: " + channel);
        }
        return processor;
    }

}
