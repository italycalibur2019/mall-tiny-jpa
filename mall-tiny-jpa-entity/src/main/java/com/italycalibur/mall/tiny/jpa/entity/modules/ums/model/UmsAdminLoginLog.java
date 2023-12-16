package com.italycalibur.mall.tiny.jpa.entity.modules.ums.model;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台用户登录日志
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
@Entity
@Table(name = "ums_admin_login_log", schema = "public")
@Schema(description = "登录日志表")
public class UmsAdminLoginLog extends BaseJpaEntity {

    /**
     * 用户id.
     */
    @Column(name = "admin_id")
    @Schema(description = "用户id")
    private Long adminId;

    /**
     * IP编号.
     */
    @Column(name = "ip")
    @Schema(description = "IP编号")
    private String ip;

    /**
     * IP所在地址.
     */
    @Column(name = "address")
    @Schema(description = "IP所在地址")
    private String address;

    /**
     * 浏览器登录类型.
     */
    @Column(name = "user_agent")
    @Schema(description = "浏览器登录类型")
    private String userAgent;

}
