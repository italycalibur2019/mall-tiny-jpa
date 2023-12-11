package com.italycalibur.mall.tiny.jpa.core.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;

/**
 * 基本服务实现层（添加QueryDsl查询工厂类）
 * @author italycalibur
 * @since 2023/12/11
 */
public abstract class BaseServiceImpl {

    @Getter
    private JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

}
