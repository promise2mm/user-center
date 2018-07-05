package com.yiming.learn.user.dao.dao;

import com.yiming.learn.user.dao.dto.User;
import com.yiming.learn.user.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yiming on 2018-07-02 19:39. Description:
 *
 * @author yiming
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
