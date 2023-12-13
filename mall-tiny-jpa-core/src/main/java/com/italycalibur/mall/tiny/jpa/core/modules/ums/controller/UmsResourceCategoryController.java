package com.italycalibur.mall.tiny.jpa.core.modules.ums.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.italycalibur.mall.tiny.jpa.common.api.CommonResult;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceCategoryService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResourceCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类控制层
 * @author italycalibur
 * @since 2023/12/13
 */
@Controller
@Tag(name = "UmsResourceCategoryController",description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Resource
    private UmsResourceCategoryService resourceCategoryService;

    @Operation(summary = "查询所有后台资源分类")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.listAll();
        return CommonResult.success(resourceList);
    }

    @Operation(summary = "添加后台资源分类")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<?> create(@RequestBody UmsResourceCategory umsResourceCategory) {
        boolean success = resourceCategoryService.create(umsResourceCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "修改后台资源分类")
    @ApiOperationSupport(order = 3)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult<?> update(@PathVariable Long id,
                               @RequestBody UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        boolean success = resourceCategoryService.updateCategoryById(umsResourceCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "根据ID删除后台资源")
    @ApiOperationSupport(order = 4)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult<?> delete(@PathVariable Long id) {
        boolean success = resourceCategoryService.removeCategoryById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
