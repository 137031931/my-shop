package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.commons.persistence.BaseDao;
import com.damiza.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 查询用户表全部信息
     * @return
     * 1.8版本以后public可以不写
     *
     */
    /**
     * 使用email邮箱查询单个用户
     */
    TbUser getByEmail(String email);
}