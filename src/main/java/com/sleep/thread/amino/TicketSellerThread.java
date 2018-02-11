package com.sleep.thread.amino;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 普通创建
 * @author
 */
public class TicketSellerThread implements Runnable{
    //ticket num
    private int count;
    public TicketSellerThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (TicketSellerThread.class){
            while (count>0){
                count--;
                System.out.println("thread:"+Thread.currentThread().getName()+",ticket:"+count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
