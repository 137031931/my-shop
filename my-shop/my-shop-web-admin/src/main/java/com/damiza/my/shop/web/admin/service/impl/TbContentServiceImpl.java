package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.web.admin.dao.TbContentDao;
import com.damiza.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;
}
