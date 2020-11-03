package com.yjyq.user.rest;

import com.yjyq.user.dto.Book;
import com.yjyq.user.dto.Cat;
import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import com.yjyq.user.util.VerifyCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

//    @CrossOrigin(value = "http://localhost:8082")
    @PostMapping("/hello")
    public String hello2(){
        return "post hello1";
    }

    /**
     * 生成验证码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/createCode")
    public void createCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCode.generateVerifyCode(4);
        //存入会话session
        req.getSession().setAttribute("CODE", verifyCode.toLowerCase());

        //生成图片
        int width = 100;//宽
        int height = 40;//高
        VerifyCode.outputImage(width, height, resp.getOutputStream(), verifyCode);
    }

    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        String key = (String) req.getSession().getAttribute("CODE");
        if(code != null && code.equalsIgnoreCase(key)){
            req.getSession().removeAttribute("CODE");
            resp.getWriter().println(true);
        }else{
            resp.getWriter().println(false);
        }
    }

}
