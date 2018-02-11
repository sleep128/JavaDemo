package com.sleep.designPatterns.singleton;

/**
 * 单例hunger
 * @author
 */
public class SingletonHunger {
    private final static SingletonHunger instance = new SingletonHunger();
    private SingletonHunger(){};
    public static SingletonHunger getInstance(){
        return instance;
    }
}
