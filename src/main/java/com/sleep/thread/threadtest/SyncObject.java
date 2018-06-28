package com.sleep.thread.threadtest;

public class SyncObject {
    private static final String ss = "sync";
    public static synchronized void staticMethod(){
        try {
            System.out.println("get sync");
            Thread.sleep(2000);
            System.out.println("end sync");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void syncMethod(){
        try {
            System.out.println("get :"+this);
            Thread.sleep(2000);
            System.out.println("end :"+this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void syncMethod2(){
        synchronized (SyncObject.class){
            try {
                System.out.println("syncMethod2 start : :"+this);
                Thread.sleep(2000);
                System.out.println("syncMethod2 end:"+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncMethod3(){
        synchronized (this){
            try {
                System.out.println("syncMethod3 start:"+this);
                Thread.sleep(2000);
                System.out.println("syncMethod3 end:"+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void  syncMethod4(){
            try {
                System.out.println("syncMethod4 start:"+this);
                Thread.sleep(2000);
                System.out.println("syncMethod4 end:"+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
