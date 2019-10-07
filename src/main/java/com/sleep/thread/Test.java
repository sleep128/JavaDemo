package com.sleep.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static volatile int count = 0;

    public static final int scount = 30;


    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<=scount) {
                    reentrantLock.lock();
                    if (count >= scount) {
                        reentrantLock.unlock();
                        return;
                    }
                    if (count%3 == 0) {
                        System.out.println("A");
                        count++;
                    }
                    reentrantLock.unlock();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<=scount) {
                    reentrantLock.lock();
                    if (count >= scount) {
                        reentrantLock.unlock();
                        return;
                    }
                    if (count % 3 == 1) {
                        System.out.println("B");
                        count++;
                    }
                    reentrantLock.unlock();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<=scount) {
                    reentrantLock.lock();
                    if (count >= scount) {
                        reentrantLock.unlock();
                        return;
                    }
                    if (count % 3 == 2) {
                        System.out.println("C");
                        count++;
                    }
                    reentrantLock.unlock();
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }

}
