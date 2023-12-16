package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台用户角色实体
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_role", schema = "public")
@Schema(description="后台用户角色表")
public class UmsRole extends BaseJpaEntity {

    /**
     * 角色名称.
     */
    @Column(name = "name")
    @Schema(description = "角色名称")
    private String name;

    /**
     * 角色描述.
     */
    @Column(name = "description")
    @Schema(description = "角色描述")
    private String description;

    /**
     * 后台用户数量.
     */
    @Column(name = "admin_count")
    @Schema(description = "后台用户数量")
    private Integer adminCount;

    /**
     * 启用状态：0->禁用；1->启用.
     */
    @Column(name = "status")
    @Schema(description = "启用状态：0->禁用；1->启用")
    private Integer status;

    /**
     * 排序.
     */
    @Column(name = "sort")
    @Schema(description = "排序")
    private Integer sort;

}
