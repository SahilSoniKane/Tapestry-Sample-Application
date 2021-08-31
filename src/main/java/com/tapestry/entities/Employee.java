package com.tapestry.entities;

import java.io.Serializable;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String address;

    public Employee(int id, String name, int age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
