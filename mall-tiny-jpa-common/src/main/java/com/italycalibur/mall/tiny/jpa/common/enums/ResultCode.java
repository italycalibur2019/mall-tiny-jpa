package com.italycalibur.mall.tiny.jpa.common.enums;

import com.italycalibur.mall.tiny.jpa.common.api.IErrorCode;
import lombok.Getter;

/**
 * 常用API操作码枚举类
 * @author italycalibur
 * @since 2023/12/7
 */
@Getter
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    /**
     * 响应代码.
     */
    private final long code;

    /**
     * 响应信息.
     */
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
