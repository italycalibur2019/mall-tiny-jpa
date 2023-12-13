package com.italycalibur.mall.tiny.jpa.core.modules.ums.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.italycalibur.mall.tiny.jpa.common.api.CommonResult;
import com.italycalibur.mall.tiny.jpa.common.api.PageData;
import com.italycalibur.mall.tiny.jpa.common.api.PageQueryParam;
import com.italycalibur.mall.tiny.jpa.common.utils.PageUtil;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsMenuNode;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsMenuService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台菜单控制层
 * @author italycalibur
 * @since 2023/12/13
 */
@Controller
@Tag(name = "UmsMenuController",description = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {

    @Resource
    private UmsMenuService menuService;

    @Operation(summary = "添加后台菜单")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<?> create(@RequestBody UmsMenu umsMenu) {
        boolean success = menuService.create(umsMenu);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "修改后台菜单")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult<?> update(@PathVariable Long id,
                               @RequestBody UmsMenu umsMenu) {
        boolean success = menuService.update(id, umsMenu);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "根据ID获取菜单详情")
    @ApiOperationSupport(order = 3)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public CommonResult<UmsMenu> getItem(@PathVariable Long id) {
        UmsMenu umsMenu = menuService.getMenuById(id);
        return CommonResult.success(umsMenu);
    }

    @Operation(summary = "根据ID删除后台菜单")
    @ApiOperationSupport(order = 4)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult<?> delete(@PathVariable Long id) {
        boolean success = menuService.removeMenuById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "分页查询后台菜单")
    @ApiOperationSupport(order = 5)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageData<UmsMenu> list(@RequestBody PageQueryParam<Long> queryParam) {
        Long parentId = queryParam.getParams();
        Page<UmsMenu> page = menuService.list(parentId, queryParam.pageable());
        return PageUtil.build(page);
    }

    @Operation(summary = "树形结构返回所有菜单列表")
    @ApiOperationSupport(order = 6)
    @RequestMapping(value = "/treeList", method = RequestMethod.POST)
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = menuService.treeList();
        return CommonResult.success(list);
    }

    @Operation(summary = "修改菜单显示状态")
    @ApiOperationSupport(order = 7)
    @RequestMapping(value = "/updateHidden/{id}", method = RequestMethod.POST)
    public CommonResult<?> updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        boolean success = menuService.updateHidden(id, hidden);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
