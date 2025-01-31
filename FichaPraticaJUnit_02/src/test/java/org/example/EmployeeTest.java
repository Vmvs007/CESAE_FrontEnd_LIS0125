package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee manager;
    private Employee developer;
    private Employee intern;
    private Employee undefined;

    @BeforeEach
    void setUp() {
        manager = new Employee("Diamantino Pereira da Silva", "Manager", 20.0);
        developer = new Employee("Roberto Sem Esperança", "Developer", 15.0);
        intern = new Employee("Jacinto Penedo", "Intern", 10.0);
        undefined = new Employee("Joaquim A.","HR",10.0);
    }

    @Test
    public void testHoursWorkedStartAtZero(){
        assertEquals(0,manager.getHoursWorked());
        assertEquals(0,developer.getHoursWorked());
        assertEquals(0,intern.getHoursWorked());
    }

    @Test
    public void testSetHoursWorked(){
        manager.setHoursWorked(40);
        assertEquals(40,manager.getHoursWorked());

        intern.setHoursWorked(10);
        assertEquals(10,intern.getHoursWorked());
    }

    @Test
    public void testCalculateSalaryManager(){
        assertEquals(0,manager.calculateSalary());

        manager.setHoursWorked(10);

        assertEquals(200,manager.calculateSalary());

        manager.setHoursWorked(20);

        assertEquals(400,manager.calculateSalary());

    }

    @Test
    public void testCalculateSalaryDeveloper(){
        assertEquals(0,developer.calculateSalary());

        developer.setHoursWorked(10);

        assertEquals(180,developer.calculateSalary());

        developer.setHoursWorked(20);

        assertEquals(360,developer.calculateSalary());
    }

    @Test
    public void testCalculateSalaryIntern(){
        assertEquals(0,intern.calculateSalary());

        intern.setHoursWorked(10);

        assertEquals(80,intern.calculateSalary());

        intern.setHoursWorked(20);

        assertEquals(160,intern.calculateSalary());
    }

    @Test
    public void testCalculateSalaryUndefined(){
        assertEquals(0,undefined.calculateSalary());

        undefined.setHoursWorked(10);

        assertEquals(100,undefined.calculateSalary());

        undefined.setHoursWorked(20);

        assertEquals(200,undefined.calculateSalary());
    }
}