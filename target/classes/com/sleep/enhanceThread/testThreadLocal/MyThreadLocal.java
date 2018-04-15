package com.sleep.enhanceThread.testThreadLocal;

/**
 * @author zy
 */
public class MyThreadLocal {

    public static final ThreadLocal<Object> threadLocal  = new ThreadLocal<Object>(){

        @Override
        protected Object initialValue() {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };
}
