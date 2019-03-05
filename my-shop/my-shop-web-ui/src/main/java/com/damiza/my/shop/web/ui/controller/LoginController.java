package com.damiza.my.shop.web.ui.controller;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.web.ui.api.UsersApi;
import com.damiza.my.shop.web.ui.constant.SystemConstants;
import com.damiza.my.shop.web.ui.dto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        TbUser user = UsersApi.login(tbUser);

        //登录失败
        if (user==null){
            model.addAttribute("baseResult",BaseResult.fail("用户名或密码错误,请重新输入"));
            return "login";
        }
        //登录成功
        else {
            //将会员信息放入session
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY,user);
            return "redirect:/index";
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index";
    }
}
