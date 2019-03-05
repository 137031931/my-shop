package com.damiza.my.shop.web.ui.controller;

import com.damiza.my.shop.commons.utils.HttpClientUtils;
import com.damiza.my.shop.commons.utils.MapperUtils;
import com.damiza.my.shop.web.ui.api.ContentsApi;
import com.damiza.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(Model model){
        //请求幻灯片
        requestContentsPPT(model);
        return "index";
    }

    /**
     * 请求ppt
     * @param model
     */
    private void requestContentsPPT(Model model){
        List<TbContent> tbContents = ContentsApi.ppt();
        for(TbContent tbContent : tbContents){
            System.out.println(tbContent);
        }
        model.addAttribute("ppt",tbContents);
    }
}
