package com.yiming.learn.user.api.enums;

import lombok.Getter;

/**
 * Created by yiming on 2018-07-13 13:56. Description:
 *
 * @author yiming
 */
public enum StatusEnum {

    NORMAL((short) 0, "正常"),
    DELETE((short) 1, "已删除删除");

    @Getter
    private Short code;

    @Getter
    private String name;

    StatusEnum(Short code, String name) {
        this.code = code;
        this.name = name;
    }
}
