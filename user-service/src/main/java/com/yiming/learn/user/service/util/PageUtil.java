package com.yiming.learn.user.service.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yiming.learn.user.api.ro.PageRO;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * Created by yiming on 2018-07-06 14:42. Description:
 *
 * @author yiming
 */
@Slf4j
public class PageUtil {

    public static <T extends Serializable> PageRO<T> doSelectPage(Integer pageNum, Integer pageSize, Callable<List<T>> callable) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        try {
            // 设置分页参数
            PageHelper.startPage(pageNum, pageSize);
            // 业务查询
            List<T> list = callable.call();
            return toPageRO(list);
        } catch (Exception ex) {
            log.warn("分页查询失败", ex);
            throw new RuntimeException("分页查询失败", ex);
        } finally {
            PageHelper.clearPage();
        }
    }


    private static <T extends Serializable> PageRO<T> toPageRO(List<T> list) {
        Assert.isInstanceOf(Page.class, list);
        Page<T> page = (Page<T>) list;
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        long total = page.getTotal();
        int pages = page.getPages();
        int size = page.size();
        return new PageRO<>(total, page, pageNum, pageSize, pages, size);
    }

}
