package com.italycalibur.mall.tiny.jpa.core.modules.ums.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.italycalibur.mall.tiny.jpa.common.api.CommonResult;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Resource
    private UmsAdminService adminService;

    @Operation(summary = "用户登录")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private CommonResult<?> login(@RequestBody UmsAdminLoginParams params) {
        if (adminService.login(params)) {
            return CommonResult.success(null, "登录成功！");
        } else {
            return CommonResult.failed("登录失败！");
        }
    }

    @Operation(summary = "用户注册")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private CommonResult<?> register(@RequestBody UmsAdminRegisterParams params) {
        if (adminService.register(params)) {
            return CommonResult.success(null, "注册成功！");
        } else {
            return CommonResult.failed("注册失败！");
        }
    }
}
