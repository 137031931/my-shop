package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.dto.PageInfo;
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
        BaseResult baseResult = checkTbContent(tbContent);
        //如果通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
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

                baseResult.setMessage("保存内容信息成功");
            }

            return baseResult;
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

    /**
     * 信息的有效性验证
     * @param tbContent
     */
    private BaseResult checkTbContent(TbContent tbContent){
        BaseResult baseResult = BaseResult.success();
        //非空验证
        //email不能为空
        if(tbContent.getCategoryId() == null){
            baseResult = BaseResult.fail("内容的所属分类不能为空,请重新输入");

        }
        else if (tbContent.getTitle() == null){
            baseResult = BaseResult.fail("内容标题不能为空,请重新输入");
        }

        else if (tbContent.getSubTitle() == null) {
            baseResult = BaseResult.fail("子标题不能为空,请重新输入");
        }
        else if(tbContent.getTitleDesc() == null){
            baseResult = BaseResult.fail("标题描述不能为空,请重新输入");

        }
        else if (tbContent.getUrl() == null){
            baseResult = BaseResult.fail("链接不能为空,请重新输入");
        }
        else if(tbContent.getPic() == null){
            baseResult = BaseResult.fail("图片绝对路径不能为空,请重新输入");

        }
        else if (tbContent.getPic2() == null){
            baseResult = BaseResult.fail("图片2绝对路径不能为空,请重新输入");
        }
        //验证
        else if(tbContent.getContent() == null){
            baseResult = BaseResult.fail("内容不能为空,请重新输入");

        }

        return baseResult;
    }
}
