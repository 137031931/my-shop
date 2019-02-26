package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.validator.BeanValidator;
import com.damiza.my.shop.domain.TbContentCategory;
import com.damiza.my.shop.web.admin.abstracts.AbstractsBaseTreeServiceImpl;

import com.damiza.my.shop.web.admin.dao.TbContentCategoryDao;
import com.damiza.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TbContentCategoryServiceImpl extends AbstractsBaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService {

    @Override
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null){
            return BaseResult.fail(validator);
        }

        else {
            TbContentCategory parent = entity.getParent();
            //如果没有选择父级节点,则默认设置为根目录
            if(parent==null || parent.getId() == null){
                //0代表根目录
                parent.setId(0L);

            }

            //新增
            if (entity.getId() == null){
                entity.setCreated(new Date());
                entity.setIsParent(false);
                if (parent.getId() != 0L){
                    //判断新增的节点有没有父级节点
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if ((currentCategoryParent != null)){
                        //为父级节点设置isParent为true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }
                else{
                    //根目录一定是父级目录
                    entity.setIsParent(true);
                }

                dao.insert(entity);
            }

            else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }}
