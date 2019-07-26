package com.yjyq.user.rest;

import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** 用户管理Rest接口swagger
 *  参考地址
 *  https://petstore.swagger.io
 * @author sunxingba
 * @version 1.0 $
 */
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/rest")
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
    public User getUserById(@RequestParam String userId) throws Exception{
        User user =  userService.getUserById(userId);
        return user;
    }

    /**
     *  获取所有用户
     * @return 用户列表
     */
    @GetMapping("/user/{userId}")
    @ApiOperation("查询用户")
    @ApiImplicitParam(name="userId", value = "用户id" , defaultValue = "2", required = true)
    public User getUserById2(@PathVariable String userId) throws Exception{
        User user =  userService.getUserById(userId);
        return user;
    }

    /**
     *  添加用户
     * @param user 用户json
     * @throws Exception
     */
    @PostMapping("/user")
    @ApiOperation("添加用户")
    public void addUser(@RequestBody User user) throws Exception{
        userService.addUser(user);
    }


    /**
     *  添加用户[注意必填项区别]
     * @throws Exception
     */
    @PostMapping("/user2")
    @ApiOperation("添加用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户名",required = true),
                        @ApiImplicitParam(name = "userSex", value = "性别", defaultValue = "男"),
                        @ApiImplicitParam(name = "userAge", value = "年龄",required = true),
                        @ApiImplicitParam(name = "userNo", value = "编号",required = true),
                        @ApiImplicitParam(name = "userPhoneNum", value = "联系方式", required = true),
                        @ApiImplicitParam(name = "userState", value = "用户状态", required = true)})
    public void addUser2(@RequestParam(required = true) String userName, String userSex, int userAge, String userNo, String userPhoneNum, String userState) throws Exception{
        User user = new User();
            user.setUserName(userName);
            user.setUserSex(userSex);
            user.setUserAge(userAge);
            user.setUserNo(userNo);
            user.setUserPhoneNum(userPhoneNum);
        userService.addUser(user);
    }


}