package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台角色资源关系
 * @author italycalibur
 * @since 2023/12/7
 */
@Getter
@Setter
@Entity
@Table(name = "ums_role_resource_relation", schema = "public")
@Schema(description="后台角色资源关系表")
public class UmsRoleResourceRelation extends BaseJpaEntity {

    /**
     * 角色ID.
     */
    @Column(name = "role_id")
    @Schema(title = "角色ID")
    private Long roleId;

    /**
     * 资源ID.
     */
    @Column(name = "resource_id")
    @Schema(title = "资源ID")
    private Long resourceId;

}
