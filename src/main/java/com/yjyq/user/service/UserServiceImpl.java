package com.yjyq.user.service;


import com.yjyq.user.dao.BeanUserMapper;
import com.yjyq.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl {

    @Autowired
    private BeanUserMapper beanUserMapper;

    public List<User> findUser() throws Exception{

        return beanUserMapper.selectId("201901");
    }
}
