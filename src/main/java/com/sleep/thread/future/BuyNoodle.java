package com.sleep.thread.future;

/**
 * 买面条线程
 */
public class BuyNoodle implements Runnable {
    public Noodle noodle;

    public BuyNoodle(Noodle noodle) {
        this.noodle = noodle;
    }

    @Override
    public void run() {
        System.out.println("开始去买面条");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        noodle.setName("康师傅");
        System.out.println("已经买到面条:"+noodle.getName());
    }
}
