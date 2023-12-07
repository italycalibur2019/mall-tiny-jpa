package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminRepository extends JpaRepository<UmsAdmin, Long>, JpaSpecificationExecutor<UmsAdmin> {
    /**
     * 根据用户名查找用户
     */
    UmsAdmin findOneByUsername(String username);
}
