package com.damiza.my.shop.web.api.dao;

import com.damiza.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 */
@Repository
public interface TbUserDao {
    TbUser login(TbUser tbUser);
}
