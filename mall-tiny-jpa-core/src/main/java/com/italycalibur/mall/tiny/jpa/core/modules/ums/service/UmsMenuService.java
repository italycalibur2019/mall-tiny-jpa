package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;


import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsMenuNode;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 后台菜单服务层
 * @author italycalibur
 * @since 2023/12/11
 */
public interface UmsMenuService {

    /**
     * 创建后台菜单
     */
    boolean create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     */
    boolean update(Long id, UmsMenu umsMenu);

    /**
     * 分页查询后台菜单
     */
    Page<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    boolean updateHidden(Long id, Integer hidden);

}
