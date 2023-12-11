package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;


import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsMenuNode;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsMenuService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台菜单管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {

    @Override
    public boolean create(UmsMenu umsMenu) {
        return false;
    }

    @Override
    public boolean update(Long id, UmsMenu umsMenu) {
        return false;
    }

    @Override
    public Page<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<UmsMenuNode> treeList() {
        return null;
    }

    @Override
    public boolean updateHidden(Long id, Integer hidden) {
        return false;
    }

}
