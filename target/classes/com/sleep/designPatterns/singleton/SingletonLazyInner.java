package com.sleep.designPatterns.singleton;

/**
 * 单例lazy:内部类实现
 *
 * @author
 */
public class SingletonLazyInner {
    private static SingletonLazyInner instance;

    private SingletonLazyInner() {
    }

    private static class LazyHolder {
        private final static SingletonLazyInner instance = new SingletonLazyInner();
    }

    public static SingletonLazyInner getInstance() {
        return LazyHolder.instance;
    }
}
