package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台角色菜单关系
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_role_menu_relation", schema = "public")
@Schema(description="后台角色菜单关系表")
public class UmsRoleMenuRelation extends BaseJpaEntity {

    /**
     * 角色ID.
     */
    @Column(name = "role_id")
    @Schema(description = "角色ID")
    private Long roleId;

    /**
     * 菜单ID.
     */
    @Column(name = "menu_id")
    @Schema(description = "菜单ID")
    private Long menuId;

}
