package com.east.demo.other.model.advanced.abstractinfo;

/**
 * 与A系统进行Http交互实现类
 *
 * @author: east
 * @date: 2023/10/23
 */

public class SystemAHttpUtil extends AbstractSystemHttpUtil {
    public String post(String param) {
        this.doSign();
        System.out.println("post a request");
        this.affirmSign();
        System.out.println("do some exchange");
        return "this is result：" + param;
    }

}
