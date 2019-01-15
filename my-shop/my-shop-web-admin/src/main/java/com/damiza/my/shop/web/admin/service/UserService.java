package com.damiza.my.shop.web.admin.service;

import com.damiza.my.shop.domain.User;

public interface UserService {
    public User login(String email, String password);

}
