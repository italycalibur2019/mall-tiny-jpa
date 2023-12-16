package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台菜单实体
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_menu", schema = "public")
@Schema(description = "后台菜单表")
public class UmsMenu extends BaseJpaEntity {

    /**
     * 父级id.
     */
    @Column(name = "parent_id")
    @Schema(description = "父级id")
    private Long parentId;

    /**
     * 菜单名称.
     */
    @Column(name = "title")
    @Schema(description = "菜单名称")
    private String title;

    /**
     * 菜单级数.
     */
    @Column(name = "level")
    @Schema(description = "菜单级数")
    private Integer level;

    /**
     * 菜单排序.
     */
    @Column(name = "sort")
    @Schema(description = "菜单排序")
    private Integer sort;

    /**
     * 前端名称.
     */
    @Column(name = "name")
    @Schema(description = "前端名称")
    private String name;

    /**
     * 前端图标.
     */
    @Column(name = "icon")
    @Schema(description = "前端图标")
    private String icon;

    /**
     * 是否隐藏：0->隐藏；1->显示.
     */
    @Column(name = "hidden")
    @Schema(description = "是否隐藏：0->隐藏；1->显示")
    private Integer hidden;

}
