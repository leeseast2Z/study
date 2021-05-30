package com.leeseast2Z.cl;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:47
 * @Description:
 */
public enum  UserType {
    SILVER_VIP(1, "白银会员 优惠50元"),
    GOLD_VIP(2, "黄金会员打8折"),
    PLATINUM_VIP(3, "白金会员打7折"),
    ORDINARY_VIP(4, "普通会员啥也没有"),
    ;

    UserType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

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
