package com.sleep.enhanceThread.testThreadLocal;

/**
 * @author wb-zy215796
 */
public class StringTask implements Runnable {
    private String name;

    public StringTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (null == MyThreadLocal.threadLocal.get()) {
                MyThreadLocal.threadLocal.set("a");
                System.out.println("线程" + name + ": a");
            } else {
                String str = (String) MyThreadLocal.threadLocal.get();
                MyThreadLocal.threadLocal.set(str + "a");
                System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
