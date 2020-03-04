package com.shangguigu.bstest.controller;

import com.shangguigu.bstest.model.User;
import com.shangguigu.bstest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-01-02 17:55
 */

@Controller
public class LoginController {


    @Autowired
    private UserServiceImpl userServiceImpl;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Word";
    }


//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
//        if (!username.isEmpty()&&password.equals("123456")){
////            登录成功，防止刷新表单重复提交用重定向
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//        }else{
//            map.put("msg","邮箱或密码错误");
//            return "login";
//        }

        User user = userServiceImpl.LoginUser(username, password);
        if (user!=null){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","邮箱或密码错误");
            return "login";
        }

    }

//    @RequestMapping({"/dashboard.html"})
//    public String login(){
//        return "dashboard";
//    }



}
