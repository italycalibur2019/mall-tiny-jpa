package com.italycalibur.mall.tiny.jpa.common.exception;

import com.italycalibur.mall.tiny.jpa.common.api.IErrorCode;

/**
 * 断言处理类
 * @author italycalibur
 * @since 2023/12/7
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
