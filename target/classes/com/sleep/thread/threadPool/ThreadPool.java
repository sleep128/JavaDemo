package com.sleep.thread.threadPool;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Vector;

public class ThreadPool {
    private static volatile ThreadPool instance ;

    //空线程队列
    private List<Runnable> idleThreads;

    //已有的线程总数
    private int threadCounter;

    private boolean isShutDown;

    private ThreadPool() {
        this.idleThreads = new Vector<Runnable>(5);
        threadCounter = 0;
    }

    public static ThreadPool getInstance(){
        if(instance == null){
            synchronized (ThreadPool.class){
                instance = new ThreadPool();
            }
        }
        return instance;
    }

    //获取已有线程总数
    public int getThreadCounter() {
        return threadCounter;
    }

    //将线程放入线程池中
    protected synchronized void addPool(ZyThread zyThread){
        if(isShutDown){
            zyThread.shutDown();
        }else{
            idleThreads.add(zyThread);
        }
    }

    //全部停止
    public synchronized void shutDown(){
        isShutDown = true;
        for(Runnable indexThread:idleThreads){
            ZyThread thread = (ZyThread) indexThread;
            thread.shutDown();
        }
    }

    //执行任务
    public synchronized void start(Runnable target){
        ZyThread thread = null;
        if(CollectionUtils.isNotEmpty(idleThreads)){
            int lastIndex = idleThreads.size()-1;
            thread = (ZyThread) idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            thread.setTarget(target);
        }else{
            //无空闲线程，创建新线程
            threadCounter++;
            thread = new ZyThread(target,"zyThread #" +threadCounter,this);
            //启动这个线程
            thread.start();
        }
    }



}
