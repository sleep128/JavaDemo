package com.sleep.designPatterns.jvm;

public class TestLoadClass {
    public static void main(String[] args) {
        ClassLoader classLoader = TestLoadClass.class.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        ClassLoader parent1 = parent.getParent();
        System.out.println(classLoader);
        System.out.println(parent);
        /**
         * parent1 为Null
         * 因为BootStrapClassLoader是用c++写的
         */
        System.out.println(parent1);
    }
}
