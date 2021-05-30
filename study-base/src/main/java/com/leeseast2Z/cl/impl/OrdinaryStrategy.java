package com.leeseast2Z.cl.impl;

import com.leeseast2Z.cl.Strategy;
import com.leeseast2Z.cl.UserType;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:59
 * @Description: 普通会员
 */
public class OrdinaryStrategy implements Strategy {
    @Override
    public double compute(long money) {
        return money;
    }

    @Override
    public int getType() {
        return UserType.ORDINARY_VIP.getCode();
    }
}
