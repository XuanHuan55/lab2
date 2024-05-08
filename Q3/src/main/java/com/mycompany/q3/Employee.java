/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q3;

import java.util.*;

/**
 *
 * @author ASUS
 */
import java.util.*;

class Employee {
    private String employeeCode;
    private String fullName;
    private int yearsOfService;
    private double salaryCoefficient;
    private static double basicSalary;

    public Employee() {
    }

    public Employee(String employeeCode, String fullName, int yearsOfService, double salaryCoefficient) {
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.yearsOfService = yearsOfService;
        this.salaryCoefficient = salaryCoefficient;
    }

    public double calculateSalary() {
        return salaryCoefficient * basicSalary;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public static void setBasicSalary(double basicSalary) {
        Employee.basicSalary = basicSalary;
    }
    public void Do_Q3(){
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();
        Employee.setBasicSalary(basicSalary);

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("Employee code: ");
            String employeeCode = scanner.next();
            System.out.print("Full name: ");
            String fullName = scanner.next();
            System.out.print("Years of service: ");
            int yearsOfService = scanner.nextInt();
            System.out.print("Salary coefficient: ");
            double salaryCoefficient = scanner.nextDouble();

            Employee employee = new Employee(employeeCode, fullName, yearsOfService, salaryCoefficient);
            employees.add(employee);
        }
        System.out.println("\nSalary Sheet:");
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getFullName() + ", Salary: " + employee.calculateSalary());
        }

        System.out.println("\nEmployees with the highest salary:");
        double maxSalary = 0;
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }
        for (Employee employee : employees) {
            if (employee.calculateSalary() == maxSalary) {
                System.out.println("Employee: " + employee.getFullName() + ", Salary: " + employee.calculateSalary());
            }
        }

        System.out.println("\nEmployees' salaries in decreasing order:");
        employees.sort(Comparator.comparingDouble(Employee::calculateSalary).reversed());
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getFullName() + ", Salary: " + employee.calculateSalary());
        }
    }
}
