package com.sleep.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 */
public class MyReentrantLock implements Runnable{
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static int count = 0;
    @Override
    public void run() {
        for (int i =0;i<100;i++){
            reentrantLock.lock();
            try {
                i++;
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
