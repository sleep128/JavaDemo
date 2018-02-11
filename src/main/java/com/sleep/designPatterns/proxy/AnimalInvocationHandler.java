package com.sleep.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalInvocationHandler implements InvocationHandler{
    Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("bark".equals(method.getName())){
            System.out.println("before");
            method.invoke(animal,args);
            System.out.println("after");
        }
        return null;
    }
}
