package com.ly.springlogin.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by acer on 2016/5/29.
 */
@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

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

        String path = request.getRequestURI();
        if (path.indexOf("/login") > -1 || str != null) {
            chain.doFilter(req, resp);
        } else {
            Date date = new Date();
            SimpleDateFormat smt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            System.out.println(smt.format(date) + " username=========>"+str);
            response.sendRedirect("/login");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
