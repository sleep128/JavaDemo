package com.sleep.thread.amino;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试多线程
 * @author
 */
public class ThreadTest {
    public static void main(String[] args) {
//        testSimpleThread();
        testAtomicThread();
//        testThreadPool();
    }

    private static void testSimpleThread(){
        TicketSellerThread ticketSellerThread = new TicketSellerThread(15);
        Thread t1 = new Thread(ticketSellerThread,"a");
        Thread t2 = new Thread(ticketSellerThread,"b");
        Thread t3 = new Thread(ticketSellerThread,"c");
        Thread t4 = new Thread(ticketSellerThread,"d");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private static void testAtomicThread(){
        TicketSellerAtomic ticketSellerThread = new TicketSellerAtomic(15);
        Thread t1 = new Thread(ticketSellerThread,"a");
        Thread t2 = new Thread(ticketSellerThread,"b");
        Thread t3 = new Thread(ticketSellerThread,"c");
        Thread t4 = new Thread(ticketSellerThread,"d");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private static void testThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        TicketSellerAtomic ticketSellerAtomic = new TicketSellerAtomic(15);
        for(int i = 0;i<15;i++){
            executorService.submit(ticketSellerAtomic);
        }

    }

}
