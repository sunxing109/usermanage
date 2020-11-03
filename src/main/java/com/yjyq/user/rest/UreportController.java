package com.yjyq.user.rest;

import com.bstek.ureport.console.res.ResourceLoaderServletAction;
import com.yjyq.user.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Api(tags = "报表对外管理相关接口")
@RequestMapping("/urep")
public class UreportController {

    @Resource
    ResourceLoaderServletAction resourceLoaderServletAction;
    /**
     *  获取所有用户
     * @return 用户列表
     */
    @GetMapping("/reports")
    @ApiOperation("查询本地服资源提供")
    public List<User> getUsers() throws Exception{
        HttpServletRequest req = null;
        HttpServletResponse resp = null;
        resourceLoaderServletAction.execute(req,resp);

        // 查询所有用户
        List<User> userList = null;
        System.out.println(userList);
        return userList;
    }
}
