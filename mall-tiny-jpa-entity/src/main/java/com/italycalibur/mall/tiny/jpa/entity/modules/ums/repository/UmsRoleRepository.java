package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRole;
import org.springframework.stereotype.Repository;

/**
 * 后台用户角色持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsRoleRepository extends BaseJpaRepository<UmsRole, Long> {

}
