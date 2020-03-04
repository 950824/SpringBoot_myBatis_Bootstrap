package com.shangguigu.bstest.mapper;

import com.shangguigu.bstest.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-02-20 15:42
 */
@Mapper
public interface EmployeeMapper {

    List<Employee> getAllEmployee();

    int updataEmployee(Employee employee);

    Employee getEmployee(int id);

    int addEmployee(Employee employee);

    int deleteEmployee(int id);

}
