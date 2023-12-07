package com.italycalibur.mall.tiny.jpa.core.modules.ums.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 后台用户注册信息参数
 * @author italycalibur
 * @since 2023/12/7
 */
@Data
@Schema(description = "后台用户注册信息")
public class UmsAdminRegisterParams {

    @Schema(name = "username", description = "用户名")
    private String username;

    @Schema(name = "password", description = "密码")
    private String password;

    @Schema(name = "confirmPassword", description = "确认密码")
    private String confirmPassword;

}
