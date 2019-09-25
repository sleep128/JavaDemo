package com.sleep.designPatterns.singleton;

/**
 * 静态方法单例
 */
public class StaticSingleton {

    private StaticSingleton(){
    }

    private static final class SingletonHolder{
        private static final StaticSingleton instance =new StaticSingleton();
    }

    private static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

    /**
     * 避免反序列化破坏单例
     * 这是反序列化机制决定的
     * 在反序列化的时候会判断如果实现了serializable或者externalizable接口的类中又包含readResolve()方法的话
     * 会直接调用readResolve()方法来获取实例。
     * @return
     */
    private Object readResolve(){
        return SingletonHolder.instance;
    }
}
