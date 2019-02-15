package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     * @return
     * 1.8版本以后public可以不写
     *
     */
     List<TbUser> selectAll();

    /**
     * 新增用户
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 根据id删除方法
     */
    void delete(Long id);

    /**
     * 根据id查询用户信息
     */
    TbUser getById(Long id);

    /**
     * 更新用户
     */
    void update(TbUser tbUser);

//    /**
//     * 模糊查询
//     */
//
//    List<TbUser> selectByUsername(String username);

    /**
     * 使用email邮箱查询单个用户
     */
    TbUser getByEmail(String email);

//    /**
//     * 搜索功能
//     * @param tbUser
//     * @return
//     */
//    List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除功能
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params 需要两条参数 start:记录开始的位置 length:每页记录数
     * @return
     */
    List<TbUser> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbUser tbUser);
}