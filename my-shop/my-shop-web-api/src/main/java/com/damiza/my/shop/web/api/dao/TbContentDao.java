package com.damiza.my.shop.web.api.dao;

import com.damiza.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {
    /**
     * 根据类别ID查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
