package com.leeseast2Z.validation.entity;

import com.leeseast2Z.validation.BeanValidator;
import com.leeseast2Z.validation.Main;
import com.leeseast2Z.validation.group.Create;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: limf
 * @Date: 2021/5/21 17:00
 * @Description: 测试用户Entity
 *
 * #1 注解一定放在getter方法上？
 * 除了setter方法，放在属性上也是可以的
 * Void methods must not be constrained or marked for cascaded validation
 *
 * #2
 *
 */
public class User {
    @NotEmpty(groups = Create.class)
    // @Length(min = 1, max = 10, groups = Create.class)
    private String username;
    private String phone;
    @NotNull
    private Date date;
    @Range(min = 0, max = 10)
    private Short aShort;
    private Integer integer;
    private Long aLong;
    private Float aFloat;
    private Double aDouble;
    @Range(min = 0, max = 10)
    private BigDecimal bigDecimal;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getaShort() {
        return aShort;
    }

    public void setaShort(Short aShort) {
        this.aShort = aShort;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public void setaFloat(Float aFloat) {
        this.aFloat = aFloat;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }
}
