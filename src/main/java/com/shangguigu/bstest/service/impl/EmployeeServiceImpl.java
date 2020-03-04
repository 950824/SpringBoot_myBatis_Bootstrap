package com.shangguigu.bstest.service.impl;

import com.shangguigu.bstest.mapper.EmployeeMapper;
import com.shangguigu.bstest.model.Employee;
import com.shangguigu.bstest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-02-20 15:58
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeMapper.getEmployee(id);
    }

    @Override
    public int updataEmployee(Employee employee) {
        return employeeMapper.updataEmployee(employee);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }
}
