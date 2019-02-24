package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.commons.persistence.BaseDao;
import com.damiza.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao extends BaseDao<TbContentCategory> {
    /**
     * 根据父级节点查询所有子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
