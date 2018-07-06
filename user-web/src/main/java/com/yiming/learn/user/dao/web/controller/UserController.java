package com.yiming.learn.user.dao.web.controller;

import com.yiming.learn.user.api.Response;
import com.yiming.learn.user.api.po.UserPO;
import com.yiming.learn.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yiming on 2018-07-02 19:19. Description:
 *
 * @author yiming
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Response getUserInfo(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "page", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response page(UserPO userPO) {
        return userService.getUserPage(userPO);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response add(@RequestBody UserPO userPO) {
        return userService.add(userPO);
    }


    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response updateUser(UserPO userPO) {
        return userService.updateUser(userPO);
    }

}
