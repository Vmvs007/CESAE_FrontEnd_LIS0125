package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterpriseTest {

    private Enterprise empresa;

    private Employee manager;
    private Employee developer;
    private Employee intern;
    private Employee undefined;

    @BeforeEach
    void setUp() {
        empresa = new Enterprise();

        manager = new Employee("Diamantino Pereira da Silva", "Manager", 20.0);
        developer = new Employee("Roberto Sem Esperança", "Developer", 15.0);
        intern = new Employee("Jacinto Penedo", "Intern", 10.0);
        undefined = new Employee("Joaquim A.","HR",10.0);

    }

    @Test
    public void testEnterpriseStartsEmpty(){
        assertTrue(empresa.getEmployees().isEmpty());
    }

    @Test
    public void testAddEmployee(){
        empresa.addEmployee(manager);
        empresa.addEmployee(developer);

        assertEquals(2, empresa.getEmployees().size());

        empresa.addEmployee(intern);

        assertEquals(3, empresa.getEmployees().size());
    }

    @Test
    public void testRemoveEmployee(){
        empresa.addEmployee(manager);
        empresa.addEmployee(developer);
        empresa.addEmployee(intern);

        assertEquals(3, empresa.getEmployees().size());

        empresa.removeEmployee(manager);

        assertEquals(2, empresa.getEmployees().size());

        empresa.removeEmployee(developer);
        empresa.removeEmployee(intern);

        assertEquals(0, empresa.getEmployees().size());
    }

    @Test
    public void calculateTotalSalaries(){

        manager.setHoursWorked(10);
        developer.setHoursWorked(20);
        intern.setHoursWorked(2);

        empresa.addEmployee(manager);
        empresa.addEmployee(developer);
        empresa.addEmployee(intern);

        // ManagerSalary = 200
        // DeveloperSalary = 360
        // InternSalary = 16

        // TotalSalaries = 576
        assertEquals(576,empresa.calculateTotalSalaries());

        empresa.removeEmployee(intern);

        // TotalSalaries = 560
        assertEquals(560,empresa.calculateTotalSalaries());


    }
}