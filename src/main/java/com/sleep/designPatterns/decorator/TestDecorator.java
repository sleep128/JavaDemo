package com.sleep.designPatterns.decorator;

/**
 * 测试装饰器
 * @author
 */
public class TestDecorator {
    public static void main(String[] args) {
        Beverage beverage = new Esoresso();
        System.out.println(beverage.getDescription()+beverage.cost());
        //装饰
        Beverage mocha = new Mocha(beverage);
        System.out.println(mocha.getDescription()+mocha.cost());
        //再次装饰
        mocha = new Mocha(mocha);
        System.out.println(mocha.getDescription()+mocha.cost());
//        浓缩咖啡1.99
//        浓缩咖啡,Mocha2.19
//        浓缩咖啡,Mocha,Mocha2.39

    }
}
