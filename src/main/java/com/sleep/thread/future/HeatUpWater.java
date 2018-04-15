package com.sleep.thread.future;

import java.util.concurrent.Callable;

/**
 * 烧水线程
 */
public class HeatUpWater implements Callable {

    private Water water;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Water call() throws Exception {
        System.out.println("开始烧水");
        water = new Water();
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            water.setTemperature(water.getTemperature()+25);
            if(water.getTemperature()>=100){
                break;
            }
        }
        System.out.println("水已经烧到:"+water.getTemperature());
        return water;
    }
}
