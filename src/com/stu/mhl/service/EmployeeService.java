package com.stu.mhl.service;

import com.stu.mhl.dao.EmployeeDAO;
import com.stu.mhl.domain.Employee;

/**
 * @author Mark He
 * @version 1.0
 * 该类完成对employee表的各种操作，通过调用employeeDAO对象完成
 */
public class EmployeeService {
    //定义一个employeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法，根据empId和pwd返回一个Employee对象
    //如果查询不到，就返回null
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        return employeeDAO
                .querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);

    }
}
