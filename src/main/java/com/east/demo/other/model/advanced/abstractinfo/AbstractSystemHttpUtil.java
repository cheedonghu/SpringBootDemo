package com.east.demo.other.model.advanced.abstractinfo;

/**
 * 与多系统进行Http交互抽象类
 * <p>
 * 抽象类中非抽象部分：
 * 1.对于进行验签的系统：请求进行加签操作，响应进行验签操作
 * 2.对于进行响应转换的系统：响应转换操作
 * <p>
 * 抽象部分：根据参数发送报文
 *
 * @author: east
 * @date: 2023/10/23
 */

public abstract class AbstractSystemHttpUtil {
    public abstract String post(String param);

    protected void doSign() {
        System.out.println("I will sign this request");
    }

    protected void affirmSign() {
        System.out.println("I will examine the sign of this request");
    }

    protected void resultExchange() {
        System.out.println("I will do some common exchange to result");
    }
}
