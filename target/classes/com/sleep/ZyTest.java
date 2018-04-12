package com.sleep;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class ZyTest {
    public static void main(String[] args) {
        Long l1 = 0L;
        synchronized (ZyTest.class){
            l1++;
        }
    }
}
