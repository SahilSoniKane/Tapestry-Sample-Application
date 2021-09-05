package com.tapestry.pages;

import com.tapestry.entities.Employee;
import com.tapestry.services.EmployeeService;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    public List<Employee> getEmployees() {

        return employeeService.getAllEmployees();
    }
}
//onActivate and onPassivate