package com.example.skyprospringhomework213testingmockito.service;

import com.example.skyprospringhomework213testingmockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    double getMaxSalaryForDepartment(String department);
    double getMinSalaryForDepartment(String department);
    List<Employee> printEmployeesListForDepartment(String department);
    Map<String, List<Employee>> printEmployeesListByDepartment();
    double getSalarySumForDepartment(String department);
}
