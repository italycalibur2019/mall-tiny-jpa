package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRoleMenuRelation;
import org.springframework.stereotype.Repository;

/**
 * 后台角色菜单关系持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsRoleMenuRelationRepository extends BaseJpaRepository<UmsRoleMenuRelation, Long> {

}
