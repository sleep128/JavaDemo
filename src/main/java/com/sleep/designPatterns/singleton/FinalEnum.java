package com.sleep.designPatterns.singleton;

/**
 * 实际上反编译可知枚举实际上就是一个继承Enum的类
 * 所以你的本质还是一个类，因为枚举的特点，你只会有一个实例，同时保证了线程安全、反射安全和反序列化安全
 */
public enum FinalEnum {
    INSTANCE;
    public void doSingeltonThings(){

    }
}
