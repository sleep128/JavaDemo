package com.sleep.designPatterns.singleton;

/**
 * 双重校验单例-lazy
 * @author
 */
public class SingletonLazyDoubleCheck {
    private static SingletonLazyDoubleCheck instance;
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
