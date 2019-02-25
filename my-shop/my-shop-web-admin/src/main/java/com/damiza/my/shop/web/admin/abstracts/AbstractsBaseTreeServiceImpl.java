package com.damiza.my.shop.web.admin.abstracts;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import com.damiza.my.shop.commons.persistence.BaseTreeDao;
import com.damiza.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractsBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    private D dao;
    /**
     * 查询全部数据
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        dao.delete(id);
    }

    /**
     * 根据id查询信息
     */
    @Override
    public T getById(Long id){
        return dao.getById(id);
    }

    /**
     * 更新
     */
    @Override
    public void update(T entity){
        dao.update(entity);
    }

    /**
     * 根据父级节点查询所有子节点
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid){
        return dao.selectByPid(pid);
    }

    public void insert(T entity){
        dao.insert(entity);
    }
}
