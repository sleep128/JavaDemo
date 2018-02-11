package com.sleep.enhanceThread.testVolatile;

import javax.sound.midi.Soundbank;

public class MyVolatile {

    public  static int count =0;
    private static Object ob =new Object();

    public static void main(String[] args) {
        for(int i =0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    synchronized (ob){
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        for(int j =0;j<100;j++){
                            count++;
                        }
                    }

                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count="+count);
    }

}
