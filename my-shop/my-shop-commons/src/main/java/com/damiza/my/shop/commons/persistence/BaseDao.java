package com.damiza.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

public interface BaseDao<T extends BaseEntity> {
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
     * 批量删除功能
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params 需要两条参数 start:记录开始的位置 length:每页记录数
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);
}
