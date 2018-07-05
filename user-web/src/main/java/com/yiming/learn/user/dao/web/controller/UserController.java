package com.yiming.learn.user.dao.web.controller;

import com.yiming.learn.user.api.Response;
import com.yiming.learn.user.api.service.UserService;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public Response getUserInfo(@NotNull Long userId) {
        return userService.getUserById(userId);
    }

}
