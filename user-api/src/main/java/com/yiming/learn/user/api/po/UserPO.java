package com.yiming.learn.user.api.po;

import lombok.Data;

/**
 * Created by yiming on 2018-07-06 16:05. Description:
 *
 * @author yiming
 */
@Data
public class UserPO extends PagePO {

    private static final long serialVersionUID = -7961874986811869355L;

    private Long id;

    private String name;

    private String phone;

    private String email;

    private Short status;

    private Integer age;

}
