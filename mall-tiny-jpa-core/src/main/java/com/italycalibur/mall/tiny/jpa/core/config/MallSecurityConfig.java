package com.italycalibur.mall.tiny.jpa.core.config;

import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsAdminService;
import com.italycalibur.mall.tiny.jpa.core.modules.ums.service.UmsResourceService;
import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsResource;
import com.italycalibur.mall.tiny.jpa.security.component.DynamicSecurityService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义配置，用于配置如何获取用户信息及动态权限
 * @author italycalibur
 * @since 2023/12/11
 */
@Configuration
public class MallSecurityConfig {

    @Resource
    private UmsAdminService adminService;
    @Resource
    private UmsResourceService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
            List<UmsResource> resourceList = resourceService.list();
            for (UmsResource resource : resourceList) {
                map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
            }
            return map;
        };
    }
}
