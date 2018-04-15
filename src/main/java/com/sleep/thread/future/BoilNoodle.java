package com.sleep.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class BoilNoodle {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        //第一步，烧水
        FutureTask<Water> heatWaterTask = new FutureTask<Water>(new HeatUpWater());
        new Thread(heatWaterTask).start();
        //第二部 买面条
        Noodle noodle = new Noodle();
        Thread buyNoodleThread = new Thread(new BuyNoodle(noodle));
        buyNoodleThread.start();
        buyNoodleThread.join();
        Water water = null;
        //判断水烧好了没
        while (true){
            if(heatWaterTask.isDone()){
                water = heatWaterTask.get();
                System.out.println("水烧好了,现在水温:"+water.getTemperature());
                break;
            }else{
                System.out.println("水还没烧好");
                Thread.sleep(500);
            }
        }
        Water water1 = heatWaterTask.get();
        //第三部煮面
        cookNoodle(water,noodle);
        long endTime = System.currentTimeMillis();
        System.out.println("面煮好了，共耗时:"+(endTime-startTime));
    }

    private static void cookNoodle(Water water, Noodle noodle){
        System.out.println("开始煮面");
        System.out.println("水温:"+water.getTemperature());
        System.out.println("面:+"+noodle.getName());
    }



}
