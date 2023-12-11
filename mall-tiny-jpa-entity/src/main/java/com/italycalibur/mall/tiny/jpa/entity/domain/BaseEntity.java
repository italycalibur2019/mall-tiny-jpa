package com.italycalibur.mall.tiny.jpa.entity.domain;

import com.italycalibur.mall.tiny.jpa.entity.generator.SnowflakeGenerator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基础类
 * @author italycalibur
 * @since 2023/12/7
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snowflakeGenerator")
    @GenericGenerator(name = "snowflakeGenerator", type = SnowflakeGenerator.class)
    @Schema(name = "id", description = "主键id")
    private Long id;

    /**
     * 创建时间.
     */
    @CreatedDate
    @Column(name = "create_time", nullable = false, updatable = false)
    @Schema(name = "createTime", description = "创建时间")
    private Date createTime;

    /**
     * 创建人.
     */
    @CreatedBy
    @Column(name = "create_by", nullable = false, updatable = false)
    @Schema(name = "createBy", description = "创建人")
    private Long createBy;

    /**
     * 修改时间.
     */
    @LastModifiedDate
    @Column(name = "update_time")
    @Schema(name = "updateTime", description = "修改时间")
    private Date updateTime;

    /**
     * 修改人.
     */
    @LastModifiedBy
    @Column(name = "update_by")
    @Schema(name = "updateBy", description = "修改人")
    private Long updateBy;

}
