package com.yang.springcloud.base.util;

public enum CommonResultStatusEnum {

    FAIL(-1, "请求失败"),

    SUCCESS(0, "请求成功");

    Integer code;

    String message;

    CommonResultStatusEnum(Integer code, String desc) {
        this.code = code;
        this.message = desc;
    }

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

}
