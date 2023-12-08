package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 后台用户服务层
 * @author italycalibur
 * @since 2023/12/7
 */
public interface UmsAdminService {

    /**
     * 后台用户登录
     */
    String login(UmsAdminLoginParams params);

    /**
     * 后台用户注册
     */
    String register(UmsAdminRegisterParams params);

    /**
     * 根据用户名或昵称分页查询后台用户
     */
    Page<UmsAdmin> list(String keyword, Pageable pageable);
}
