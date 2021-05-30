package com.leeseast2Z.cl;

import com.leeseast2Z.cl.impl.GoldStrategy;
import com.leeseast2Z.cl.impl.OrdinaryStrategy;
import com.leeseast2Z.cl.impl.PlatinumStrategy;
import com.leeseast2Z.cl.impl.SilverStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: limf
 * @Date: 2021/5/28 16:44
 * @Description: 工厂类
 */
public class StrategyFactory {

    private Map<Integer, Strategy> map;

    public StrategyFactory() {
        List<Strategy> strategies = new ArrayList<>();
        strategies.add(new OrdinaryStrategy());
        strategies.add(new SilverStrategy());
        strategies.add(new GoldStrategy());
        strategies.add(new PlatinumStrategy());
        // 看这里 看这里 看这里！
        map = strategies.stream().collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
        /* 等同上面
        map = new HashMap<>();
        for (Strategy strategy : strategies) {
            map.put(strategy.getType(), strategy);
        }*/
    }

    // 静态内部类单例，单例模式实现的一种
    public static class Holder {
        public static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

    public Strategy get(Integer type) {
        return map.get(type);
    }
}
