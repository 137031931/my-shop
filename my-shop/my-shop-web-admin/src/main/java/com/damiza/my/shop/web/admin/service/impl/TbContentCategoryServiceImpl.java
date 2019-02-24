package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.dto.PageInfo;
import com.damiza.my.shop.domain.TbContentCategory;
import com.damiza.my.shop.web.admin.dao.TbContentCategoryDao;
import com.damiza.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public BaseResult save(TbContentCategory entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }
    @Override
    public TbContentCategory getById(Long id){
        return tbContentCategoryDao.getById(id);
    }

    @Override
    public void update(TbContentCategory entity) {

    }

    @Override
    public void deleteMulti(String[] ids) {

    }

    @Override
    public PageInfo<TbContentCategory> page(int start, int length, int draw, TbContentCategory entity) {
        return null;
    }

    @Override
    public int count(TbContentCategory entity) {
        return 0;
    }
}
