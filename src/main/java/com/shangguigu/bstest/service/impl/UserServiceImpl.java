package com.shangguigu.bstest.service.impl;



import com.shangguigu.bstest.mapper.UserMapper;
import com.shangguigu.bstest.model.User;
import com.shangguigu.bstest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-11-07 17:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Transactional
    @Override
    public int updataUser(User user) {
        int i1 = userMapper.updataUser(user);
        int i = 10/0;//制造错误让其回滚
        return i1;
    }

    @Override
    public User LoginUser(String userName, String password) {
        return userMapper.loginUser(userName,password);
    }

    @Override
    public List<User> getAllUserRedisTest() {
        return null;
    }

//    //实例化一个Redis 样式只有Object,Object 或 String,String
//    @Autowired
//    private RedisTemplate<Object,Object> redisTemplate;
//
//
//    @Override
//    public List<User> getAllUserRedisTest() {
//
//        //字符串序列化 不然要在User中添加序列化Serializer
//        RedisSerializer redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//
////        高并发条件下，可能会出现：缓存穿透
////        Redis主要是用于查询缓存，避免服务器冗余
////        如果redis内已经存有便直接取出赋值，不必查询数据库
//        List<User> users = (List<User>) redisTemplate.opsForValue().get("Users");
//
//        //双重检测 可以避免穿透
//        if (null == users){
//            synchronized (this){
//                //为这里要再次从Redis中获取值？因为当第一次访问时可能多个同时走了synchronized但只有一个能真正往下走，
////                此时被卡在synchronized的只能等待，第一个全程走完才放行，当它们走时，Redis已经缓存了，所以此处再次访问赋值是
////                再次确定，有了就不用访问数据库了
//
//                users = (List<User>) redisTemplate.opsForValue().get("Users");
//                if (null == users){
//                    //查询数据库
//                    users = userMapper.getAllUser();
//                    //并存入Redis中
//                    redisTemplate.opsForValue().set("Users",users);
//                    System.out.println("查询数据库");
//                }else {
//                    System.out.println("查询缓存");
//                }
//            }
//        }else {
//            System.out.println("查询缓存");
//        }
//
//        return users;
//
//    }


}
