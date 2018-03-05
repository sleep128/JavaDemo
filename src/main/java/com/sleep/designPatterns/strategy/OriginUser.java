package com.sleep.designPatterns.strategy;

public class OriginUser implements CalculatePrice {
    /**
     * 根据传入的价格返回一个优惠价
     * 原始用户
     *
     * @param price
     * @return
     */
    @Override
    public Double calculatePrice(Double price) {
        //原始用户不打折
        return price;
    }
}
