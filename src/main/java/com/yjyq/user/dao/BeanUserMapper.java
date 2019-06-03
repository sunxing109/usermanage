package com.yjyq.user.dao;

import com.yjyq.user.dto.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component

public interface BeanUserMapper {

    //查询
    @Select("select * from usert where id=#{id}")
    public List<User> selectId(String id);

    //删除
    @Delete("delete from usert where id=#{id}")
    public void deleteId(String id);

}
