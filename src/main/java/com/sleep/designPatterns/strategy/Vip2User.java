package com.sleep.designPatterns.strategy;

public class Vip2User implements CalculatePrice {
    /**
     * 根据传入的价格返回一个优惠价
     * vip2 用户
     *
     * @param price
     * @return
     */
    @Override
    public Double calculatePrice(Double price) {
        //vip2 用户打0.8折
        return price * 0.8;
    }
}
