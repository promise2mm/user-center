package com.yiming.learn.user.api.po;

import lombok.Data;

/**
 * Created by yiming on 2018-07-06 16:03. Description:
 *
 * @author yiming
 */
@Data
public class PagePO extends BasePO {

    private Integer pageNum;

    private Integer pageSize;

}
