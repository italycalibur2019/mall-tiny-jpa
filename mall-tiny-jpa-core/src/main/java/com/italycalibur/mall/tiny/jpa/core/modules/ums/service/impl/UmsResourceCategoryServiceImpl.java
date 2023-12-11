package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceCategoryService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResourceCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台资源分类管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {

    @Override
    public List<UmsResourceCategory> listAll() {
        return null;
    }

    @Override
    public boolean create(UmsResourceCategory umsResourceCategory) {
        return false;
    }

}
