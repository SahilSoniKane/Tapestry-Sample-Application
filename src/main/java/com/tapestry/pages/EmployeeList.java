package com.tapestry.pages;

import com.tapestry.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    List<Employee> listOfEmployees = new ArrayList<>();

    public void addEmployee(int id, String name, int age, String address) {
        listOfEmployees.add(new Employee(id, name, age, address));
    }

    public List<Employee> getEmployeeList() {
        return listOfEmployees;
    }
}
