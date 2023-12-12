package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.italycalibur.mall.tiny.jpa.common.exception.Asserts;
import com.italycalibur.mall.tiny.jpa.core.domain.BaseServiceImpl;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminLoginParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminRegisterParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.dto.UmsAdminUpdatePasswordParams;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminCacheService;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import com.italycalibur.mall.tiny.jpa.entity.domain.AdminUserDetails;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.*;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminLoginLogRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRoleRelationRepository;
import com.italycalibur.mall.tiny.jpa.security.utils.JwtTokenUtil;
import com.italycalibur.mall.tiny.jpa.security.utils.SpringUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 后台用户服务实现层
 * @author italycalibur
 * @since 2023/12/7
 */
@Service
public class UmsAdminServiceImpl extends BaseServiceImpl implements UmsAdminService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UmsAdminRepository adminRepository;
    @Resource
    private UmsAdminLoginLogRepository loginLogRepository;
    @Resource
    private UmsAdminRoleRelationRepository adminRoleRelationRepository;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = getCacheService().getAdmin(username);
        if (admin != null) {
            return admin;
        }
        QUmsAdmin qUmsAdmin = QUmsAdmin.umsAdmin;
        List<UmsAdmin> adminList = getQueryFactory()
                .selectFrom(qUmsAdmin)
                .where(qUmsAdmin.username.eq(username))
                .fetch();
        if (adminList != null && !adminList.isEmpty()) {
            admin = adminList.get(0);
            getCacheService().setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public String login(UmsAdminLoginParams params) {
        String token = null;
        // 密码需要客户端加密后传递
        try {
            UmsAdmin admin = adminRepository.findOneByUsername(params.getUsername());
            if (admin == null) {
                Asserts.fail("您输入的用户名【" + params.getUsername() + "】不存在，请先注册！");
            }
            UserDetails userDetails = loadUserByUsername(params.getUsername());
            if (!passwordEncoder.matches(params.getPassword(), userDetails.getPassword())) {
                Asserts.fail("您输入的密码不正确，请重新输入！");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("该账号已被禁用，请联系管理员");
            }
            UsernamePasswordAuthenticationToken authentication
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            updateLoginTimeByUsername(params.getUsername());
            insertLoginLog(params.getUsername());
        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 添加登录记录
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if (admin == null) {
            return;
        }
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        loginLog.setCreateBy(admin.getId());
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            loginLog.setIp(request.getRemoteAddr());
            loginLog.setAddress("从网上调用相应接口填充");
            loginLogRepository.save(loginLog);
        }
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        QUmsAdmin qUmsAdmin = QUmsAdmin.umsAdmin;
        UmsAdmin admin = getQueryFactory()
                .selectFrom(qUmsAdmin)
                .where(qUmsAdmin.username.eq(username))
                .fetchFirst();
        admin.setLastLoginTime(new Date());
        adminRepository.save(admin);
    }

    @Override
    public String register(UmsAdminRegisterParams params) {
        // 先检测两次输入的密码是否一致
        if (!params.getConfirmPassword().equals(params.getPassword())) {
            Asserts.fail("两次输入的密码不一致，请重新输入！");
        }
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(params, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setCreateBy(-1L);
        umsAdmin.setStatus(1);
        // 查询是否有相同用户名的用户
        UmsAdmin admin = adminRepository.findOneByUsername(params.getUsername());
        if (admin != null) {
            Asserts.fail("用户名【" + params.getUsername() + "】已存在，请重新输入用户名！");
        }
        // 将密码进行加密操作
        String encode = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encode);
        adminRepository.save(umsAdmin);
        return "注册成功！";
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public Page<UmsAdmin> list(String keyword, Pageable pageable) {
        if (StrUtil.isNotEmpty(keyword)) {
            return adminRepository.findAllByUsernameLikeOrNickNameLike
                    ("%"+keyword+"%", "%"+keyword+"%", pageable);
        }
        return null;
    }

    @Override
    public boolean update(Long id, UmsAdmin admin) {
        admin.setId(id);
        Optional<UmsAdmin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isEmpty()) {
            return false;
        }
        UmsAdmin rawAdmin = adminOptional.get();
        if (rawAdmin.getPassword().equals(admin.getPassword())) {
            // 与原加密密码相同的不需要修改
            admin.setPassword(null);
        } else {
            if (StrUtil.isEmpty(admin.getPassword())) {
                admin.setPassword(null);
            } else {
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        adminRepository.save(admin);
        getCacheService().delAdmin(id);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<UmsAdmin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            getCacheService().delAdmin(id);
            adminRepository.delete(adminOptional.get());
            getCacheService().delResourceList(id);
            return true;
        }
        return false;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        // 先删除原来的关系
        QUmsAdminRoleRelation qUmsAdminRoleRelation = QUmsAdminRoleRelation.umsAdminRoleRelation;
        List<UmsAdminRoleRelation> relations = getQueryFactory()
                .selectFrom(qUmsAdminRoleRelation)
                .where(qUmsAdminRoleRelation.adminId.eq(adminId))
                .fetch();
        adminRoleRelationRepository.deleteAll(relations);
        // 建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationRepository.saveAll(list);
        }
        getCacheService().delResourceList(adminId);
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        QUmsRole qUmsRole = QUmsRole.umsRole;
        QUmsAdminRoleRelation qUmsAdminRoleRelation = QUmsAdminRoleRelation.umsAdminRoleRelation;
        return getQueryFactory()
                .selectFrom(qUmsRole)
                .leftJoin(qUmsAdminRoleRelation).on(qUmsAdminRoleRelation.roleId.eq(qUmsRole.id))
                .where(qUmsAdminRoleRelation.adminId.eq(adminId)).fetch();
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = getCacheService().getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }
        QUmsResource qUmsResource = QUmsResource.umsResource;
        QUmsRole qUmsRole = QUmsRole.umsRole;
        QUmsRoleResourceRelation qUmsRoleResourceRelation = QUmsRoleResourceRelation.umsRoleResourceRelation;
        QUmsAdminRoleRelation qUmsAdminRoleRelation = QUmsAdminRoleRelation.umsAdminRoleRelation;
        resourceList =  getQueryFactory()
                .selectFrom(qUmsResource)
                .leftJoin(qUmsRoleResourceRelation).on(qUmsRoleResourceRelation.resourceId.eq(qUmsResource.id))
                .leftJoin(qUmsRole).on(qUmsRole.id.eq(qUmsRoleResourceRelation.roleId))
                .leftJoin(qUmsAdminRoleRelation).on(qUmsAdminRoleRelation.roleId.eq(qUmsRole.id))
                .where(qUmsAdminRoleRelation.adminId.eq(adminId)
                        .and(qUmsResource.id.isNotNull()))
                .groupBy(qUmsResource.id.isNotNull())
                .fetch();
        if (CollUtil.isNotEmpty(resourceList)) {
            getCacheService().setResourceList(adminId, resourceList);
        }
        return resourceList;
    }

    @Override
    public int updatePassword(UmsAdminUpdatePasswordParams params) {
        if (StrUtil.isEmpty(params.getUsername())
                || StrUtil.isEmpty(params.getOldPassword())
                || StrUtil.isEmpty(params.getNewPassword())) {
            return -1;
        }
        QUmsAdmin qUmsAdmin = QUmsAdmin.umsAdmin;
        List<UmsAdmin> adminList = getQueryFactory()
                .selectFrom(qUmsAdmin)
                .where(qUmsAdmin.username.eq(params.getUsername()))
                .fetch();
        if (CollUtil.isEmpty(adminList)) {
            return -2;
        }
        UmsAdmin umsAdmin = adminList.get(0);
        if(!passwordEncoder.matches(params.getOldPassword(),umsAdmin.getPassword())){
            return -3;
        }
        umsAdmin.setPassword(passwordEncoder.encode(params.getNewPassword()));
        adminRepository.save(umsAdmin);
        getCacheService().delAdmin(umsAdmin.getId());
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public UmsAdminCacheService getCacheService() {
        return SpringUtil.getBean(UmsAdminCacheService.class);
    }

}
