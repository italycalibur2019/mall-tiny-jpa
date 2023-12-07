package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 后台用户持久层
 * @author italycalibur
 * @since 2023/12/7
 */
@Repository
public interface UmsAdminRepository extends JpaRepository<UmsAdmin, Long>, JpaSpecificationExecutor<UmsAdmin> {
    /**
     * 根据用户名查找用户
     */
    UmsAdmin findOneByUsername(String username);
}
