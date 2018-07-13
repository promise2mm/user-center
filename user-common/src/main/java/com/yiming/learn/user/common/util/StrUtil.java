package com.yiming.learn.user.common.util;

/**
 * Created by yiming on 2018-07-02 19:15. Description:
 *
 * @author yiming
 */
public class StrUtil {

    public static Boolean isEmpty(String s) {
        if (s == null) {
            return Boolean.TRUE;
        }
        if ("".equals(s)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

}
