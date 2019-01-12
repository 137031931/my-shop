package com.damiza.my.shop.web.admain.dao.impl;

import com.damiza.my.shop.domain.User;
import com.damiza.my.shop.web.admain.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
//这是dao的注解
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getUser(String email, String password) {

        User user = null;
        if("admin@qq.com".equals(email)){
            if("123456".equals(password)){
               user.setEmail("admin@qq.com");
               user.setUsername("大米");
            }
        }else {
            logger.warn("获取\"{}\"的用户信息失败",user.getUsername());
        }
        return user;
    }
}
