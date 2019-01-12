package com.damiza.my.shop.web.admain.web.controller;

import com.damiza.my.shop.web.admain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value ={"", "login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
