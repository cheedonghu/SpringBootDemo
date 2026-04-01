package com.east.demo.other.model.advanced.abstractinfo;

/**
 * 与B系统进行Http交互实现类
 *
 * @author: east
 * @date: 2023/10/23
 */

public class SystemBHttpUtil extends AbstractSystemHttpUtil {
    public String post(String param) {
        System.out.println("post a request");
        resultExchange();

        return "this is result：" + param;
    }

    @Override
    protected void resultExchange() {
        super.resultExchange();
        System.out.println("I will do some extra things");
    }
}
