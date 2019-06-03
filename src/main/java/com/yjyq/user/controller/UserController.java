package com.yjyq.user.controller;

import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/home.do")
    public String home(Model model) throws Exception{
        System.out.println("首页");
        List<User> userList = userServiceImpl.findUser();
        System.out.println(userList);
        model.addAttribute("userList",userList);
        return "home";
    }
}
