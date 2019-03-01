package com.damiza.my.shop.web.api.web;

import com.damiza.my.shop.domain.TbContent;
import com.damiza.my.shop.domain.TbContentCategory;
import com.damiza.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if (id == null){
            tbContent = new TbContent();
        }

        return tbContent;
    }

    @RequestMapping(value = "findContentByCategoryId",method = RequestMethod.GET)
    public List<TbContent> findContentByCategoryId(TbContent tbContent, Long categoryId){

        return tbContentService.selectByCategoryId(categoryId);
    }
}
