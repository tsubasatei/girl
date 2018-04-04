package com.xt.girl.domain;

/**
 * Created with xt.
 * Date: 2018/3/15
 * Time: 15:16
 * Description: http请求返回的对象格式
 */
public class Result<T> {

    private Integer code; //错误码
    private String msg;   //错误信息
    private T data;       //返回对象

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }
}
