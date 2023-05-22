package com.example.skyprospringhomework213testingmockito.service;

import com.example.skyprospringhomework213testingmockito.model.Employee;
import org.springframework.stereotype.Service;
import com.example.skyprospringhomework213testingmockito.exception.DepartmentNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;
    //private final Collection<Employee> employees;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
        //employees = employeeService.printEmployees();
    }
    @Override
    public double getMaxSalaryForDepartment(String department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(e->e.getSalary())
                .max()
                .orElseThrow(DepartmentNotFoundException::new);
    }
    @Override
    public double getMinSalaryForDepartment(String department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(e->e.getSalary())
                .min()
                .orElseThrow(DepartmentNotFoundException::new);
    }
    @Override
    public List<Employee> printEmployeesListForDepartment(String department) {
        employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .findAny()
                .orElseThrow(DepartmentNotFoundException::new);

        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
    @Override
    public Map<String, List<Employee>> printEmployeesListByDepartment() {
        return employeeService.printEmployees().stream()
               .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    @Override
    public double getSalarySumForDepartment(String department) {
        employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .findAny()
                .orElseThrow(DepartmentNotFoundException::new);

        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(e->e.getSalary())
                .sum();
    }

}
