package com.sleep.tips.enumDemo;

import java.math.BigDecimal;
import java.time.Year;

/**
 * @description: 枚举抽象方法
 * @author: SleepSleep
 * @create: 2018/6/26
 **/
public enum Operation {
    PLUS {
        @Override
        BigDecimal calculate(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },

    MINUS {
        @Override
        BigDecimal calculate(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    },
    MULTIPLY {
        @Override
        BigDecimal calculate(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE {
        @Override
        BigDecimal calculate(BigDecimal x, BigDecimal y) {
            return x.divide(y);
        }
    };

    abstract BigDecimal calculate(BigDecimal x, BigDecimal y);
}
