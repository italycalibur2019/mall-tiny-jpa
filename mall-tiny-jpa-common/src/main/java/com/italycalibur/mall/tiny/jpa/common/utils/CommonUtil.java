package com.italycalibur.mall.tiny.jpa.common.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 通用工具类
 * @author italycalibur
 * @since 2023/12/12
 */
public class CommonUtil {

    /**
     * Object安全转换为list对象
     */
    public static <T> List<T> objectToList(Object object, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (object instanceof List<?>) {
            for (Object o : (List<?>) object) {
                list.add(clazz.cast(o));
            }
            return list;
        }
        return null;
    }

    /**
     * 将list转换为page对象
     */
    public static <T> Page<T> listToPage(List<T> content, Pageable pageable) {
        return getPage(content, pageable);
    }

    private static <T> Page<T> getPage(List<T> list, Pageable pageable) {
        //第n页起始值
        int pageStart = pageable.getPageNumber() * pageable.getPageSize();
        //第n页期望结尾值
        int expectPageEnd = pageStart + pageable.getPageSize() - 1;
        return Optional.of(list.size())
                .filter(size -> size >= pageStart)
                .map(size -> getRealSubList(pageStart, expectPageEnd, list, pageable))
                .orElseGet(() -> getEmptySubList(list, pageable));
    }

    private static <T> PageImpl<T> getRealSubList(int pageStart, int expectPageEnd,
                                                  List<T> list, Pageable pageable) {
        int realPageEnd = (list.size() > expectPageEnd
                || list.size() == expectPageEnd) ? expectPageEnd + 1 : list.size();
        return new PageImpl<>(list.subList(pageStart, realPageEnd), pageable, list.size());
    }

    private static <T> PageImpl<T> getEmptySubList(List<T> list, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(), pageable, list.size());
    }
}
