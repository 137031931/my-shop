package com.damiza.my.shop.commons.persistence;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询全部
     * @return
     */
    public List<T> selectAll();

    /**
     * 保存信息
     * @param
     * @return
     */
    BaseResult save(T entity);

    /**
     * 删除信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 跟新用户信息
     * @param entity
     */
    void update(T entity);
    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);
}
