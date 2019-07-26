package com.yjyq.user.rest;

import com.yjyq.user.dto.Book;
import com.yjyq.user.dto.Cat;
import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunxingba
 * @version 1.0 $
 */

@RestController
@Api(tags = "用户管理相关接口2")
@RequestMapping("/rest2")
public class UserRestController2 {

    /**
     * 用户Service
     */
    @Autowired
    public UserServiceImpl userService;

    /**
     *  获取所有用户
     * @return 用户列表
     */
    @GetMapping("/users")
    @ApiOperation("查询用户")
    public List<User> getUsers() throws Exception{
        // 查询所有用户
        List<User> userList = userService.findUserList();
        System.out.println(userList);
        return userList;
    }

    /**
     * http://localhost:8081/hello2?c.name=cat&b.name=book
     * @param cat
     * @param book
     * @return
     */
    @RequestMapping("/getInfo")
    public String getInfo(@ModelAttribute("c") Cat cat, @ModelAttribute("b") Book book) {
        String testString = "hello controller advice";
        System.out.println(cat);
        System.out.println(book);
        return testString;

    }

//    @CrossOrigin(value = "http://localhost:8082")
    @GetMapping("/hello")
    public String hello() {
        return "get hello1";
    }

    @CrossOrigin(value = "http://localhost:8082")
    @PostMapping("/hello")
    public String hello2(){
        return "post hello1";
    }

}
