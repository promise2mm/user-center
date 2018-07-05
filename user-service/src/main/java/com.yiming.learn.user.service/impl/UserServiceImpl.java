package com.yiming.learn.user.service.impl;

import com.yiming.learn.user.common.util.BeanCopyUtil;
import com.yiming.learn.user.api.Response;
import com.yiming.learn.user.api.ro.UserRO;
import com.yiming.learn.user.api.service.UserService;
import com.yiming.learn.user.dao.dao.UserDao;
import com.yiming.learn.user.dao.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yiming on 2018-07-02 19:12. Description:
 *
 * @author yiming
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Response<UserRO> getUserById(Long userId) {
        User user = userDao.getById(userId);
        UserRO ro = BeanCopyUtil.genBean(user, UserRO.class);
        return Response.ok(ro);
    }
}
