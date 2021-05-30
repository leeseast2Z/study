package com.leeseast2Z.cl.impl;

import com.leeseast2Z.cl.Strategy;
import com.leeseast2Z.cl.UserType;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:59
 * @Description: 黄金会员
 */
public class GoldStrategy implements Strategy {
    @Override
    public double compute(long money) {
        return money * 0.8;
    }

    @Override
    public int getType() {
        return UserType.GOLD_VIP.getCode();
    }
}
