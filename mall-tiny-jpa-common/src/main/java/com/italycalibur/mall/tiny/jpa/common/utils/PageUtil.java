package com.italycalibur.mall.tiny.jpa.common.utils;

import com.italycalibur.mall.tiny.jpa.common.api.PageData;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 分页结果转换工具
 * @author dhr
 * @since 2023/12/8
 */
public class PageUtil<T> extends PageData<T> {

    protected PageUtil(Long total, Integer page, List<T> rows, Long totalPage) {
        super(total, page, rows, totalPage);
    }

    public static <T> PageUtil<T> build(Long total, List<T> rows){
        return new PageUtil<>(total,null,rows,null);
    }

    public static <T> PageUtil<T> build(Long total, List<T> rows,Long totalPage){
        return new PageUtil<>(total,null,rows,totalPage);
    }

    public static <T> PageUtil<T> build(Long total,Integer page, List<T> rows,Long totalPage){
        return new PageUtil<>(total,page,rows,totalPage);
    }

    public static <T> PageUtil<T> build(Page<T> pageData){
        return new PageUtil<>(pageData.getTotalElements(),pageData.getNumber(),pageData.getContent(),(long) pageData.getTotalPages());
    }
}
