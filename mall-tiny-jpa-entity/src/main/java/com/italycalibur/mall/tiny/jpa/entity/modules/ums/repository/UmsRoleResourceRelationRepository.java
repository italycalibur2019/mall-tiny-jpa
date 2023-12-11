package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRoleResourceRelation;
import org.springframework.stereotype.Repository;

/**
 * 后台角色资源关系持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsRoleResourceRelationRepository extends BaseJpaRepository<UmsRoleResourceRelation, Long> {

}
