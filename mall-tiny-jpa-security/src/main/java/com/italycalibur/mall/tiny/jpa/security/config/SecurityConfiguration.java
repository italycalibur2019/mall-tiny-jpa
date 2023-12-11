package com.italycalibur.mall.tiny.jpa.security.config;

import com.italycalibur.mall.tiny.jpa.security.component.DynamicAuthorizationManager;
import com.italycalibur.mall.tiny.jpa.security.component.JwtAuthenticationTokenFilter;
import com.italycalibur.mall.tiny.jpa.security.component.RestAuthenticationEntryPoint;
import com.italycalibur.mall.tiny.jpa.security.component.RestfulAccessDeniedHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security基本配置(6.0以上版本必须使用lambda表达式配置)
 * @author italycalibur
 * @since 2023/12/11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Resource
    private IgnoreUrlsConfig ignoreUrlsConfig;
    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Resource
    private DynamicAuthorizationManager dynamicAuthorizationManager;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> {
                    // 允许白名单路径直接访问
                    for (String url : ignoreUrlsConfig.getUrls()) {
                        registry.requestMatchers(url).permitAll();
                    }
                    // 允许跨域请求的OPTIONS请求
                    registry.requestMatchers(HttpMethod.OPTIONS).permitAll();
                    // 任何请求需要身份认证
                    registry.anyRequest().access(dynamicAuthorizationManager);
                })
                .csrf(AbstractHttpConfigurer::disable)// 关闭跨站请求保护
                .sessionManagement(registry ->
                        registry.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// 不使用会话
                .exceptionHandling(registry -> registry
                        .accessDeniedHandler(restfulAccessDeniedHandler)
                        .authenticationEntryPoint(restAuthenticationEntryPoint))// 自定义权限拒绝处理类
                .addFilterBefore(jwtAuthenticationTokenFilter,
                        UsernamePasswordAuthenticationFilter.class)// 自定义权限拦截器JWT过滤器
                .build();
    }

}
