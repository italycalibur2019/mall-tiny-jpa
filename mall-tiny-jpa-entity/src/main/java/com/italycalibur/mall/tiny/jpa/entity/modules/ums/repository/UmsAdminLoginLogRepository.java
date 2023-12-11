package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdminLoginLog;
import org.springframework.stereotype.Repository;

/**
 * 后台用户登录日志持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsAdminLoginLogRepository extends BaseJpaRepository<UmsAdminLoginLog, Long> {

}
