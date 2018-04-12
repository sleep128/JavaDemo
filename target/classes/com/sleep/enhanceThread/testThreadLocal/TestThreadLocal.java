package com.sleep.enhanceThread.testThreadLocal;

/**
 * @author wb-zy215796
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        new Thread(new StringTask("task1")).start();
        new Thread(new StringTask("task2")).start();
    }



    public void method1(){
        System.out.println("method1:"+MyThreadLocal.threadLocal.get());
        MyThreadLocal.threadLocal.set("method");
    }
}
