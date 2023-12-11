package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminCacheService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户缓存管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {

    @Override
    public void delAdmin(Long adminId) {

    }

    @Override
    public void delResourceList(Long adminId) {

    }

    @Override
    public void delResourceListByRole(Long roleId) {

    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {

    }

    @Override
    public void delResourceListByResource(Long resourceId) {

    }

    @Override
    public UmsAdmin getAdmin(String username) {
        return null;
    }

    @Override
    public void setAdmin(UmsAdmin admin) {

    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {

    }

}
