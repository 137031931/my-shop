package com.damiza.my.shop.web.ui.controller;

import com.damiza.my.shop.commons.utils.HttpClientUtils;
import com.damiza.my.shop.commons.utils.MapperUtils;
import com.damiza.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(){
        String result = HttpClientUtils.doGet("http://localhost:8081/api/v1/contents/89");
        try {
            MapperUtils.json2list(result, TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return "index";
    }
}
