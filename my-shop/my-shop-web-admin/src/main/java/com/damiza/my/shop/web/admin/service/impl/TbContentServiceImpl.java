package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.dto.PageInfo;
import com.damiza.my.shop.commons.validator.BeanValidator;
import com.damiza.my.shop.domain.TbContent;
import com.damiza.my.shop.web.admin.dao.TbContentDao;
import com.damiza.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }


    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //不通过验证
        if(validator != null){
            return BaseResult.fail(validator);
        }

        //通过验证
        else{
            tbContent.setUpdated(new Date());
            //新增
            if (tbContent.getId() == null){

                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }
            //编辑用户
            else {
                tbContentDao.update(tbContent);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }


    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length, int draw,TbContent tbContent) {

            int count = tbContentDao.count(tbContent);

            Map<String,Object> params = new HashMap<>();
            params.put("start",start);
            params.put("length",length);
            params.put("tbContent",tbContent);

            PageInfo<TbContent> pageInfo = new PageInfo<>();
            pageInfo.setDraw(draw);
            pageInfo.setRecordsTotal(count);
            pageInfo.setRecordsFiltered(count);
            pageInfo.setData(tbContentDao.page(params));


            return pageInfo;

    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

}
