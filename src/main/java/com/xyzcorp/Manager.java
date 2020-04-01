package com.xyzcorp;

import java.util.List;

public class Manager extends Employee {
    private List<Employee> employees;

    public Manager(String firstName, String lastName, int salary,
                   List<Employee> employees) {
        super(firstName, lastName, salary);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}
