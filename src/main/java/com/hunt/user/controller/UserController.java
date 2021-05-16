package com.hunt.user.controller;

import com.hunt.user.entry.User;
import com.hunt.user.entry.vo.ResVo;
import com.hunt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResVo register(@RequestBody User user) {
        userService.register(user);
        return new ResVo();
    }
}