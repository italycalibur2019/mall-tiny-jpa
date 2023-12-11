package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;

import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResourceCategory;

import java.util.List;

/**
 * 后台资源分类服务层
 * @author italycalibur
 * @since 2023/12/11
 */
public interface UmsResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    boolean create(UmsResourceCategory umsResourceCategory);

}
