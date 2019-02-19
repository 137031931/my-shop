package com.damiza.my.shop.web.admin.web.controller;

import com.damiza.my.shop.domain.TbContentCategory;
import com.damiza.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();

        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();

        sortList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }

    /**
     * 树形结构
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if (id == null ){
            id = 0L;
        }
        return tbContentCategoryService.selectByPid(id);
    }

    /**
     * 因为treeTable需要排序才能正确分级这里做排序
     * @param sourceList 数据源集合
     * @param targetList 排序后集合
     * @param parentId 父节点的id
     */
    private void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for (TbContentCategory tbContentCategory : sourceList) {
            if(tbContentCategory.getParentId().equals(parentId)){
            targetList.add(tbContentCategory);

                //判断有没有子节点,如果有继续
                if(tbContentCategory.getIsParent()){
                    for (TbContentCategory contentCategory : sourceList) {
                        if(contentCategory.getParentId().equals(tbContentCategory.getId())){
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }

}
