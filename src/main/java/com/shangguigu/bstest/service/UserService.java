package com.shangguigu.bstest.service;



import com.shangguigu.bstest.model.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-11-07 17:56
 */
public interface UserService {

    public List<User> getAllUser();

    public User getUser(int id);

    public int updataUser(User user);

    public List<User> getAllUserRedisTest();

    public User LoginUser(String userName,String password);
}
