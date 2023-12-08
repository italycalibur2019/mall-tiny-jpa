package com.italycalibur.mall.tiny.jpa.common.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 分页查询结果
 * @author dhr
 * @since 2023/12/8
 */
public abstract class PageData<T> {

    /**
     * 查询总数
     */
    private final Long total;

    /**
     * 当前页数
     */
    private final Integer page;

    /**
     * 当前页查询结果
     */
    private final List<T> rows;

    /**
     * 总页数
     */
    private final Long totalPage;

    protected PageData(Long total, Integer page, List<T> rows, Long totalPage) {
        this.total = total;
        this.page = page;
        this.rows = rows;
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return Optional.ofNullable(this.total).orElse(0L);
    }

    public Integer getPage() {
        return Optional.ofNullable(this.page).orElse(1);
    }

    public List<T> getRows() {
        return Optional.ofNullable(this.rows).orElse(Collections.emptyList());
    }

    public Long getTotalPage() {
        return Optional.ofNullable(this.totalPage).orElse(0L);
    }
}
