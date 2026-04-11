package com.east.demo.service.commonrecord.business.check;

import cn.hutool.core.collection.CollUtil;
import com.east.demo.service.commonrecord.business.check.checktype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 对账方式工厂，获取全量对账方式或单一某个方式
 *
 * @author: east
 * @date: 2026/4/9 15:39
 */
@Component
public class CheckTypeFactory {
    // 使用 Map 存储处理器实例，避免重复创建
    private static final Map<CheckType, Check> CHECKTYPE_MAP = new HashMap<>(4);

    @Autowired
    CheckByTranscode checkByTranscode;
    @Autowired
    CheckByVRAccno checkByVRAccno;
    @Autowired
    CheckByPayWhite checkByPayWhite;
    @Autowired
    private CheckByWallet checkByWallet;

    @PostConstruct
    public void init() {
        CHECKTYPE_MAP.put(CheckType.TRANSCODE, checkByTranscode);
        CHECKTYPE_MAP.put(CheckType.PAY_WHITE, checkByVRAccno);
        CHECKTYPE_MAP.put(CheckType.VRACCNO, checkByPayWhite);
        CHECKTYPE_MAP.put(CheckType.WALLET, checkByWallet);
    }

    /**
     * 根据类型获取对应的处理器
     */
    public static Check getProcessor(CheckType checkType) {
        Check processor = CHECKTYPE_MAP.get(checkType);
        if (processor == null) {
            throw new IllegalArgumentException("未找到匹配的核对方式: " + checkType.getCode());
        }
        return processor;
    }

    /**
     * 获取所有处理方式
     */
    public static Collection<Check> getProcessor() {
        if (CollUtil.isEmpty(CHECKTYPE_MAP)) {
            throw new IllegalArgumentException("未找到任何核对方式: ");
        }
        return CHECKTYPE_MAP.values();
    }

}
