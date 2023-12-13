package com.italycalibur.mall.tiny.jpa.core.modules.ums.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 模糊查询后台资源参数
 * @author italycalibur
 * @since 2023/12/13
 */
@Data
@Schema(description = "模糊查询后台资源参数")
public class UmsResourceCategoryQueryParams {

    @Schema(name = "categoryId", description = "分类id")
    private Long categoryId;

    @Schema(name = "name", description = "资源名称")
    private String name;

    @Schema(name = "url", description = "资源路径")
    private String url;
}
