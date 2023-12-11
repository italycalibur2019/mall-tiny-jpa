package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;

import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdminRoleRelation;

import java.util.List;

/**
 * 后台用户角色关系服务层
 * @author italycalibur
 * @since 2023/12/11
 */
public interface UmsAdminRoleRelationService {

    boolean remove(UmsAdminRoleRelation adminRoleRelation);

    boolean remove(List<UmsAdminRoleRelation> relations);

    void saveAll(List<UmsAdminRoleRelation> list);

}
