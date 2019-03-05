package com.damiza.my.shop.web.api.service.impl;

import com.damiza.my.shop.domain.TbUser;
import com.damiza.my.shop.web.api.dao.TbUserDao;
import com.damiza.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if (user != null){
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(user.getPassword())){
                //登录成功
                return user;
            }
        }

        return null;
    }
}
