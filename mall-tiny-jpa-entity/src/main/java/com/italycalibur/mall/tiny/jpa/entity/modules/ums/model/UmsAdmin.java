package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import com.italycalibur.mall.tiny.jpa.entity.domain.AbstractBaseEntity;

@Getter
@Setter
@Entity
@Table(name = "ums_admin", schema = "public")
@Schema(name = "后台用户表")
public class UmsAdmin extends AbstractBaseEntity {

    /**
     * 用户名.
     */
    @Column(name = "username")
    @Schema(name = "用户名")
    private String username;

    /**
     * 密码.
     */
    @Column(name = "password")
    @Schema(name = "密码")
    private String password;
}
