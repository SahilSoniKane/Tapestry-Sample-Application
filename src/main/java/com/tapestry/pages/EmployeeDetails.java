package com.tapestry.pages;

import com.tapestry.entities.Employee;
import com.tapestry.services.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class EmployeeDetails {

    @Inject
    private EmployeeService employeeService;

    @Property
    private Employee employee;

    void onActivate(int id) {
        this.employee = employeeService.getEmployeeById(id);
    }

//    int onPassivate() {
//        return this.id;
//    }

}
