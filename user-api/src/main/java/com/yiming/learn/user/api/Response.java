package com.yiming.learn.user.api;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yiming on 2018-07-02 19:20. Description:
 *
 * @author yiming
 */
@Data
public class Response<T> implements Serializable {

    private String code = "200";

    private T data;

    private String errorMsg = "";

    private boolean success = true;

    public static <T> Response<T> ok(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    public static <T> Response<T> fail(String errorMsg) {
        Response<T> response = new Response<>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }
}
