package com.shangguigu.bstest.service;

import com.shangguigu.bstest.model.Employee;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-02-20 15:57
 */
public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee getEmployee(int id);

    public int updataEmployee(Employee employee);

    public int addEmployee(Employee employee);

    public int deleteEmployee(int id);
}
