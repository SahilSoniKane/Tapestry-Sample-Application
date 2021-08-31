package com.tapestry.pages;

import com.tapestry.entities.Employee;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

import java.util.ArrayList;
import java.util.List;

public class Employees extends EmployeeList{

    @Property
    private Employee employee;

    @InjectPage
    private EmployeeList employeeList;

    public List<Employee> getEmployees() {
        List<Employee> listOfEmployees = employeeList.getEmployeeList();

        return listOfEmployees;
    }
}
//onActivate and onPassivate