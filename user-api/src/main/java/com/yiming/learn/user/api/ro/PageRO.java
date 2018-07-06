package com.yiming.learn.user.api.ro;


import com.yiming.learn.user.common.util.BeanCopyUtil;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRO<T extends Serializable> implements Serializable {

    /**
     * 总记录数
     */
    private long total;
    /**
     * 结果集
     */
    private List<T> data;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 当前页的数量 <= pageSize，该属性来自ArrayList的size属性
     */
    private int size;

    public static <T extends Serializable> PageRO<T> empty(Class<T> clazz) {
        List emptyList = Collections.emptyList();
        PageRO<T> pageRO = new PageRO<T>();
        pageRO.setData(emptyList);
        pageRO.setTotal(0);
        return pageRO;
    }

    /**
     * 类型转换
     */
    public <S extends Serializable> PageRO<S> transLate(Class<S> clazz) {
        PageRO<S> pageRO = new PageRO<>();
        pageRO.setTotal(this.total);
        pageRO.setData(BeanCopyUtil.genBeanList(this.data, clazz));
        pageRO.setPageNum(this.pageNum);
        pageRO.setPageSize(this.pageSize);
        pageRO.setPages(this.pages);
        pageRO.setSize(this.size);
        return pageRO;
    }
}
