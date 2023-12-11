package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResourceCategory;
import org.springframework.stereotype.Repository;

/**
 * 资源分类持久层
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsResourceCategoryRepository extends BaseJpaRepository<UmsResourceCategory, Long> {

}
