package com.sleep.designPatterns.singleton;

/**
 * 双重校验单例-lazy
 * 第一个判空，如果不为空直接返回，不用再获取锁，减少性能开销
 * 第二个判空
 * @author
 */
public class SingletonLazyDoubleCheck {
    private  static volatile SingletonLazyDoubleCheck instance;
    private SingletonLazyDoubleCheck(){}
    public static SingletonLazyDoubleCheck getInstance(){
        if(instance == null){
            synchronized (SingletonLazyDoubleCheck.class){
                if(instance == null){
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return instance;
    }


}
