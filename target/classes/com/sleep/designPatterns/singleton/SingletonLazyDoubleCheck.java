package com.sleep.designPatterns.singleton;

/**
 * 双重校验单例-lazy
 * 第一个判空，如果不为空直接返回，不用再获取锁，减少性能开销
 * 第二个判空，防止线程并发操作，两个线程同时通过1处的判断，获取2处的锁，
 * 第一个获得到锁的，3处的判断通过并new，后面一个线程获取锁后3处判断不通过。
 * vilatile关键字防止nstance = new SingletonLazyDoubleCheck();操作指令重排
 * http://blog.csdn.net/chenchaofuck1/article/details/51702129
 * @author
 */
public class SingletonLazyDoubleCheck {

    private  static volatile SingletonLazyDoubleCheck instance;

    private SingletonLazyDoubleCheck(){}

    public static SingletonLazyDoubleCheck getInstance(){
        if(instance == null){                               //1
            synchronized (SingletonLazyDoubleCheck.class){  //2
                if(instance == null){                       //3
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return instance;
    }


}
