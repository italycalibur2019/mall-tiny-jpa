package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;

import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台角色服务层
 * @author italycalibur
 * @since 2023/12/11
 */
public interface UmsRoleService {

    /**
     * 添加角色
     */
    boolean create(UmsRole role);

    /**
     * 批量删除角色
     */
    boolean delete(List<Long> ids);

    /**
     * 分页获取角色列表
     */
    Page<UmsRole> list(String keyword, Pageable pageable);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuListByAdminId(Long adminId);

    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> getMenuListByRoleId(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);

}
