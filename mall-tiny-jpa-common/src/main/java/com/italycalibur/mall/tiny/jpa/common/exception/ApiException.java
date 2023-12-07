package com.italycalibur.mall.tiny.jpa.common.exception;

import com.italycalibur.mall.tiny.jpa.common.api.IErrorCode;

/**
 * 自定义API异常
 * @author italycalibur
 * @since 2023/12/7
 */
public class ApiException extends RuntimeException {

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
