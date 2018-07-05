package com.yiming.learn.user.dao.dao;

import com.yiming.learn.user.dao.dto.User;

/**
 * Created by yiming on 2018-07-02 19:38. Description:
 *
 * @author yiming
 */
public interface UserDao {

    User getById(Long id);

}
