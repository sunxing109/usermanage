package com.yjyq.user.controller;

import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import com.yjyq.user.util.VerifyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/** 用户管理控制器
 * @author sunxingba
 * @version 1.0 $
 */
@Controller
public class UserController {

    /**
     * 引入日志，注意都是"org.slf4j"包下
     */
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

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
    @RequestMapping("/")
    public String findUserList(Model model) throws Exception{
        model.addAttribute("js_variable","消息");
        List<User> userList = userService.findUserList();
        userList.stream().map(user -> { return user.getUserAge();}).collect(Collectors.toList());
        userList.stream().filter(user -> user.getUserAge()!=5).collect(Collectors.toList());
        userList.stream().forEach(user -> System.out.println(""));
        userList.stream().collect(Collectors.toSet());
        userList.stream().findFirst();
        // Runnable r = () -> System.out.println("hello,lambda");
        // r.run();

        //LocalDateTime tt = new LocalDateTime(null, null);
        logger.info("获取用户集合");
        System.out.println(userList);
        model.addAttribute("userList",userList);
        Integer a = 0;
        try {
            logger.debug("开始-1");
            // userList.get(-1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取列表-1错误:{}", e);
        }
        if(logger.isDebugEnabled()){
            logger.debug("这时debug日志");
        }
        logger.info("返回到findUserList.html页面");
        return "findUserList";
    }

    /**
     * 验证码页面
     * @return
     * @throws Exception
     */
     @RequestMapping("/verify")
     public String verifyHtml()throws Exception{
        return "verifyCode";
     }


}
