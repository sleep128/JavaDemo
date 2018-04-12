package com.sleep.designPatterns.adapter;

/**
 * @author zy
 */
public class TestAdapter {
    public static void main(String[] args) {
        Turkey simpleTurkey = new SimpleTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(simpleTurkey);
        turkeyAdapter.quack();
        turkeyAdapter.fly();
        System.out.println("test conflict");
        System.out.println("20:08");
    }
}
