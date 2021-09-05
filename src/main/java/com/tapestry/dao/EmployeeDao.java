package com.tapestry.dao;

import com.tapestry.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
   // int[] getAllId();
}
