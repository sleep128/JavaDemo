package com.sleep.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        Animal dog = new Dog();
        InvocationHandler invocationHandler = new AnimalInvocationHandler(dog);
        System.out.println(dog.getClass().getClassLoader());
        System.out.println(dog.getClass().getInterfaces());
        Animal dogProxy = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(),dog.getClass().getInterfaces(),invocationHandler);
        dogProxy.bark();

        System.out.println(dog.getClass().getClassLoader().getResource("").toString());
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1==str2);

        String str3 =new String ("abc");
        String str4 =new String ("abc");
        System.out.println(str3==str4);
    }
}
