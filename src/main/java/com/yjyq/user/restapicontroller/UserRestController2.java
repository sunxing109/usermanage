package com.yjyq.user.restapicontroller;

import com.yjyq.user.dao.UserDao;
import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunxingba
 * @version 1.0 $
 */

@RestController
@Api(tags = "用户管理相关接口2")
@RequestMapping("/user2")
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


}
