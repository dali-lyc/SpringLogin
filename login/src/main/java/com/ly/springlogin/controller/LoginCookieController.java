//package com.ly.springlogin.controller;
//
//import com.ly.springlogin.model.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by acer on 2016/5/28.
// */
//@Controller
//@RequestMapping("/")
//public class LoginCookieController {
//
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, HttpServletResponse resposne) {
//        String username=null;
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if ("username".equals(cookie.getName())) {
//                username = cookie.getValue();
//                break;
//            }
//        }
//        if (null != username) {
//            return "redirect:welcome";
//        }
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(HttpServletRequest request, HttpServletResponse resposne, User user, Model model) {
//        String username = user.getUsername();
//        if (username.equals("admin")) {
//            Cookie cookie = new Cookie("username", username);
//            cookie.setMaxAge(60);
//            cookie.setPath("/");
//            resposne.addCookie(cookie);
//            model.addAttribute("user", user);
//            return "welcome";
//        } else {
//            return "login";
//        }
//    }
//
//    // 需要获取用户信息的资源
//    @RequestMapping("/welcome")
//    public String welcome(HttpServletRequest request, HttpServletResponse resposne, Model model) {
//        String username=null;
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if ("username".equals(cookie.getName())) {
//                username = cookie.getValue();
//                break;
//            }
//        }
//        User user = new User();
//        user.setUsername(username);
//        model.addAttribute("user", user);
//        return "welcome";
//    }
//
//    // 不需要获取用户信息的资源
//    @RequestMapping("/welcome2")
//    public String welcome2() {
//        return "welcome2";
//    }
//
//    @RequestMapping("logout")
//    public String logout(HttpServletRequest request, HttpServletResponse resposne) {
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if ("username".equals(cookie.getName())) {
//                cookie.setMaxAge(0);
//                cookie.setPath("/");
//                resposne.addCookie(cookie);
//                break;
//            }
//        }
//        return "redirect:login";
//    }
//
//
//}
