package com.sleep.thread.threadPool;

public class ThreadPoolTest {

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            ThreadPool.getInstance().start(new SleepThread("thread test:"+i));
        }
//        for(int i=0;i<3;i++){
//            new Thread(new SleepThread("thread test:"+i)).start();
//        }

    }
}
