package com.sleep.thread.amino;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic应用
 * @author
 */
public class TicketSellerAtomic implements Runnable{
    //总票数
    private AtomicInteger num ;

    public TicketSellerAtomic(int num) {
        this.num = new AtomicInteger(num);
    }

    @Override
    public void run() {
        while (num.get()>0){
            int count = num.decrementAndGet();
            System.out.println("thread:"+Thread.currentThread().getName()+",ticket:"+count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
