package com.yjyq.user.service;

import com.yjyq.user.dao.UserDao;
import com.yjyq.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl {

    /**
     *  用户Dao
     */
    @Autowired
    private UserDao userDao;

    /**
     *  根据用户Id获取用户信息
     * @param userId 用户Id
     * @return 用户信息
     * @throws Exception
     */
    public User getUserById(String userId) throws Exception {
        return userDao.getUserById(userId);
    }

    /**
     *  查询所有用户信息
     * @return 用户信息集合
     * @throws Exception
     */
    public List<User> findUserList() throws Exception{
        return userDao.findUserList();
    }

    /**
     *  添加用户
     * @param user 用户信息
     */
    public void addUser(User user) throws Exception{
        userDao.addUser(user);
    }
}
