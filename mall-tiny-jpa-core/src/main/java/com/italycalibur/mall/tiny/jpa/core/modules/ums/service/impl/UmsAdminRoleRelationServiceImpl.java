package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminRoleRelationService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdminRoleRelation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员角色关系管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsAdminRoleRelationServiceImpl implements UmsAdminRoleRelationService {

    @Override
    public boolean remove(UmsAdminRoleRelation adminRoleRelation) {
        return false;
    }

    @Override
    public boolean remove(List<UmsAdminRoleRelation> relations) {
        return false;
    }

    @Override
    public void saveAll(List<UmsAdminRoleRelation> list) {

    }

}
