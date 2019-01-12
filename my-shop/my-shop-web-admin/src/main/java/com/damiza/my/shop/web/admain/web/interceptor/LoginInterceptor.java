package com.damiza.my.shop.web.admain.web.interceptor;

import com.damiza.my.shop.commons.constant.ConstantUtils;
import com.damiza.my.shop.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 这是一个登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    //这是在拦截之前执行的
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //未登录
        if(user==null){
            httpServletResponse.sendRedirect("/login");
        }

        //达成条件下面是true才能放行
        return true;
    }

    //这是放行命令
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    //这是在拦截之后进行的
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
