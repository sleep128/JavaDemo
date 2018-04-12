package com.sleep.myRedis;

import redis.clients.jedis.Jedis;

public class RedisList {

    public void testList(){
        Jedis jedis = RedisConnectionSilgleton.getJedis();
    }
}
