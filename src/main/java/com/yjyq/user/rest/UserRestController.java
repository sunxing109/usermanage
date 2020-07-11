package com.yjyq.user.rest;

import com.yjyq.user.dto.CompanyDTO;
import com.yjyq.user.dto.User;
import com.yjyq.user.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;


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
    @GetMapping("/users")
    @ApiOperation("查询用户")
    public List<User> getUsers() throws Exception{
        // 查询所有用户
        List<User> userList = userService.findUserList();
        System.out.println(userList);
        return userList;
    }

    /**
     *  获取用户
     * @return 用户
     */
    @GetMapping("/user")
    @ApiOperation("查询用户")
    @ApiImplicitParam(name="userId", value = "用户id" , defaultValue = "2", required = true)
    public User getUserById(@RequestParam String userId) throws Exception{

        Date date = new Date();
        User user =  userService.getUserById(userId);
        return user;
    }

    /**
     *  获取用户
     * @return 用户
     */
    @GetMapping("/user/{userId}")
    @ApiOperation("查询用户")
    @ApiImplicitParam(name="userId", value = "用户id" , defaultValue = "2", required = true)
    public User getUserById2(@PathVariable String userId) throws Exception{
        User user =  userService.getUserById(userId);
        return user;
    }


    @DeleteMapping("/user")
    @ApiOperation("根据Id删除用户")
    @ApiImplicitParam(name="userId", value = "用户id", required = true)
    public void deleteUserById(@RequestParam String userId) throws Exception {
        userService.deleteUserById(userId);
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
     *  添加用户
     * @param user 用户json
     * @throws Exception
     */
    @PutMapping("/user")
    @ApiOperation("添加用户")
    public void updateUser(@RequestBody User user) throws Exception{
        userService.updateUser(user);
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
    public void addUser2(String userName, String userSex, int userAge, String userNo, String userPhoneNum, String userState) throws Exception{
        User user = new User();
            user.setUserName(userName);
            user.setUserSex(userSex);
            user.setUserAge(userAge);
            user.setUserNo(userNo);
            user.setUserPhoneNum(userPhoneNum);
            user.setUserState(userState);
        userService.addUser(user);
    }

    @RequestMapping("/getUserAndCompanyInfo")
    @ApiOperation("获取公司及个人信息")
    public Map<String,Object> getUserAndCompanyInfo(@RequestParam String userID) throws Exception{

        User user = new User();
        user.setUserType("企业用户");
        user.setPhone("15592487001");
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyName("西安长城数字有限责任公司");
        companyDTO.setPublishedNum("55");
        companyDTO.setTaskApplyNum("22");
        companyDTO.setTotalScore("300");
        Map<String,Object> map = new HashMap<>();
        map.put("userInfo",user);
        map.put("companyInfo",companyDTO);
        return map;
    }

    @RequestMapping("/checkUserExist")
    @ApiOperation("获取开发者服务端sessionId")
    public Map<String,String> checkUserExist(@RequestParam String js_code) throws Exception{

        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx8b261688f5172a66&secret=c41ceeacb60f98f5121855c0297bbc91&js_code="+js_code+"&grant_type=authorization_code";
        //发送get请求到微信服务端获取 用户唯一ID
        ResponseEntity<String> response = restTemplate().getForEntity(requestUrl, String.class);
        System.out.println(response.getBody());
        // {"session_key":"xoeSdT+9qaSr3Z+EYgE0+Q==","openid":"oJYuB4syi9OtcMwUqFcYekLd_nlE"}

        // 需要生成一个userID 与用于信息绑定，将userID 返回给客户端用于保存，这样小程序每次调用传入userID,服务端就能判断用户

//        1.调用微信接口 获取用户唯一openid
//        2.保存用户，根据用户类型判断是否需要保存公司信息，如果是个人用户那么companyDTO 参数为空
//        3.保存用户和公司的映射关系
        Map<String,String> map = new HashMap<>();
        map.put("userID","userID");
        map.put("existStatus","true");
        return map;
    }

    @RequestMapping("/register")
    @ApiOperation("获取开发者服务端sessionId")
    public Map<String,String> register(@RequestParam String js_code,@RequestParam String userDTO,@RequestParam String companyDTO) throws Exception{
        System.out.println(userDTO);
        System.out.println(companyDTO);
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx8b261688f5172a66&secret=c41ceeacb60f98f5121855c0297bbc91&js_code="+js_code+"&grant_type=authorization_code";
        //发送get请求到微信服务端获取 用户唯一ID
        ResponseEntity<String> response = restTemplate().getForEntity(requestUrl, String.class);
        System.out.println(response.getBody());
        // {"session_key":"xoeSdT+9qaSr3Z+EYgE0+Q==","openid":"oJYuB4syi9OtcMwUqFcYekLd_nlE"}

        // 需要生成一个userID 与用于信息绑定，将userID 返回给客户端用于保存，这样小程序每次调用传入userID,服务端就能判断用户

//        1.调用微信接口 获取用户唯一openid
//        2.保存用户，根据用户类型判断是否需要保存公司信息，如果是个人用户那么companyDTO 参数为空
//        3.保存用户和公司的映射关系
        Map<String,String> map = new HashMap<>();
        map.put("userID","userID");
        map.put("saveStatus","success");
        return map;
    }

        //        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
//        String appid = "wx8b261688f5172a66"; // 小程序appId
//        String secret = "c41ceeacb60f98f5121855c0297bbc91";// 小程序 appSecret


//        RestTemplate client = new RestTemplate();
//        HttpMethod method = HttpMethod.GET;
//        // 以表单的方式提交
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("appid","wx8b261688f5172a66");
//        params.add("secret","c41ceeacb60f98f5121855c0297bbc91");
//        params.add("js_code",js_code);
//        params.add("grant_type","authorization_code");
//
//        //将请求头部和参数合成一个请求
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//        //执行HTTP请求，将返回的结构使用String 类格式化
//        ResponseEntity<String> response = client.exchange(requestUrl, method, requestEntity, String.class);
//        System.out.println(response);



        //发送post请求
//        ResponseEntity<String> response = restTemplate().postForEntity(requestUrl, request, String.class);
        //发送get请求
//        ResponseEntity<String> response = restTemplate().getForEntity(requestUrl, String.class);
//        System.out.println(response.getBody());
//
//        return "success";
//    }

    /**
     *  rest接口请求
     * @return
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }


}
