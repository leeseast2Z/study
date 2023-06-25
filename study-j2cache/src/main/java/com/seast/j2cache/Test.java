package com.seast.j2cache;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;

/**
 * @Author: Limf
 * @Date: 2023/6/15 15:22
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        CacheChannel cache = J2Cache.getChannel();
        //缓存操作
        cache.set("default", "1", "Hello J2Cache");
        System.out.println(cache.get("default", "1"));
        // cache.evict("default", "1");
        cache.set("default", "2", "Hello J2Cache 2");
        System.out.println(cache.get("default", "1"));
        System.out.println(cache.get("default", "2"));
        cache.close();
    }
}
