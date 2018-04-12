package com.sleep.myRedis;

import redis.clients.jedis.Jedis;

public class RedisHelpler {
    private static final String NX = "NX";
    private static final String XX = "XX";
    private static final String EX = "EX";
    private static final String PX = "PX";
    private static final String OK = "OK";
    private static Jedis jedis = null;

    static {
        jedis = new Jedis("127.0.01", 6379);
    }

    public static boolean setNxEx(String key, String value, int time) {
        return OK.equals(jedis.set(key, value, NX, EX, time)) ? true : false;
    }

    public static String getStringValue(String key){
        return jedis.get(key);
    }

    public static boolean delKey(String key){
        return OK.equals(jedis.del(key)) ? true : false;
    }


}
