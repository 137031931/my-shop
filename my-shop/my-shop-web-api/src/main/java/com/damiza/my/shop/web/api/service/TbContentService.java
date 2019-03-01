package com.damiza.my.shop.web.api.service;

import com.damiza.my.shop.domain.TbContent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbContentService {
    /**
     * 根据类别ID查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
