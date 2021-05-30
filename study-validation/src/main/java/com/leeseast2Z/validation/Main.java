package com.leeseast2Z.validation;

import com.leeseast2Z.validation.entity.User;
import com.leeseast2Z.validation.group.Create;
import org.springframework.validation.annotation.Validated;

import javax.validation.groups.Default;
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
        saveUser(user);
    }

    public static void saveUser(@Validated({Create.class, Default.class}) User user) {
        BeanValidator.check(user);
    }
}
