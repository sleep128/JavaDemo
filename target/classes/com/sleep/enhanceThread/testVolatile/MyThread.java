package com.sleep.enhanceThread.testVolatile;

public class MyThread implements Runnable{

    private int ticketNUm =100;
    Object ob = new Object();


    private void sellTicket(){
        synchronized (ob){
            if(ticketNUm>0){
                ticketNUm --;
                System.out.println(Thread.currentThread().getName()+"正在卖票，还剩:" +ticketNUm+"张.");
            }else{
                System.out.println(Thread.currentThread().getName()+"票已售完。");
            }
        }
    }

    public void run() {
        while(ticketNUm>0){
            sellTicket();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
