package com.yiming.learn.user.service.impl;

import com.yiming.learn.user.api.Response;
import com.yiming.learn.user.api.enums.StatusEnum;
import com.yiming.learn.user.api.po.UserPO;
import com.yiming.learn.user.api.ro.PageRO;
import com.yiming.learn.user.api.ro.UserRO;
import com.yiming.learn.user.api.service.UserService;
import com.yiming.learn.user.common.util.BeanCopyUtil;
import com.yiming.learn.user.common.util.StrUtil;
import com.yiming.learn.user.dao.dto.User;
import com.yiming.learn.user.dao.dto.UserExample;
import com.yiming.learn.user.dao.mapper.UserMapper;
import com.yiming.learn.user.service.util.PageUtil;
import java.util.Objects;
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
        User user = userMapper.selectByPrimaryKey(userId);
        UserRO ro = BeanCopyUtil.genBean(user, UserRO.class);
        return Response.ok(ro);
    }

    @Override
    public Response<PageRO<UserRO>> getUserPage(UserPO userPO) {
        PageRO<User> page = PageUtil
            .doSelectPage(userPO.getPageNum(), userPO.getPageSize(),
                () -> userMapper.selectByExample(createUserExample(userPO)));
        return Response.ok(page.transLate(UserRO.class));
    }

    private UserExample createUserExample(UserPO userPO) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotEmpty(userPO.getName())) {
            criteria.andNameLike("%" + userPO.getName() + "%");
        }
        if (StrUtil.isNotEmpty(userPO.getPhone())) {
            criteria.andPhoneEqualTo(userPO.getPhone());
        }
        if (Objects.nonNull(userPO.getId())) {
            criteria.andIdEqualTo(userPO.getId());
        }
        if (StrUtil.isNotEmpty(userPO.getEmail())) {
            criteria.andEmailEqualTo(userPO.getEmail());
        }
        return example;
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

    @Override
    public Response<Boolean> delete(Long userId) {
        UserPO userPO = new UserPO();
        userPO.setId(userId);
        userPO.setStatus(StatusEnum.DELETE.getCode());
        return updateUser(userPO);
    }

}
