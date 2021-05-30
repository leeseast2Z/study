package com.leeseast2Z.cl.impl;

import com.leeseast2Z.cl.Strategy;
import com.leeseast2Z.cl.UserType;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:59
 * @Description: 白银会员
 */
public class SilverStrategy implements Strategy {
    @Override
    public double compute(long money) {
        return money - 50;
    }

    @Override
    public int getType() {
        return UserType.SILVER_VIP.getCode();
    }
}
