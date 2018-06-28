package com.sleep.thread.threadtest;

public class Test {

    public static void main(String[] args) {

//        new Thread(new ThreadObj()).start();
//        new Thread(new ThreadObj()).start();

        SyncObject syncObject = new SyncObject();
        new Thread(new ThreadObj2(syncObject)).start();
        new Thread(new ThreadObj2(syncObject)).start();
    }
}
