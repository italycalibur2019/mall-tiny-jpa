package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import com.italycalibur.mall.tiny.jpa.entity.domain.AbstractBaseEntity;

/**
 * 后台用户实体
 * @author italycalibur
 * @since 2023/12/7
 */
@Getter
@Setter
@Entity
@Table(name = "ums_admin", schema = "public")
@Schema(description = "后台用户表")
public class UmsAdmin extends AbstractBaseEntity {

    /**
     * 用户名.
     */
    @Column(name = "username")
    @Schema(name = "username", description = "用户名")
    private String username;

    /**
     * 密码.
     */
    @Column(name = "password")
    @Schema(name = "password", description = "密码")
    private String password;

    /**
     * 昵称.
     */
    @Column(name = "nick_name")
    @Schema(name = "nickName", description = "昵称")
    private String nickName;

    /**
     * 头像.
     */
    @Column(name = "icon")
    @Schema(name = "icon", description = "头像")
    private String icon;

    /**
     * 邮箱.
     */
    @Column(name = "email")
    @Schema(name = "email", description = "邮箱")
    private String email;

    /**
     * 账号启用状态：0->禁用；1->启用.
     */
    @Column(name = "status")
    @Schema(name = "status", description = "账号启用状态：0->禁用；1->启用")
    private Integer status;

    /**
     * 备注信息.
     */
    @Column(name = "remark")
    @Schema(name = "remark", description = "备注信息")
    private String remark;

}
