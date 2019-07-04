package com.yjyq.user.restapicontroller;

import com.yjyq.user.dao.UserDao;
import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author sunxingba
 * @version 1.0 $
 */

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserRestController {

    /**
     *  用户Service
     */
    @Autowired
    public UserServiceImpl userService;

    /**
     *  获取所有用户
     * @return 用户列表
     */
    @GetMapping("/user")
    @ApiOperation("查询用户")
    @ApiImplicitParam(name="userId", value = "用户id" , defaultValue = "2", required = true)
    public User getUserById(String userId) throws Exception{
        User user =  userService.getUserById(userId);
        return user;
    }




}
