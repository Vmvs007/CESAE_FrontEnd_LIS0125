package org.example;

public class Employee {
    private String name;
    private String position;
    private int hoursWorked;
    private double hourlyRate;

    public Employee(String name, String position, double hourlyRate) {
        this.name = name;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        double salary = 0.0;
        if (position.equals("Manager")) {
            salary = hourlyRate * hoursWorked;
        } else if (position.equals("Developer")) {
            salary = hourlyRate * hoursWorked * 1.2;
        } else if (position.equals("Intern")) {
            salary = hourlyRate * hoursWorked * 0.8;
        }
        return salary;
    }
}