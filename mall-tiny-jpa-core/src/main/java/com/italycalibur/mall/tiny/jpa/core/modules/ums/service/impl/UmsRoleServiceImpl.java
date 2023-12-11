package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsRoleService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRole;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台角色管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Override
    public boolean create(UmsRole role) {
        return false;
    }

    @Override
    public boolean delete(List<Long> ids) {
        return false;
    }

    @Override
    public Page<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return null;
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return null;
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return null;
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        return 0;
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        return 0;
    }

}
