package com.yiming.learn.user.service.impl;

import com.yiming.learn.user.api.Response;
import com.yiming.learn.user.api.po.UserPO;
import com.yiming.learn.user.api.ro.PageRO;
import com.yiming.learn.user.api.ro.UserRO;
import com.yiming.learn.user.api.service.UserService;
import com.yiming.learn.user.common.util.BeanCopyUtil;
import com.yiming.learn.user.dao.dto.User;
import com.yiming.learn.user.dao.mapper.UserMapper;
import com.yiming.learn.user.service.util.PageUtil;
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
    private UserMapper userMapper;

    @Override
    public Response<UserRO> getUserById(Long userId) {
        User user = new User();
        user.setId(userId);
        user = userMapper.selectOne(user);
        UserRO ro = BeanCopyUtil.genBean(user, UserRO.class);
        return Response.ok(ro);
    }

    @Override
    public Response<PageRO<UserRO>> getUserPage(UserPO userPO) {
        User user = BeanCopyUtil.genBean(userPO, User.class);
        PageRO<User> page = PageUtil.doSelectPage(userPO.getPageNum(), userPO.getPageSize(), () -> userMapper.select(user));
        return Response.ok(page.transLate(UserRO.class));
    }

    @Override
    public Response<Long> add(UserPO userPO) {
        User user = BeanCopyUtil.genBean(userPO, User.class);
        userMapper.insertSelective(user);
        return Response.ok(user.getId());
    }

    @Override
    public Response<Boolean> updateUser(UserPO userPO) {
        if (userPO.getId() == null) {
            return Response.fail("id不能为空");
        }
        User user = BeanCopyUtil.genBean(userPO, User.class);
        return Response.ok(userMapper.updateByPrimaryKeySelective(user) > 0);
    }

}
