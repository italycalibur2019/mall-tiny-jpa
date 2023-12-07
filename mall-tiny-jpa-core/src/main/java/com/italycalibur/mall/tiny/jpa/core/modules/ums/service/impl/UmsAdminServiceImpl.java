package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import jakarta.annotation.Resource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminRepository adminRepository;

    @Override
    public boolean login(UmsAdminLoginParams params) {
        UmsAdmin admin = adminRepository.findOneByUsername(params.getUsername());
        if (admin == null) {
            return false;
        }
        return params.getPassword().equals(admin.getPassword());
    }

    @Override
    public boolean register(UmsAdminRegisterParams params) {
        if (!params.getConfirmPassword().equals(params.getPassword())) {
            return false;
        }
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername(params.getUsername());
        admin.setPassword(params.getPassword());
        admin.setCreateTime(new Date());
        admin.setCreateBy(-1L);
        adminRepository.save(admin);
        return true;
    }
}
