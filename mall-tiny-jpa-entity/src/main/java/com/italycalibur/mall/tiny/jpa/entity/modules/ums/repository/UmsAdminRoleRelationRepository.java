package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;


import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdminRoleRelation;
import org.springframework.stereotype.Repository;

/**
 * 后台用户与角色关系持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsAdminRoleRelationRepository extends BaseJpaRepository<UmsAdminRoleRelation, Long> {

}
