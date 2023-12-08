package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.common.exception.Asserts;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import jakarta.annotation.Resource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 后台用户服务实现层
 * @author italycalibur
 * @since 2023/12/7
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminRepository adminRepository;

    @Override
    public String login(UmsAdminLoginParams params) {
        UmsAdmin admin = adminRepository.findOneByUsername(params.getUsername());
        if (admin == null) {
            Asserts.fail("您输入的用户名【" + params.getUsername() + "】不存在，请先注册！");
        }
        if(!params.getPassword().equals(admin.getPassword())) {
            Asserts.fail("您输入的密码不正确，请重新输入！");
        }
        return "登录成功！";
    }

    @Override
    public String register(UmsAdminRegisterParams params) {
        UmsAdmin umsAdmin = adminRepository.findOneByUsername(params.getUsername());
        if (umsAdmin != null) {
            Asserts.fail("用户名【" + params.getUsername() + "】已存在，请重新输入！");
        }
        if (!params.getConfirmPassword().equals(params.getPassword())) {
            Asserts.fail("两次输入的密码不一致！");
        }
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername(params.getUsername());
        admin.setPassword(params.getPassword());
        admin.setCreateTime(new Date());
        admin.setCreateBy(-1L);
        adminRepository.save(admin);
        return "注册成功！";
    }

    @Override
    public Page<UmsAdmin> list(String keyword, Pageable pageable) {
        return adminRepository.findAllByUsernameLikeOrNickNameLike
                ("%"+keyword+"%", "%"+keyword+"%", pageable);
    }

}
