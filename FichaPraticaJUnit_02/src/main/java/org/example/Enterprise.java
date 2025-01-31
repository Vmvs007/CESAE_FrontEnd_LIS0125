package org.example;

import java.util.ArrayList;
import java.util.List;

public class Enterprise {
    private ArrayList<Employee> employees;

    public Enterprise() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public double calculateTotalSalaries() {
        double totalSalaries = 0.0;
        for (Employee employee : employees) {
            totalSalaries = employee.calculateSalary();
        }
        return totalSalaries;
    }
}