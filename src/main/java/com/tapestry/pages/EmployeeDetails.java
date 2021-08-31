package com.tapestry.pages;

import com.tapestry.entities.Employee;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import java.util.List;

public class EmployeeDetails extends EmployeeList {

    @Property
    private int id;
    @Property
    private String name;
    @Property
    private int age;
    @Property
    private String address;

    @Property
    private Employee employee;

    @InjectPage
    private EmployeeList employeeList;

    public void set(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void onActivate(int id) {
        this.id = id;
    }

    int onPassivate() {
        return this.id;
    }

    public Employee getEmployeeDetails() {
        for (Employee employee: employeeList.getEmployeeList()) {
            if (employee.getId() == this.id)
                this.employee = employee;
        }
        return this.employee;
    }
}
