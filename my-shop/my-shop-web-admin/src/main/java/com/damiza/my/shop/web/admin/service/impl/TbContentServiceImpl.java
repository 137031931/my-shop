package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.dto.PageInfo;
import com.damiza.my.shop.commons.validator.BeanValidator;
import com.damiza.my.shop.domain.TbContent;
import com.damiza.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.damiza.my.shop.web.admin.dao.TbContentDao;
import com.damiza.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent ,TbContentDao> implements TbContentService{

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
                dao.insert(tbContent);
            }
            //编辑用户
            else {
                update(tbContent);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }


}
