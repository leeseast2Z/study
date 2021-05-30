package com.leeseast2Z.cl.impl;

import com.leeseast2Z.cl.Strategy;
import com.leeseast2Z.cl.UserType;

/**
 * @Author: limf
 * @Date: 2021/5/28 17:00
 * @Description: 白金会员
 */
public class PlatinumStrategy implements Strategy {
    @Override
    public double compute(long money) {
        return money * 0.7;
    }

    @Override
    public int getType() {
        return UserType.PLATINUM_VIP.getCode();
    }
}
