package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import com.italycalibur.mall.tiny.jpa.common.exception.Asserts;
import com.italycalibur.mall.tiny.jpa.core.domain.BaseServiceImpl;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminUpdatePasswordParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminCacheService;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsRole;
import jakarta.annotation.Resource;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsAdmin;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台用户服务实现层
 * @author italycalibur
 * @since 2023/12/7
 */
@Service
public class UmsAdminServiceImpl extends BaseServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminRepository adminRepository;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

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
        BeanUtils.copyProperties(params, admin);
        admin.setCreateTime(new Date());
        admin.setCreateBy(-1L);
        admin.setStatus(1);
        adminRepository.save(admin);
        return "注册成功！";
    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }

    @Override
    public Page<UmsAdmin> list(String keyword, Pageable pageable) {
        return adminRepository.findAllByUsernameLikeOrNickNameLike
                ("%"+keyword+"%", "%"+keyword+"%", pageable);
    }

    @Override
    public boolean update(Long id, UmsAdmin admin) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return null;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return null;
    }

    @Override
    public int updatePassword(UmsAdminUpdatePasswordParams params) {
        return 0;
    }

    @Override
    public UmsAdminCacheService getCacheService() {
        return null;
    }

}
