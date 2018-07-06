package com.yiming.learn.user.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by yiming on 2018-07-06 15:11. Description:
 *
 * @author yiming
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
