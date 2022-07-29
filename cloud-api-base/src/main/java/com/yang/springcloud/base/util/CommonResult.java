package com.yang.springcloud.base.util;


import java.io.Serializable;

public class CommonResult implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public CommonResult() {
        this.code = CommonResultStatusEnum.SUCCESS.code;
        this.message =  CommonResultStatusEnum.SUCCESS.message;
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.setData(data);
    }

    public CommonResult(Object data) {
        this.code = CommonResultStatusEnum.SUCCESS.code;
        this.message =  CommonResultStatusEnum.SUCCESS.message;
        this.setData(data);
    }

}
