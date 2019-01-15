package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.domain.User;

/**
 * 根据邮箱和密码获取用户信息
 * @param email 邮箱
 * @param password 密码
 * @return 用户
 */
public interface UserDao {
    public User getUser(String email, String password);
}
