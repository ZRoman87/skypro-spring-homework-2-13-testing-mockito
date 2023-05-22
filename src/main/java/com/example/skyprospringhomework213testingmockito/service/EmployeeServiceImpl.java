package com.example.skyprospringhomework213testingmockito.service;

import com.example.skyprospringhomework213testingmockito.exception.EmployeeAlreadyAddedException;
import com.example.skyprospringhomework213testingmockito.exception.EmployeeBadRequestException;
import com.example.skyprospringhomework213testingmockito.exception.EmployeeNotFoundException;
import com.example.skyprospringhomework213testingmockito.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, String department, double salary) {

        checkInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);

        if (!employees.containsKey(employee.getFullName())) {
            employees.put(employee.getFullName(), employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        checkInput(firstName,lastName);

        String key = getKey(firstName,lastName);

        if (employees.containsKey(key)) {
            return employees.remove(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {

        checkInput(firstName,lastName);
        String key = getKey(firstName,lastName);

        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Collection<Employee> printEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String getKey (String firstName, String lastName) {
        return lastName + " " + firstName;
    }
    private void checkInput (String firstName, String lastName) {
        if (!(isAlpha(firstName)&&isAlpha(lastName))) {
            throw new EmployeeBadRequestException();
        }
    }

}
