package com.damiza.my.shop.commons.persistence;

import java.util.List;

/**
 * 通用树形接口
 * @param <T>
 */
public interface BaseTreeDao<T extends BaseEntity> {
    /**
     * 查询全部信息
     * @return
     * 1.8版本以后public可以不写
     *
     */
    List<T> selectAll();

    /**
     * 新增
     * @param
     */
    void insert(T entity);

    /**
     * 根据id删除方法
     */
    void delete(Long id);

    /**
     * 根据id查询信息
     */
    T getById(Long id);

    /**
     * 更新
     */
    void update(T entity);

    /**
     * 根据父级节点查询所有子节点
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
