package com.sleep.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReenterLock {
    public static void main(String[] args) {
        MyReentrantLock myReentrantLock = new MyReentrantLock();
        Thread t1 = new Thread(myReentrantLock);
        t1.start();

    }
}
