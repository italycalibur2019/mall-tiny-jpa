package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;


import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdminRoleRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户与角色关系持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsAdminRoleRelationRepository extends BaseJpaRepository<UmsAdminRoleRelation, Long> {

    /**
     * 根据角色id查询关系
     */
    List<UmsAdminRoleRelation> findAllByRoleId(Long roleId);

    /**
     * 根据用户id查询关系
     */
    List<UmsAdminRoleRelation> findAllByAdminId(Long adminId);

}
