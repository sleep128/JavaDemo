package com.sleep.enhanceThread.testThreadLocal;

public class ThreadLocalTest {
    public static void main(String[] args) {
        if(null == MyThreadLocal.threadLocal.get()){
             MyThreadLocal.threadLocal.set("main");
             TestThreadLocal s = new TestThreadLocal();
            System.out.println("main method:"+MyThreadLocal.threadLocal.get());
             s.method1();
            System.out.println("main method:"+MyThreadLocal.threadLocal.get());
        }
    }
}
