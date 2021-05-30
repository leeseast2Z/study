package com.leeseast2Z.cl;

import com.leeseast2Z.cl.impl.GoldStrategy;
import com.leeseast2Z.cl.impl.OrdinaryStrategy;
import com.leeseast2Z.cl.impl.PlatinumStrategy;
import com.leeseast2Z.cl.impl.SilverStrategy;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:46
 * @Description:
 * 消除if-else
 * r1、r2、r3=简单工厂 + 策略模式。把 if - else 切换为 switch 创建一个工厂方法而已。
 */
public class Main {
    public static void main(String[] args) {
        long money = 10000;
        int type = UserType.GOLD_VIP.getCode();
        double result = getResult(money, type);
        double result2 = getResult2(money, type);
        double result3 = getResult3(money, type);
        double result4 = getResult4(money, type);
        System.out.printf("%s, %s, %s, %s", result, result2, result3, result4);
    }

    private static double getResult(long money, int type) {
        double result = money;
        if (money >= 1000) {
            if (type == UserType.SILVER_VIP.getCode()) {
                System.out.println("白银会员 优惠50元");
                result = money - 50;
            } else if (type == UserType.GOLD_VIP.getCode()) {
                System.out.println("黄金会员 8折");
                result = money * 0.8;
            } else if (type == UserType.PLATINUM_VIP.getCode()) {
                System.out.println("白金会员 优惠50元，再打7折");
                result = (money - 50) * 0.7;
            } else {
                System.out.println("普通会员 不打折");
                result = money;
            }
        }
        return result;
    }

    /**
     * 简单工厂 + 策略模式
     * @param money
     * @param type
     * @return
     */
    private static double getResult2(long money, int type) {
        double result = money;
        if (money >= 1000) {
            if (type == UserType.SILVER_VIP.getCode()) {
                result = new SilverStrategy().compute(money);
            } else if (type == UserType.GOLD_VIP.getCode()) {
                result = new GoldStrategy().compute(money);
            } else if (type == UserType.PLATINUM_VIP.getCode()) {
                result = new PlatinumStrategy().compute(money);
            } else {
                result = new OrdinaryStrategy().compute(money);
            }
        }
        return result;
    }

    /**
     * 简单工厂 + 策略模式 + 代码调整
     * @param money
     * @param type
     * @return
     */
    private static double getResult3(long money, int type) {
        if (money < 1000) {
            return money;
        }
        Strategy strategy;
        if (type == UserType.SILVER_VIP.getCode()) {
            strategy = new SilverStrategy();
        } else if (type == UserType.GOLD_VIP.getCode()) {
            strategy = new GoldStrategy();
        } else if (type == UserType.PLATINUM_VIP.getCode()) {
            strategy = new PlatinumStrategy();
        } else {
            strategy = new OrdinaryStrategy();
        }
        return strategy.compute(money);
    }

    /**
     * 消除if-else
     * @param money
     * @param type
     * @return
     */
    private static double getResult4(long money, int type) {
        if (money < 1000) {
            return money;
        }
        Strategy strategy = StrategyFactory.getInstance().get(type);
        if (strategy == null){
            throw new IllegalArgumentException("please input right type");
        }
        return strategy.compute(money);
    }
}
