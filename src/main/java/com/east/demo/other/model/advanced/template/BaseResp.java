package com.east.demo.other.model.advanced.template;


/**
 * Description:
 * Created by east on 2023/8/6 18:09.
 */
public class BaseResp<T> {
    private String respCode;
    private String respMsg;
    private T data;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResp() {
    }

    public BaseResp(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public BaseResp(T data) {
        this.data = data;
    }

    // 这里的<T>放在返回类型前面是为了标示这是个模板而不是类成员T的类型?
    public static <T> BaseResp<T> ok(T data) {
        return new BaseResp<T>(data);
    }

    public BaseResp<T> ok2(T data) {
        return new BaseResp<T>(data);
    }
}

