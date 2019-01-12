package com.damiza.my.shop.web.admain.web.controller;

import com.damiza.my.shop.commons.constant.ConstantUtils;
import com.damiza.my.shop.domain.User;
import com.damiza.my.shop.web.admain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 逻辑登录
     * 这里因为要把登录成功的信息放在会话中
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password,
                        HttpServletRequest httpServletRequest){
        User user = userService.login(email,password);
        if(user == null){
            return login();
        }
        else{
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        //invalidate()方法是清除session
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
