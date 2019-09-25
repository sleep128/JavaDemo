package com.sleep.thread.threadPool;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        System.out.println(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5),new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch countDownLatch = new CountDownLatch(15);
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i,countDownLatch);
            executor.execute(myTask);
        }

        try {
            countDownLatch.await();
            System.out.println("任务全部执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;
    private CountDownLatch countDownLatch;

    public MyTask(int num,CountDownLatch countDownLatch) {
        this.taskNum = num;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
        countDownLatch.countDown();
    }
}