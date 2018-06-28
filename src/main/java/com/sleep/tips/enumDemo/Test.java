package com.sleep.tips.enumDemo;

import java.math.BigDecimal;

/**
 * @description:
 * @author: SleepSleep
 * @create: 2018/6/26
 **/
public class Test {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal(1);
        BigDecimal y = new BigDecimal(2);
        for (Operation operation : Operation.values()) {
            System.out.println(operation.calculate(x, y));
        }
    }
}
