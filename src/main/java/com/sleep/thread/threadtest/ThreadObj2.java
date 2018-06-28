package com.sleep.thread.threadtest;

public class ThreadObj2 implements Runnable{


    private SyncObject syncObject;

    public ThreadObj2(SyncObject syncObject) {
        this.syncObject = syncObject;
    }

    @Override
    public void run() {
//        syncObject = new SyncObject();
        syncObject.syncMethod4();
    }
}
