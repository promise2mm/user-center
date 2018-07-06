package com.yiming.learn.user.api.service;

import com.yiming.learn.user.api.Response;
import com.yiming.learn.user.api.po.UserPO;
import com.yiming.learn.user.api.ro.PageRO;
import com.yiming.learn.user.api.ro.UserRO;

/**
 * Created by yiming on 2018-07-02 19:11. Description:
 *
 * @author yiming
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息对象
     */
    Response<UserRO> getUserById(Long userId);

    /**
     * 分页获取用户信息
     */
    Response<PageRO<UserRO>> getUserPage(UserPO userPO);

    Response<Long> add(UserPO userPO);

    Response<Boolean> updateUser(UserPO userPO);
}
