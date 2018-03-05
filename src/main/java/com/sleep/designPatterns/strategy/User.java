package com.sleep.designPatterns.strategy;

public class User {
    //默认按照原始用户计费
    private CalculatePrice calculate = new OriginUser();
    //总消费
    Double totalAmount = 0d;
    //单次消费金额
    Double amount = 0d;
    public void buy(Double amount){
        this.amount = amount;
        totalAmount+=amount;
        if(totalAmount>3000){
            calculate = new Vip2User();
        }else if(totalAmount>2000){
            calculate = new Vip1User();
        }
    }

    //计算出用户最终要付的钱
    public Double exactPrice(){
        return calculate.calculatePrice(amount);
    }
}
