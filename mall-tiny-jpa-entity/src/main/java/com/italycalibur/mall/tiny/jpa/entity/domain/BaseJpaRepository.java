package com.italycalibur.mall.tiny.jpa.entity.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 基本实体持久层
 * @author italycalibur
 * @since 2023/12/8
 * @param <E> 实体
 * @param <ID> 主键
 */
@NoRepositoryBean
public interface BaseJpaRepository<E, ID> extends JpaRepository<E, ID>,
        JpaSpecificationExecutor<E>, QuerydslPredicateExecutor<E> {

}
