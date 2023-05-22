package com.example.skyprospringhomework213testingmockito.model;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private double salary;

    public Employee(String firstName, String lastName, String department, double salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    @Override
    public String toString() {
        return  "ФИО: " + lastName + " " + firstName;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee e2 = (Employee) other;
        return firstName.equals(e2.firstName) && lastName.equals(e2.lastName);
    }
}
