package com.damiza.my.shop.web.admin.service;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    public List<TbUser> selectAll();

    BaseResult save(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);

    /**
     * 搜索功能,传一个关键字进来
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
