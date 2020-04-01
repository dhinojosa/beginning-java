package com.xyzcorp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    @Test
    public void testManager() {
        Employee employee = new Employee("Linda", "Rizzo", 40000);
        Employee employee2 = new Employee("Moses", "Palazzi", 43000);
        Employee employee3 = new Employee("Tyrell", "Dale", 45000);

        List<Employee> employees = List.of(employee, employee2, employee3);

        Manager manager = new Manager("Joy", "Khwaja", 130400, employees);

        assertEquals(manager.getFirstName(), "Joy");
        assertEquals(manager.getLastName(), "Khwaja");
        assertEquals(manager.getSalary(), 130400);
        assertEquals(manager.getEmployees(), employees);

    }
}
