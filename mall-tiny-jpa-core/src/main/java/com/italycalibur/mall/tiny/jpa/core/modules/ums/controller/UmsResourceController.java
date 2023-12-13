package com.italycalibur.mall.tiny.jpa.core.modules.ums.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.italycalibur.mall.tiny.jpa.common.api.CommonResult;
import com.italycalibur.mall.tiny.jpa.common.api.PageData;
import com.italycalibur.mall.tiny.jpa.common.api.PageQueryParam;
import com.italycalibur.mall.tiny.jpa.common.utils.PageUtil;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsResourceCategoryQueryParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.security.component.DynamicSecurityMetadataSource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源控制层
 * @author italycalibur
 * @since 2023/12/13
 */
@Controller
@Tag(name = "UmsResourceController",description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {

    @Resource
    private UmsResourceService resourceService;
    @Resource
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @Operation(summary = "添加后台资源")
    @ApiOperationSupport(order = 1)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<?> create(@RequestBody UmsResource umsResource) {
        boolean success = resourceService.create(umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "修改后台资源")
    @ApiOperationSupport(order = 2)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult<?> update(@PathVariable Long id,
                               @RequestBody UmsResource umsResource) {
        boolean success = resourceService.update(id, umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "根据ID获取资源详情")
    @ApiOperationSupport(order = 3)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public CommonResult<UmsResource> getItem(@PathVariable Long id) {
        UmsResource umsResource = resourceService.getResourceById(id);
        return CommonResult.success(umsResource);
    }

    @Operation(summary = "根据ID删除后台资源")
    @ApiOperationSupport(order = 4)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult<?> delete(@PathVariable Long id) {
        boolean success = resourceService.delete(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "分页模糊查询后台资源")
    @ApiOperationSupport(order = 5)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageData<UmsResource> list(@RequestBody PageQueryParam<UmsResourceCategoryQueryParams> queryParam) {
        UmsResourceCategoryQueryParams params = queryParam.getParams();
        Page<UmsResource> page = resourceService.list(params.getCategoryId(), params.getName(), params.getUrl(), queryParam.pageable());
        return PageUtil.build(page);
    }

    @Operation(summary = "查询所有后台资源")
    @ApiOperationSupport(order = 6)
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public CommonResult<List<UmsResource>> listAll() {
        List<UmsResource> resourceList = resourceService.list();
        return CommonResult.success(resourceList);
    }

}
