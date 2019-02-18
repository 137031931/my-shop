package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll();

    /**
     * 根据父级节点查询所有子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
