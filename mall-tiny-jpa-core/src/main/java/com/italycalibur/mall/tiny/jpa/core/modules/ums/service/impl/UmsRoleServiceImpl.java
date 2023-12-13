package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.italycalibur.mall.tiny.jpa.common.utils.CommonUtil;
import com.italycalibur.mall.tiny.jpa.core.domain.BaseServiceImpl;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminCacheService;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsRoleService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.*;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.*;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 后台角色管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsRoleServiceImpl extends BaseServiceImpl implements UmsRoleService {

    @Resource
    private UmsAdminCacheService adminCacheService;
    @Resource
    private UmsRoleMenuRelationRepository roleMenuRelationRepository;
    @Resource
    private UmsRoleResourceRelationRepository roleResourceRelationRepository;
    @Resource
    private UmsRoleRepository roleRepository;

    @Override
    public boolean create(UmsRole role) {
        if (role == null) {
            return false;
        }
        role.setCreateTime(new Date());
        role.setCreateBy(-1L);
        role.setAdminCount(0);
        role.setSort(0);
        roleRepository.save(role);
        return true;
    }

    @Override
    public boolean delete(List<Long> ids) {
        QUmsRole qUmsRole = QUmsRole.umsRole;
        List<UmsRole> roleList = getQueryFactory()
                .selectFrom(qUmsRole)
                .where(qUmsRole.id.in(ids))
                .fetch();
        if (CollUtil.isEmpty(roleList)) {
            return false;
        }
        roleRepository.deleteAll(roleList);
        adminCacheService.delResourceListByRoleIds(ids);
        return true;
    }

    @Override
    public Page<UmsRole> list(String keyword, Pageable pageable) {
        QUmsRole qUmsRole = QUmsRole.umsRole;
        JPAQuery<UmsRole> query = getQueryFactory().selectFrom(qUmsRole);
        if(StrUtil.isNotEmpty(keyword)){
            query.where(qUmsRole.name.eq(keyword));
        }
        List<UmsRole> roleList = query.fetch();
        if (CollUtil.isNotEmpty(roleList)) {
            return CommonUtil.listToPage(roleList, pageable);
        }
        return null;
    }

    @Override
    public List<UmsMenu> getMenuListByAdminId(Long adminId) {
        QUmsMenu qUmsMenu = QUmsMenu.umsMenu;
        QUmsRoleMenuRelation qUmsRoleMenuRelation = QUmsRoleMenuRelation.umsRoleMenuRelation;
        QUmsAdminRoleRelation qUmsAdminRoleRelation = QUmsAdminRoleRelation.umsAdminRoleRelation;
        QUmsAdmin qUmsAdmin = QUmsAdmin.umsAdmin;
        return getQueryFactory()
                .selectFrom(qUmsMenu)
                .leftJoin(qUmsRoleMenuRelation).on(qUmsRoleMenuRelation.menuId.eq(qUmsMenu.id))
                .leftJoin(qUmsAdminRoleRelation).on(qUmsAdminRoleRelation.roleId.eq(qUmsRoleMenuRelation.roleId))
                .leftJoin(qUmsAdmin).on(qUmsAdmin.id.eq(qUmsAdminRoleRelation.adminId))
                .where(qUmsAdmin.id.eq(adminId))
                .fetch();
    }

    @Override
    public List<UmsMenu> getMenuListByRoleId(Long roleId) {
        QUmsMenu qUmsMenu = QUmsMenu.umsMenu;
        QUmsRoleMenuRelation qUmsRoleMenuRelation = QUmsRoleMenuRelation.umsRoleMenuRelation;
        QUmsRole qUmsRole = QUmsRole.umsRole;
        return getQueryFactory()
                .selectFrom(qUmsMenu)
                .leftJoin(qUmsRoleMenuRelation).on(qUmsRoleMenuRelation.menuId.eq(qUmsMenu.id))
                .leftJoin(qUmsRole).on(qUmsRole.id.eq(qUmsRoleMenuRelation.roleId))
                .where(qUmsRole.id.eq(roleId))
                .fetch();
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        QUmsResource qUmsResource = QUmsResource.umsResource;
        QUmsRoleResourceRelation qUmsRoleResourceRelation = QUmsRoleResourceRelation.umsRoleResourceRelation;
        QUmsRole qUmsRole = QUmsRole.umsRole;
        return getQueryFactory()
                .selectFrom(qUmsResource)
                .leftJoin(qUmsRoleResourceRelation).on(qUmsRoleResourceRelation.resourceId.eq(qUmsResource.id))
                .leftJoin(qUmsRole).on(qUmsRole.id.eq(qUmsRoleResourceRelation.roleId))
                .where(qUmsRole.id.eq(roleId))
                .fetch();
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        QUmsRoleMenuRelation qUmsRoleMenuRelation = QUmsRoleMenuRelation.umsRoleMenuRelation;
        List<UmsRoleMenuRelation> roleMenuRelationList = getQueryFactory()
                .selectFrom(qUmsRoleMenuRelation)
                .where(qUmsRoleMenuRelation.roleId.eq(roleId))
                .fetch();
        roleMenuRelationRepository.deleteAll(roleMenuRelationList);
        //批量插入新关系
        List<UmsRoleMenuRelation> relationList = new ArrayList<>();
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            relationList.add(relation);
        }
        roleMenuRelationRepository.saveAll(relationList);
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        QUmsRoleResourceRelation qUmsRoleResourceRelation = QUmsRoleResourceRelation.umsRoleResourceRelation;
        List<UmsRoleResourceRelation> roleResourceRelationList = getQueryFactory()
                .selectFrom(qUmsRoleResourceRelation)
                .where(qUmsRoleResourceRelation.roleId.eq(roleId))
                .fetch();
        roleResourceRelationRepository.deleteAll(roleResourceRelationList);
        //批量插入新关系
        List<UmsRoleResourceRelation> relationList = new ArrayList<>();
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            relationList.add(relation);
        }
        roleResourceRelationRepository.saveAll(relationList);
        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }

    @Override
    public boolean updateRoleById(UmsRole role) {
        Optional<UmsRole> roleOptional = roleRepository.findById(role.getId());
        if (roleOptional.isEmpty()) {
            return false;
        }
        roleRepository.save(role);
        return true;
    }

    @Override
    public List<UmsRole> listRole() {
        return roleRepository.findAll();
    }

}
