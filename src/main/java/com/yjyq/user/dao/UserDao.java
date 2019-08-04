package com.yjyq.user.dao;


import com.yjyq.user.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  用户Dao
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 根据Id获取用户
     * @param userId
     * @return  用户信息
     */
    User getUserById(@Param("userId") String userId);

    /**
     *  查询所有用户信息
     * @return 所有用户信息
     */
    List<User> findUserList();

    /**
     *  添加用户
     * @param user 用户信息
     */
    void addUser(User user);

    /**
     *  更新用户
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     *  删除用户
     * @param userId 用Id
     */
    void deleteUserById(@Param("userId") String userId);
}
