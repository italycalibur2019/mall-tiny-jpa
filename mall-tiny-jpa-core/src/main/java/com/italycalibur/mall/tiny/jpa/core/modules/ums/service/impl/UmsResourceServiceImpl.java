package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 后台资源管理Service实现类
 * Created by macro on 2020/2/2.
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Override
    public boolean create(UmsResource umsResource) {
        return false;
    }

    @Override
    public boolean update(Long id, UmsResource umsResource) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Page<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        return null;
    }

}
