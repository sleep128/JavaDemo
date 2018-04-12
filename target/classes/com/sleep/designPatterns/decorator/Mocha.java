package com.sleep.designPatterns.decorator;

/**
 * mocha装饰者
 * @author
 */
public class Mocha extends CondimentDecorator{
    //被装饰者
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }
}
