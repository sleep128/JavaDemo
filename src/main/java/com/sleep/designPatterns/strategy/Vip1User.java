package com.sleep.designPatterns.strategy;

public class Vip1User implements CalculatePrice {
    /**
     * 根据传入的价格返回一个优惠价
     * vip1用户
     *
     * @param price
     * @return
     */
    @Override
    public Double calculatePrice(Double price) {
        //vip1 用户打9折
        return price * 0.9;
    }
}
