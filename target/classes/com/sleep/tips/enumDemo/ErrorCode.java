package com.sleep.tips.enumDemo;

/**
 * 接口组织枚举的使用
 */
public interface ErrorCode {
    enum BusinessError implements ErrorCode{
        BUSINESS_ERROR_01,
        BUSINESS_ERROR_02;
    }

    enum CommonError implements ErrorCode{
        COMMON_ERROR_01,
        COMMON_ERROR_02;
    }
}
