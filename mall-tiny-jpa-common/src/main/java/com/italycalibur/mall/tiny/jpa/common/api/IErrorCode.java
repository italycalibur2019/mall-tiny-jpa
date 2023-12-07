package com.italycalibur.mall.tiny.jpa.common.api;

/**
 * 封装API的错误码
 * @author italycalibur
 * @since 2023/12/7
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
