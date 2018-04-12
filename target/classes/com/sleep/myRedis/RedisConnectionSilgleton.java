package com.sleep.myRedis;

import redis.clients.jedis.Jedis;

public class RedisConnectionSilgleton {
    private static volatile Jedis jedis;

    public static Jedis getJedis(){
        if(jedis == null){
            synchronized (RedisConnectionSilgleton.class){
                if(jedis == null){
                    jedis = new Jedis("127.0.0.1",6379);
                }
            }
        }
        return jedis;
    }

}
