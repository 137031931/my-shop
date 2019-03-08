package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.validator.BeanValidator;
import com.damiza.my.shop.domain.TbContentCategory;
import com.damiza.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;

import com.damiza.my.shop.web.admin.dao.TbContentCategoryDao;
import com.damiza.my.shop.web.admin.service.TbContentCategoryService;
import com.damiza.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService {
    @Autowired
    private TbContentService tbContentService;

    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null) {
            return BaseResult.fail(validator);
        } else {
            TbContentCategory parent = entity.getParent();
            //如果没有选择父级节点,则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                //0代表根目录
                parent.setId(0L);
            }

            //新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);
                if (parent.getId() != 0L) {
                    //判断新增的节点有没有父级节点
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if ((currentCategoryParent != null)) {
                        //为父级节点设置isParent为true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }
                //父级节点为0标傲世根目录
                else {
                    //根目录一定是父级目录
                    entity.setIsParent(true);
                }

                dao.insert(entity);
            } else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    /**
     * 删除分类
     *
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        List<String> targetArray = new ArrayList<>();
        findAllChild(targetArray, id);

        String[] categoryIds = targetArray.toArray(new String[targetArray.size()]);

        // 删除类目及其子类目
        dao.delete(categoryIds);

        // 删除类目下所有内容
        tbContentService.deleteByCategoryId(categoryIds);
    }

    /**
     * 查找出所有子节点
     *
     * @param targetList
     * @param parentId
     */
    private void findAllChild(List<String> targetList, Long parentId) {
        targetList.add(String.valueOf(parentId));

        List<TbContentCategory> tbContentCategories = selectByPid(parentId);
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            findAllChild(targetList, tbContentCategory.getId());
        }
    }
}
