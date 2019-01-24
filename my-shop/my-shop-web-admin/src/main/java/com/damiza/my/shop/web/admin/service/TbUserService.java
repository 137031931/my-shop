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

    TbUser login(String email,String password);

}
