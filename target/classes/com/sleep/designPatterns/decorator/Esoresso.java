package com.sleep.designPatterns.decorator;

/**
 * 被装饰者
 * @author
 */
public class Esoresso extends Beverage{
    public Esoresso() {
        description = "浓缩咖啡";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
