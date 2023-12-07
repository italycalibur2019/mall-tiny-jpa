package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;

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

}
