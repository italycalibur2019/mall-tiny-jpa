package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.italycalibur.mall.tiny.jpa.core.domain.BaseServiceImpl;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsMenuNode;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsMenuService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsMenuRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 后台菜单管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsMenuServiceImpl extends BaseServiceImpl implements UmsMenuService {

    @Resource
    private UmsMenuRepository menuRepository;

    @Override
    public boolean create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        umsMenu.setCreateBy(-1L);
        updateLevel(umsMenu);
        return false;
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            Optional<UmsMenu> parentMenuOptional =
                    menuRepository.findById(umsMenu.getParentId());
            parentMenuOptional.ifPresentOrElse(parentMenu ->
                    umsMenu.setLevel(parentMenu.getLevel() + 1),
                    () -> umsMenu.setLevel(0));
        }
    }

    @Override
    public boolean update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        Optional<UmsMenu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isEmpty()) {
            return false;
        }
        updateLevel(umsMenu);
        menuRepository.save(umsMenu);
        return true;
    }

    @Override
    public Page<UmsMenu> list(Long parentId, Pageable pageable) {
        if (StrUtil.isNotEmpty(Convert.toStr(parentId))) {
            return menuRepository.findAllByParentId(parentId, pageable);
        }
        return null;
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = menuRepository.findAll();
        return menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList))
                .collect(Collectors.toList());
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList))
                .collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    @Override
    public boolean updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        Optional<UmsMenu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isEmpty()) {
            return false;
        }
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        menuRepository.save(umsMenu);
        return true;
    }

    @Override
    public UmsMenu getMenuById(Long id) {
        Optional<UmsMenu> menuOptional = menuRepository.findById(id);
        return menuOptional.orElse(null);
    }

    @Override
    public boolean removeMenuById(Long id) {
        Optional<UmsMenu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isEmpty()) {
            return false;
        }
        menuRepository.delete(menuOptional.get());
        return true;
    }

}
