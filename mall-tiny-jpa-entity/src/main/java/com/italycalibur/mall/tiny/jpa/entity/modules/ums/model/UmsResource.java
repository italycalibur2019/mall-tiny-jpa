package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台资源实体
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_resource", schema = "public")
@Schema(description="后台资源表")
public class UmsResource extends BaseEntity {

    /**
     * 资源名称.
     */
    @Column(name = "name")
    @Schema(description = "资源名称")
    private String name;

    /**
     * 资源URL.
     */
    @Column(name = "url")
    @Schema(description = "资源URL")
    private String url;

    /**
     * 描述.
     */
    @Column(name = "description")
    @Schema(description = "描述")
    private String description;

    /**
     * 资源分类ID.
     */
    @Column(name = "category_id")
    @Schema(description = "资源分类ID")
    private Long categoryId;

}
