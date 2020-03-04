package com.shangguigu.bstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shkstart
 * @create 2020-02-19 18:20
 */
@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
