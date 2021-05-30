package com.leeseast2Z.cl;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:45
 * @Description:
 */
public interface Strategy {

    // 计算方法
    double compute(long money);

    // 返回 type
    int getType();
}
