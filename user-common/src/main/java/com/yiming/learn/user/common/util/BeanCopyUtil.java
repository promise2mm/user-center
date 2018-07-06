package com.yiming.learn.user.common.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;


public class BeanCopyUtil {

    public static <S, T> T genBean(S source, Class<T> target) {
        T temp;
        try {
            temp = target.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("没有默认构造方法", e);
        }
        if (source == null) {
            return temp;
        }
        BeanUtils.copyProperties(source, temp);
        return temp;
    }

    public static <S, T> List<T> genBeanList(List<S> sources, Class<T> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        }
        return sources.stream().map(s -> genBean(s, target)).collect(Collectors.toList());
    }
}
