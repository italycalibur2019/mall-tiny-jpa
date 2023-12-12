package com.italycalibur.mall.tiny.jpa.core.modules.ums.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.italycalibur.mall.tiny.jpa.common.service.RedisService;
import com.italycalibur.mall.tiny.jpa.common.utils.CommonUtil;
import com.italycalibur.mall.tiny.jpa.core.domain.BaseServiceImpl;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminCacheService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.*;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRepository;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.repository.UmsAdminRoleRelationRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 后台用户缓存管理服务实现层
 * @author italycalibur
 * @since 2023/12/11
 */
@Service
public class UmsAdminCacheServiceImpl extends BaseServiceImpl implements UmsAdminCacheService {

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Resource
    private RedisService redisService;
    @Resource
    private UmsAdminRepository adminRepository;
    @Resource
    private UmsAdminRoleRelationRepository adminRoleRelationRepository;

    @Override
    public void delAdmin(Long adminId) {
        Optional<UmsAdmin> adminOptional = adminRepository.findById(adminId);
        adminOptional.ifPresent(umsAdmin -> {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + umsAdmin.getUsername();
            redisService.del(key);
        });
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        List<UmsAdminRoleRelation> relationList = adminRoleRelationRepository.findAllByRoleId(roleId);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation ->
                    keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }

    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        QUmsAdminRoleRelation qUmsAdminRoleRelation = QUmsAdminRoleRelation.umsAdminRoleRelation;
        List<UmsAdminRoleRelation> relationList = getQueryFactory()
                .selectFrom(qUmsAdminRoleRelation)
                .where(qUmsAdminRoleRelation.roleId.in(roleIds))
                .fetch();
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        QUmsAdmin qUmsAdmin = QUmsAdmin.umsAdmin;
        QUmsAdminRoleRelation qUmsAdminRoleRelation = QUmsAdminRoleRelation.umsAdminRoleRelation;
        QUmsRoleResourceRelation qUmsRoleResourceRelation = QUmsRoleResourceRelation.umsRoleResourceRelation;
        QUmsResource qUmsResource = QUmsResource.umsResource;
        List<Long> adminIdList = getQueryFactory()
                .select(qUmsAdmin.id)
                .from(qUmsAdmin)
                .leftJoin(qUmsAdminRoleRelation).on(qUmsAdminRoleRelation.adminId.eq(qUmsAdmin.id))
                .leftJoin(qUmsRoleResourceRelation).on(qUmsRoleResourceRelation.roleId.eq(qUmsAdminRoleRelation.roleId))
                .leftJoin(qUmsResource).on(qUmsResource.id.eq(qUmsRoleResourceRelation.resourceId))
                .where(qUmsResource.id.eq(resourceId))
                .fetch();
        if (CollUtil.isNotEmpty(adminIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        List<UmsResource> resourceList = CommonUtil.objectToList(redisService.get(key), UmsResource.class);
        if (CollUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }
        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }

}
