package com.sleep.thread.threadPool;

public class SleepThread implements Runnable {
    private String name;

    public SleepThread(String name) {
        this.name = name;
    }

    public SleepThread() {
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
