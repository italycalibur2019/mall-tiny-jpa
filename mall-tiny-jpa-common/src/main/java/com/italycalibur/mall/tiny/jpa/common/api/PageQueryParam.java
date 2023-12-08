package com.italycalibur.mall.tiny.jpa.common.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


/**
 * 分页查询参数
 * @author dhr
 * @since 2023/12/8
 */
@Setter
public class PageQueryParam<T> {

    /**
     * 页数，默认为0
     */
    private Integer pageNum;
    /**
     *
     * 每页数量，默认为10
     */
    private Integer pageSize;

    /**
     * 查询参数
     */
    @Getter
    private T params;

    public Integer getPageNum() {
        return Optional.ofNullable(pageNum).orElse(0);
    }

    public Integer getPageSize() {
        return Optional.ofNullable(pageSize).orElse(10);
    }

    public PageQueryParam(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    /**
     * 获取分页参数
     */
    public Pageable pageable() {
        return PageRequest.of(pageNum, pageSize);
    }
}
