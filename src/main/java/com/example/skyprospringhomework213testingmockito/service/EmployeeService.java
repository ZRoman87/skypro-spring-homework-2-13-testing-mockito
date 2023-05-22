package com.example.skyprospringhomework213testingmockito.service;

import com.example.skyprospringhomework213testingmockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, String department, double salary);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> printEmployees();

}
