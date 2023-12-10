package com.italycalibur.mall.tiny.jpa.core.modules.ums.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 后台用户注册信息参数
 * @author italycalibur
 * @since 2023/12/7
 */
@Data
@Schema(description = "后台用户注册信息")
public class UmsAdminRegisterParams {

    @NotEmpty
    @Schema(name = "username", description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @NotEmpty
    @Schema(name = "password", description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @NotEmpty
    @Schema(name = "confirmPassword", description = "确认密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String confirmPassword;

    @Schema(name = "icon", description = "头像")
    private String icon;

    @Schema(name = "nickName", description = "昵称")
    private String nickName;

    @Email
    @Schema(name = "email", description = "邮箱")
    private String email;

    @Schema(name = "remark", description = "备注信息")
    private String remark;

}
