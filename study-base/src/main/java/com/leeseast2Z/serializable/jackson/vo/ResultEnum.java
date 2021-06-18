package com.leeseast2Z.serializable.jackson.vo;

/**
 * @Author: limf
 * @Date: 2021/6/8 16:24
 * @Description: 统一返回状态码
 *
 * 1. 0表示正确返回，其他错误码含义业务自定义
 * 2. code保留位4、5 位错误码为数字广东自用码段，请合作商使 6 位或以上的错误码，防止冲突。
 */
public enum ResultEnum {
    SUCCESS(0, "操作成功"),
    UNKNOWN_ERROR(200001, "系统异常"),
    PARAM_ERROR(200002, "参数不合法"),
    DATABASE_ERROR(200003, "数据库异常"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
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
