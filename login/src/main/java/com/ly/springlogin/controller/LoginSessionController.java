package com.ly.springlogin.controller;

import com.ly.springlogin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by acer on 2016/5/28.
 */
@Controller
@RequestMapping("/")
public class LoginSessionController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse resposne) {
        String username = (String) request.getSession().getAttribute("username");
        if (null != username) {
            return "redirect:welcome";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse resposne, User user, Model model) {
        String username = user.getUsername();
        if (username.equals("admin")) {
            request.getSession().setAttribute("username",username);
            request.getSession().setMaxInactiveInterval(60);
            model.addAttribute("user", user);
            return "welcome";
        } else {
            return "login";
        }
    }

    // 需要获取用户信息的资源
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request, HttpServletResponse resposne, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        User user = new User();
        user.setUsername(username);
        model.addAttribute("user", user);
        return "welcome";
    }

    // 不需要获取用户信息的资源
    @RequestMapping("/welcome2")
    public String welcome2() {
        return "welcome2";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse resposne) {
        request.getSession().invalidate();
        return "redirect:login";
    }


}
