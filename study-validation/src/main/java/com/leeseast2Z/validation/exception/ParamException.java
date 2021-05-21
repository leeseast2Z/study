package com.leeseast2Z.validation.exception;

/**
 * @Author: limf
 * @Date: 2021/5/21 16:54
 * @Description: 参数异常
 */
public class ParamException extends BaseException{
    private String code;
    private String message;

    public ParamException(String message) {
        this.message = message;
    }

    public ParamException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
