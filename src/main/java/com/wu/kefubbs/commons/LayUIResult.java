/**
 * @program: kefu
 * @description: layui响应结果json
 * @author: Wu
 * @create: 2019-11-16 10:30
 **/
package com.wu.kefubbs.commons;

import lombok.Data;

import java.io.Serializable;

@Data
public class LayUIResult implements Serializable {

    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public LayUIResult() {
    }

    public static LayUIResult build(Integer code, Integer count, String msg, Object data) {
        return new LayUIResult(code, count, msg, data);
    }

    public static LayUIResult build(Integer code, String msg, Object data) {
        return new LayUIResult(code, msg, data);
    }

    public static LayUIResult ok(Object data) {
        return new LayUIResult(data);
    }

    public static LayUIResult success() {
        return new LayUIResult(200,null,"登录成功",null);
    }

    public static LayUIResult ok() {
        return new LayUIResult(null);
    }

    public static LayUIResult build(Integer code, String msg) {
        return new LayUIResult(code, msg, null);
    }


    public LayUIResult(Integer code, Integer count, String msg, Object data) {
        this.count = count;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public LayUIResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public LayUIResult(Object data) {
        this.code = 0;
        this.msg = "OK";
        this.data = data;
    }

}
