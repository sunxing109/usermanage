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

    /**
     * 用户Service
     */
    @Autowired
    private UserServiceImpl userService;

    /**
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserList.do")
    public String findUserList(Model model) throws Exception{
        List<User> userList = userService.findUserList();
        System.out.println(userList);
        model.addAttribute("userList",userList);
        return "findUserList";
    }

}
