package com.example.skyprospringhomework213testingmockito.constants;

import com.example.skyprospringhomework213testingmockito.model.Employee;

import java.util.*;

public class ServiceTestConstants {

    public static String FIRST_NAME_1 = "Иван";
    public static String FIRST_NAME_2 = "Петр";
    public static String FIRST_NAME_3 = "Сергей";
    public static String LAST_NAME_1 = "Иванов";
    public static String LAST_NAME_2 = "Петров";
    public static String LAST_NAME_3 = "Сергеев";
    public static String DEPARTMENT_1 = "1";
    public static String DEPARTMENT_2 = "2";
    public static String DEPARTMENT_3 = "3";
    public static String DEPARTMENT_4 = "4";
    public static String DEPARTMENT_NULL = null;
    public static Double SALARY_1 = 10000.0;
    public static Double SALARY_2 = 20000.0;
    public static Double SALARY_3 = 30000.0;

    public static Employee EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1,DEPARTMENT_1, SALARY_1);
    public static Employee EMPLOYEE_2 = new Employee(FIRST_NAME_2, LAST_NAME_2,DEPARTMENT_2, SALARY_2);
    public static Employee EMPLOYEE_3 = new Employee(FIRST_NAME_3, LAST_NAME_3,DEPARTMENT_3, SALARY_3);

    public static final List<Employee> EMPLOYEE_LIST = List.of(
            EMPLOYEE_1,
            EMPLOYEE_2,
            EMPLOYEE_3
    );
    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT_1 = List.of(
            EMPLOYEE_1
    );
    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT_2 = List.of(
            EMPLOYEE_2
    );
    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT_3 = List.of(
            EMPLOYEE_3
    );
    public static Map<String, List<Employee>> EMPLOYEE_LIST_BY_DEPARTMENT = new HashMap<>();

}
