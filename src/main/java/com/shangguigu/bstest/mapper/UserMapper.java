package com.shangguigu.bstest.mapper;


import com.shangguigu.bstest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-11-07 18:14
 */
@Mapper
public interface UserMapper {

    List<User> getAllUser();

    int updataUser(User user);

    User getUser(int id);

    User loginUser(@Param("userName") String userName, @Param("password") String password);
}
