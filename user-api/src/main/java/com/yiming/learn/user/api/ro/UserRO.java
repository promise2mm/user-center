package com.yiming.learn.user.api.ro;

import java.util.Date;
import lombok.Data;

/**
 * Created by yiming on 2018-07-02 19:36. Description:
 *
 * @author yiming
 */
@Data
public class UserRO extends BaseRO {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private Short status;

    private Integer age;

    private Boolean isDel;

    private Date createAt;

    private Date updateAt;

}
