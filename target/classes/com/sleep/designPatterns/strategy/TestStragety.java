package com.sleep.designPatterns.strategy;

/**
 * 策略模式测试
 */
public class TestStragety {
    public static void main(String[] args) {
        User user = new User();
        user.buy(1000d);
        System.out.println("您需要付款："+user.exactPrice());
        user.buy(1000d);
        System.out.println("您需要付款："+user.exactPrice());
        user.buy(1000d);
        System.out.println("您需要付款："+user.exactPrice());
        user.buy(1000d);
        System.out.println("您需要付款："+user.exactPrice());
    }
}
