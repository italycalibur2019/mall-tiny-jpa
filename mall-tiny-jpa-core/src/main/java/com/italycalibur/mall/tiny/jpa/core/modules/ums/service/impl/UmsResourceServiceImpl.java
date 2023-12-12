package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.italycalibur.mall.tiny.jpa.common.utils.CommonUtil;
import com.italycalibur.mall.tiny.jpa.core.domain.BaseServiceImpl;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminCacheService;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.QUmsResource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsResourceRepository;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 后台资源管理Service实现类
 * Created by macro on 2020/2/2.
 */
@Service
public class UmsResourceServiceImpl extends BaseServiceImpl implements UmsResourceService {

    @Resource
    private UmsAdminCacheService adminCacheService;
    @Resource
    private UmsResourceRepository resourceRepository;

    @Override
    public boolean create(UmsResource umsResource) {
        if (umsResource == null) {
            return false;
        }
        umsResource.setCreateTime(new Date());
        umsResource.setCreateBy(-1L);
        resourceRepository.save(umsResource);
        return true;
    }

    @Override
    public boolean update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        Optional<UmsResource> resourceOptional = resourceRepository.findById(id);
        if (resourceOptional.isEmpty()) {
            return false;
        }
        resourceRepository.save(umsResource);
        adminCacheService.delResourceListByResource(id);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<UmsResource> resourceOptional = resourceRepository.findById(id);
        if (resourceOptional.isPresent()) {
            resourceRepository.delete(resourceOptional.get());
            adminCacheService.delResourceListByResource(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<UmsResource> list(Long categoryId, String nameKeyword,
                                  String urlKeyword, Pageable pageable) {
        QUmsResource qUmsResource = QUmsResource.umsResource;
        JPAQuery<UmsResource> query = getQueryFactory().selectFrom(qUmsResource);
        if (StrUtil.isNotEmpty(Convert.toStr(categoryId))) {
            query.where(qUmsResource.categoryId.eq(categoryId));
        }
        if (StrUtil.isNotEmpty(nameKeyword)) {
            query.where(qUmsResource.name.like("%" + nameKeyword + "%"));
        }
        if (StrUtil.isNotEmpty(urlKeyword)) {
            query.where(qUmsResource.url.like("%" + urlKeyword + "%"));
        }
        List<UmsResource> resourceList = query.fetch();
        if (CollUtil.isNotEmpty(resourceList)) {
            return CommonUtil.listToPage(resourceList, pageable);
        }
        return null;
    }

    @Override
    public List<UmsResource> list() {
        return resourceRepository.findAll();
    }

}
