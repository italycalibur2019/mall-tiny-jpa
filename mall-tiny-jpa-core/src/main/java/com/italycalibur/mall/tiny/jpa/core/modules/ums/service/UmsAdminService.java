package com.italycalibur.mall.tiny.jpa.core.modules.ums.service;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;

public interface UmsAdminService {
    /**
     * 后台用户登录
     */
    boolean login(UmsAdminLoginParams params);

    /**
     * 后台用户注册
     */
    boolean register(UmsAdminRegisterParams params);
}
