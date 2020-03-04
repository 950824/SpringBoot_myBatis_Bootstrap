package com.shangguigu.bstest.controller;

import com.shangguigu.bstest.model.Employee;
import com.shangguigu.bstest.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author shkstart
 * @create 2020-01-18 17:22
 */
@Controller
public class EmployeelisController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/employee")
    public String Employee(Model model){
        List<Employee> allEmployee = employeeServiceImpl.getAllEmployee();

        model.addAttribute("allEmployee",allEmployee);
        return "employee";
    }

    //跳转到添加员工页面
    @GetMapping("/addEmployee")
    public String addEmployee(){
        return "addEmployee";
    }

    //添加员工
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和Bean的对象的参数名字一样
    @PostMapping("/add")
    public String add(Employee employee){
        System.out.println("保存的员工信息："+employee.toString());
        employeeServiceImpl.addEmployee(employee);

        //redirect:表示重定向到一个地址 /代表当前项目路径
        //forward：表示转发到一个地址
        return "redirect:/employee";
    }

    @GetMapping("/editEmployee/{id}")
    public String addEmployee(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeServiceImpl.getEmployee(id);
        model.addAttribute("employee", employee);

        return "addEmployee";
    }

    @PutMapping("/add")
    public String addPut(Employee employee){
        System.out.println("修改的员工信息："+employee.toString());
        employeeServiceImpl.updataEmployee(employee);
        return "redirect:/employee";
    }


    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeServiceImpl.deleteEmployee(id);
        return "redirect:/employee";
    }



}
