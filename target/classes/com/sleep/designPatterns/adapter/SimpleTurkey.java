package com.sleep.designPatterns.adapter;

/**
 * @author zy
 */
public class SimpleTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Turkey gobble");
    }

    @Override
    public void fly() {
        System.out.println("Turkey Fly");
    }
}
