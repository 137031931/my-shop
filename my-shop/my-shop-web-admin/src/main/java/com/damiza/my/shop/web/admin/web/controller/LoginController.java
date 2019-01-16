package com.damiza.my.shop.web.admin.web.controller;

import com.damiza.my.shop.commons.constant.ConstantUtils;
import com.damiza.my.shop.domain.TbUser;
import com.damiza.my.shop.domain.User;
import com.damiza.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;
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
         *
         * */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest
            , Model model){
        TbUser tbUser = tbUserService.login(email,password);
        //tbUser为空,登录失败
        if(tbUser == null ){

            return login();
        }
        //登录成功
        else{

        }
//        User user = userService.login(email,password);
//        if(user == null){
//            return login();
//        }
//        else{
//            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
//            return "redirect:/main";
//        }
        return null;
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
