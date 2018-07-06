package com.yiming.learn.user.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yiming on 2018-07-05 19:43. Description:
 *
 * @author yiming
 */

//@MapperScan(basePackages = "com.yiming.learn.user.dao.mapper")
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.yiming.learn.user.dao.mapper")
@ComponentScan(basePackages = {"com.yiming.learn.user"})
@EnableTransactionManagement
@SpringBootApplication
public class UserSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{UserSpringBootApp.class}, args);
    }

}
