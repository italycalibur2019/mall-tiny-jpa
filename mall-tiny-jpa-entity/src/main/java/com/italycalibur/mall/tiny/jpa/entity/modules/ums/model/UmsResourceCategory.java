package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台资源分类实体
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_resource_category", schema = "public")
@Schema(description="资源分类表")
public class UmsResourceCategory extends BaseEntity {

    /**
     * 分类名称.
     */
    @Column(name = "name")
    @Schema(description = "分类名称")
    private String name;

    /**
     * 排序.
     */
    @Column(name = "sort")
    @Schema(description = "排序")
    private Integer sort;

}
