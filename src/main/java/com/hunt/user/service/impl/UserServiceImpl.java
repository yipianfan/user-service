package com.hunt.user.service.impl;

import com.hunt.user.entry.User;
import com.hunt.user.mapper.UserMapper;
import com.hunt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }
}