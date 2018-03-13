package com.sleep.myRedis;

import com.sleep.myUtil.SuperDate;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;


public class JedisLocker {


    @Test
    public void lockKey() throws InterruptedException {
        String key = "current_key";
        String value = SuperDate.getNowStr();
        if(RedisHelpler.setNxEx(key,value,2)){
            System.out.println(String.format("get lock success:%s", key));
            Thread.sleep(2000);
            //解锁(判断是否是自己的锁)
            if(value.equals(RedisHelpler.getStringValue(key))){
                //解锁
                System.out.println(String.format("unlock key:%s", key));
                RedisHelpler.delKey(key);
            }
        }else{
            System.out.println(String.format("get lock failure:%s", key));
        }
    }
}
