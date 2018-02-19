package com.sleep.thread.common;

import java.util.concurrent.atomic.AtomicInteger;

public class TestYield {

    public static void main(String[] args) {
        Seller1 seller1 = new Seller1();
        Seller2 seller2 = new Seller2();
        Thread t1 = new Thread(seller1);
        Thread t2 = new Thread(seller2);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }


    //总票数
    private static AtomicInteger num  = new AtomicInteger(8);


    private static class Seller1 implements Runnable{

        @Override
        public void run() {
            while (num.get()>0){
                System.out.println("seller1:"+num.decrementAndGet());
                Thread.yield();
                System.out.println(System.currentTimeMillis()+"s1");
            }
        }
    }

    private static class Seller2 implements Runnable{

        @Override
        public void run() {
            while (num.get()>0){
                System.out.println("seller2:"+num.decrementAndGet());
                Thread.yield();
                System.out.println(System.currentTimeMillis()+"s2");
            }
        }
    }
}

