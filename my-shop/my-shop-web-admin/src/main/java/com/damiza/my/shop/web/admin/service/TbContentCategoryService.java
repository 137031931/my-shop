package com.damiza.my.shop.web.admin.service;

import com.damiza.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {
    List<TbContentCategory> selectAll();

    /**
     * 根据父级节点查询所有子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
