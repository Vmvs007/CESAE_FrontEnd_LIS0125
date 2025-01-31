package org.example;

public class Main {
    public static void main(String[] args) {
        Enterprise enterprise = new Enterprise();
        Employee manager = new Employee("Diamantino Pereira da Silva", "Manager", 20.0);
        Employee developer = new Employee("Roberto Sem Esperança", "Developer", 15.0);
        Employee intern = new Employee("Jacinto Penedo", "Intern", 10.0);
        enterprise.addEmployee(manager);
        enterprise.addEmployee(developer);
        enterprise.addEmployee(intern);
        double totalSalaries = enterprise.calculateTotalSalaries();
        System.out.println("Total salaries: " + totalSalaries);
    }
}