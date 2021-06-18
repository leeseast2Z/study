package com.leeseast2Z.serializable.jackson.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author: limf
 * @Date: 2021/6/8 16:19
 * @Description: 统一返回结果
 *
 * PS: code为Integer类型，当code=0时，jackson不会序列化code字段，
 * 所以加上 JsonInclude.Include.NON_DEFAULT，防止此类型出现
 *
 * https://www.logicbig.com/tutorials/misc/jackson/json-include-non-empty.html
 *
 *
 * jackson.vo.ResponseVO has no default constructor;
 * can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseVO<T>  {
    private Integer code;
    private String message;
    private T data;



    public ResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseVO<T> success() {
        return new ResponseVO<>(ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getMessage());
    }

    public static <T> ResponseVO<T> success(T data) {
        return new ResponseVO<>(ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getMessage(),
                data);
    }

    public static <T> ResponseVO<T> fail() {
        return new ResponseVO<>(ResultEnum.UNKNOWN_ERROR.getCode(),
                ResultEnum.UNKNOWN_ERROR.getMessage());
    }

    public static <T> ResponseVO<T> fail(String message) {
        return new ResponseVO<>(ResultEnum.UNKNOWN_ERROR.getCode(),
                message);
    }

    public static <T> ResponseVO<T> fail(Integer code, String message) {
        return new ResponseVO<>(code,
                message);
    }

    public static <T> ResponseVO<T> param() {
        return new ResponseVO<>(ResultEnum.PARAM_ERROR.getCode(),
                ResultEnum.PARAM_ERROR.getMessage());
    }
}
