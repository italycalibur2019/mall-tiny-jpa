package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * 后台菜单表 Mapper 接口
 * @author italycalibur
 * @since 2023/12/11
 */
@Repository
public interface UmsMenuRepository extends BaseJpaRepository<UmsMenu, Long> {

    /**
     * 分页查询指定父菜单下的所有子菜单
     */
    Page<UmsMenu> findAllByParentId(Long parentId, Pageable pageable);

}
