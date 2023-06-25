package com.leeseast2Z.validation;

import com.leeseast2Z.validation.entity.User;

import java.util.Date;

/**
 * @Author: limf
 * @Date: 2021/5/21 16:09
 * @Description: Main
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername(null);
        user.setDate(new Date());
        user.setaShort(Short.valueOf("1"));
        // BeanValidator.check(user, Create.class);
    }

}
