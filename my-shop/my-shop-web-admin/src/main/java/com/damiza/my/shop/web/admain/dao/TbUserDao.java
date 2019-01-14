package com.damiza.my.shop.web.admain.dao;

import com.damiza.my.shop.domain.TbUser;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     * @return
     */
    public List<TbUser> selectAll();
}
