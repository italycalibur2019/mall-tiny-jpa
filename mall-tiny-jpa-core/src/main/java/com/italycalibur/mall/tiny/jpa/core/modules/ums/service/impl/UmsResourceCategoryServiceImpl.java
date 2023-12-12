package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceCategoryService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResourceCategory;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsResourceCategoryRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台资源分类管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {

    @Resource
    private UmsResourceCategoryRepository resourceCategoryRepository;

    @Override
    public List<UmsResourceCategory> listAll() {
        return resourceCategoryRepository.findAll();
    }

    @Override
    public boolean create(UmsResourceCategory umsResourceCategory) {
        if (umsResourceCategory == null) {
            return false;
        }
        umsResourceCategory.setCreateTime(new Date());
        umsResourceCategory.setCreateBy(-1L);
        resourceCategoryRepository.save(umsResourceCategory);
        return true;
    }

}
