package com.italycalibur.mall.tiny.jpa.core.modules.ums.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.italycalibur.mall.tiny.jpa.common.api.CommonResult;
import com.italycalibur.mall.tiny.jpa.common.api.PageData;
import com.italycalibur.mall.tiny.jpa.common.api.PageQueryParam;
import com.italycalibur.mall.tiny.jpa.common.utils.PageUtil;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsRoleService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户角色控制层
 * @author italycalibur
 * @since 2023/12/13
 */
@Controller
@Tag(name = "UmsRoleController",description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Resource
    private UmsRoleService roleService;

    @Operation(summary = "添加角色")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<?> create(@RequestBody UmsRole role) {
        boolean success = roleService.create(role);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "修改角色")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult<?> update(@PathVariable Long id, @RequestBody UmsRole role) {
        role.setId(id);
        boolean success = roleService.updateRoleById(role);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "批量删除角色")
    @ApiOperationSupport(order = 3)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult<?> delete(@RequestParam("ids") List<Long> ids) {
        boolean success = roleService.delete(ids);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }


    @Operation(summary = "获取所有角色")
    @ApiOperationSupport(order = 4)
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.listRole();
        return CommonResult.success(roleList);
    }

    @Operation(summary = "根据角色名称分页获取角色列表")
    @ApiOperationSupport(order = 5)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageData<UmsRole> list(@RequestBody PageQueryParam<String> queryParam) {
        String keyword = queryParam.getParams();
        Page<UmsRole> page = roleService.list(keyword, queryParam.pageable());
        return PageUtil.build(page);
    }

    @Operation(summary = "修改角色状态")
    @ApiOperationSupport(order = 6)
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    public CommonResult<?> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setId(id);
        umsRole.setStatus(status);
        boolean success = roleService.updateRoleById(umsRole);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "获取角色相关菜单")
    @ApiOperationSupport(order = 7)
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.POST)
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> roleList = roleService.getMenuListByRoleId(roleId);
        return CommonResult.success(roleList);
    }

    @Operation(summary = "获取角色相关资源")
    @ApiOperationSupport(order = 8)
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.POST)
    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId) {
        List<UmsResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }

    @Operation(summary = "给角色分配菜单")
    @ApiOperationSupport(order = 9)
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    public CommonResult<?> allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @Operation(summary = "给角色分配资源")
    @ApiOperationSupport(order = 10)
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    public CommonResult<?> allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }

}
