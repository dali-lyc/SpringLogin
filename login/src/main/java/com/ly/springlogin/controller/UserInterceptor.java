package com.ly.springlogin.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by acer on 2016/5/28.
 *
 * 通过拦截器拦截请求
 */
public class UserInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 采用session方式获取用户登录信息
//        String str = (String) request.getSession().getAttribute("username");

        // 采用cookie方式获取用户登录信息
        String str=null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                str = cookie.getValue();
                break;
            }
        }

        Date date = new Date();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(smt.format(date) + " username=========>"+str);
        if(str!=null){
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
