package com.sleep.designPatterns.strategy;

/**
 * 价格计算上层接口
 */
public interface CalculatePrice {
    /**
     * 根据传入的价格返回一个优惠价
     * @param price
     * @return
     */
    Double calculatePrice(Double price);
}
