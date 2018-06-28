package com.sleep.thread.threadtest;

public class ThreadObj implements Runnable {


    @Override
    public void run() {
            SyncObject syncObject = new SyncObject();
            syncObject.syncMethod2();
    }
}
