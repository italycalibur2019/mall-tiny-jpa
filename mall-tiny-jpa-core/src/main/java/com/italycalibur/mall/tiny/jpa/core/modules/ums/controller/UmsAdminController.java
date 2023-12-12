package com.italycalibur.mall.tiny.jpa.core.modules.ums.controller;

import cn.hutool.core.collection.CollUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.italycalibur.mall.tiny.jpa.common.api.CommonResult;
import com.italycalibur.mall.tiny.jpa.common.api.PageData;
import com.italycalibur.mall.tiny.jpa.common.api.PageQueryParam;
import com.italycalibur.mall.tiny.jpa.common.utils.PageUtil;
import com.italycalibur.mall.tiny.jpa.common.exception.ApiException;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminUpdatePasswordParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsRoleService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台用户控制层
 * @author italycalibur
 * @since 2023/12/7
 */
@RestController
@Tag(name = "后台用户控制层")
@RequestMapping("/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private UmsAdminService adminService;
    @Resource
    private UmsRoleService roleService;

    @Operation(summary = "用户登录")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private CommonResult<?> login(@RequestBody UmsAdminLoginParams params) {
        try {
            String token = adminService.login(params);
            if (token == null) {
                return CommonResult.validateFailed();
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("token", token);
                map.put("tokenHead", tokenHead);
                return CommonResult.success(map);
            }
        } catch (ApiException e){
            return CommonResult.failed("登录失败，原因：" + e.getMessage());
        }
    }

    @Operation(summary = "用户注册")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private CommonResult<?> register(@RequestBody UmsAdminRegisterParams params) {
        try {
            return CommonResult.success(null, adminService.register(params));
        } catch (ApiException e) {
            return CommonResult.failed("注册失败，原因：" + e.getMessage());
        }
    }

    @Operation(summary = "查询用户")
    @ApiOperationSupport(order = 3)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageData<UmsAdmin> list(@RequestBody PageQueryParam<String> queryParam) {
        String keyWord = queryParam.getParams();
        Page<UmsAdmin> page = adminService.list(keyWord, queryParam.pageable());
        return PageUtil.build(page);
    }

    @Operation(summary = "刷新Token")
    @ApiOperationSupport(order = 4)
    @RequestMapping(value = "refreshToken", method = RequestMethod.POST)
    public CommonResult<?> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @Operation(summary = "获取当前登录用户信息")
    @ApiOperationSupport(order = 5)
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public CommonResult<?> getAdminInfo(Principal principal) {
        if(principal == null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuListByAdminId(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream()
                    .map(UmsRole::getName)
                    .collect(Collectors.toList());
            data.put("roles",roles);
        }
        return CommonResult.success(data);
    }

    @Operation(summary = "登出功能")
    @ApiOperationSupport(order = 6)
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResult<?> logout() {
        return CommonResult.success(null, "登出成功！");
    }

    @Operation(summary = "获取指定用户信息")
    @ApiOperationSupport(order = 7)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getAdminById(id);
        if (admin != null) {
            return CommonResult.success(admin);
        } else {
            return CommonResult.validateFailed("找不到指定用户");
        }
    }

    @Operation(summary = "修改指定用户信息")
    @ApiOperationSupport(order = 8)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult<?> update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        boolean success = adminService.update(id, admin);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "修改指定用户密码")
    @ApiOperationSupport(order = 9)
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public CommonResult<?> updatePassword(@Validated @RequestBody UmsAdminUpdatePasswordParams params) {
        int status = adminService.updatePassword(params);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "删除指定用户信息")
    @ApiOperationSupport(order = 10)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult<?> delete(@PathVariable Long id) {
        boolean success = adminService.delete(id);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "修改帐号状态")
    @ApiOperationSupport(order = 11)
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    public CommonResult<?> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        boolean success = adminService.update(id,umsAdmin);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "给用户分配角色")
    @ApiOperationSupport(order = 12)
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public CommonResult<?> updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "获取指定用户的角色")
    @ApiOperationSupport(order = 13)
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.POST)
    public List<UmsRole> getRoleList(@PathVariable Long adminId) {
        return adminService.getRoleList(adminId);
    }

}
