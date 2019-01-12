package com.damiza.my.shop.web.admain.service.impl;

import com.damiza.my.shop.domain.User;
import com.damiza.my.shop.web.admain.dao.UserDao;
import com.damiza.my.shop.web.admain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //自动注入
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String email, String password) {
        return userDao.getUser(email,password);
    }
}
