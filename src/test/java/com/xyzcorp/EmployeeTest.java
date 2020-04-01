package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void testCreationOfEmployee() {
        Employee employee = new Employee("Sadie", "Jimenez", 40234);
        assertEquals(40234, employee.getSalary());
        assertEquals("Sadie", employee.getFirstName());
        assertEquals("Jimenez", employee.getLastName());
    }

}
