package com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository;

import com.italycalibur.mall.tiny.jpa.entity.domain.BaseJpaRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * 后台用户持久层
 * @author italycalibur
 * @since 2023/12/7
 */
@Repository
public interface UmsAdminRepository extends BaseJpaRepository<UmsAdmin, Long> {
    /**
     * 根据用户名查找用户
     */
    UmsAdmin findOneByUsername(String username);

    /**
     * 根据用户名或者昵称查找用户
     */
    Page<UmsAdmin> findAllByUsernameLikeOrNickNameLike(String username, String nickName, Pageable pageable);
}
