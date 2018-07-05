package com.yiming.learn.user.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yiming on 2018-07-05 19:43. Description:
 *
 * @author yiming
 */

@MapperScan(basePackages = "com.yiming.learn.user.dao")
@SpringBootApplication
public class UserSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{UserSpringBootApp.class}, args);
    }

}
