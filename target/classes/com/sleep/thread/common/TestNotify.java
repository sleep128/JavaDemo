package com.sleep.thread.common;

public class TestNotify {
    private static Object lockObject = new Object();


    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        tt1.start();
        tt2.start();
    }

    private static class Thread1 implements Runnable {

        @Override
        public void run() {
            synchronized (lockObject) {
                System.out.println(System.currentTimeMillis() + "t1 start");
                try {
                    System.out.println(System.currentTimeMillis() + "t1 wait");
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "t1 finish");
            }
        }
    }

    private static class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (lockObject) {
                System.out.println(System.currentTimeMillis() + "t2 start");
                lockObject.notify();
                System.out.println(System.currentTimeMillis() + "t2 finish");
                try {
                    System.out.println("sleep1");
                    Thread.sleep(1000);
                    System.out.println("sleep2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
