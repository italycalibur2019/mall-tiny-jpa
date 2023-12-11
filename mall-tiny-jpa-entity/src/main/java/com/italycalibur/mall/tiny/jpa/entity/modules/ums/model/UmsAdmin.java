package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import com.italycalibur.mall.tiny.jpa.entity.domain.BaseEntity;

import java.util.Date;

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
public class UmsAdmin extends BaseEntity {

    /**
     * 用户名.
     */
    @Column(name = "username")
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码.
     */
    @Column(name = "password")
    @Schema(description = "密码")
    private String password;

    /**
     * 昵称.
     */
    @Column(name = "nick_name")
    @Schema(description = "昵称")
    private String nickName;

    /**
     * 头像.
     */
    @Column(name = "icon")
    @Schema(description = "头像")
    private String icon;

    /**
     * 邮箱.
     */
    @Column(name = "email")
    @Schema(description = "邮箱")
    private String email;

    /**
     * 账号启用状态：0->禁用；1->启用.
     */
    @Column(name = "status")
    @Schema(description = "账号启用状态：0->禁用；1->启用")
    private Integer status;

    /**
     * 备注信息.
     */
    @Column(name = "remark")
    @Schema(description = "备注信息")
    private String remark;

    /**
     * 最后登录时间.
     */
    @Column(name = "last_login_time")
    @Schema(description = "最后登录时间")
    private Date lastLoginTime;

}
