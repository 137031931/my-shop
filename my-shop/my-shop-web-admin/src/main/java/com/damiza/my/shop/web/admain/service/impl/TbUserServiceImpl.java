package com.damiza.my.shop.web.admain.service.impl;

import com.damiza.my.shop.domain.TbUser;
import com.damiza.my.shop.web.admain.dao.TbUserDao;
import com.damiza.my.shop.web.admain.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }
}
