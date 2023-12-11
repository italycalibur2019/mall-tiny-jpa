package com.italycalibur.mall.tiny.jpa.security.config;

import com.italycalibur.mall.tiny.jpa.security.component.*;
import com.italycalibur.mall.tiny.jpa.security.utils.JwtTokenUtil;
import com.italycalibur.mall.tiny.jpa.security.utils.MD5PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security通用配置
 * @author italycalibur
 * @since 2023/12/11
 */
@Configuration
public class CommonSecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MD5PasswordEncoder();
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

    @Bean
    public DynamicAuthorizationManager dynamicAuthorizationManager() {
        return new DynamicAuthorizationManager();
    }

}
