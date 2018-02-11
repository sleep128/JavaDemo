package com.sleep.thread.threadPool;

public class ZyThread  extends Thread{

    //中断标志
    private boolean isShutDown;
    //线程池
    private ThreadPool threadPool;
    //任务
    private Runnable target;
    //是否空闲
    private boolean  isIdle = false;

    public ZyThread(Runnable target, String name, ThreadPool threadPool) {
        super(name);
        this.target = target;
        this.threadPool = threadPool;
    }

    public synchronized void setTarget(Runnable target) {
        this.target = target;
        notifyAll();
    }

    public Runnable getTarget() {
        return target;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void run() {
        while (!isShutDown){
            isIdle =false;
            if(target != null){
                target.run();
            }
            //任务结束，空闲状态
            isIdle = true;
            try {
                //该任务结束后，不关闭线程，而是放入线程池队列中
                threadPool.addPool(this);
                synchronized (this){
                    //线程空闲，等待新的任务到来
                    wait();
                }
            } catch (InterruptedException e) {
                isIdle = false;
                e.printStackTrace();
            }
        }

    }

    public synchronized void shutDown(){
        isShutDown = false;
        notifyAll();
    }
}
