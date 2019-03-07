package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.commons.persistence.BaseDao;
import com.damiza.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;


@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
