package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.web.admin.dao.TbContentCategoryDao;
import com.damiza.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;
}
