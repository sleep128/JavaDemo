package com.sleep.enhanceThread.testVolatile;

public class TestThreadRun {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread,"窗口1");
        Thread t2 = new Thread(myThread,"窗口2");
        Thread t3 = new Thread(myThread,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
