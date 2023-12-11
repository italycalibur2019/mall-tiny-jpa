package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台用户与角色关系
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_admin_role_relation", schema = "public")
@Schema(description = "后台用户与角色关系表")
public class UmsAdminRoleRelation extends BaseEntity {

    /**
     * 用户id.
     */
    @Column(name = "admin_id")
    @Schema(description = "用户id")
    private Long adminId;

    /**
     * 角色id.
     */
    @Column(name = "role_id")
    @Schema(description = "角色id")
    private Long roleId;


}
