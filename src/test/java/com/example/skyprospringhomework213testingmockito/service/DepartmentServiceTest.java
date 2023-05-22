package com.example.skyprospringhomework213testingmockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.skyprospringhomework213testingmockito.constants.ServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImplMock;
    private DepartmentServiceImpl out;

    @Test
    public void shouldReturnCorrectSalarySumForDepartment(){
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertEquals(SALARY_1,out.getSalarySumForDepartment(DEPARTMENT_1));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnSalarySumForNotExistDepartment() {
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertThrows(RuntimeException.class,() -> out.getSalarySumForDepartment(DEPARTMENT_4));
        assertThrows(RuntimeException.class,() -> out.getSalarySumForDepartment(DEPARTMENT_NULL));
    }
    @Test
    public void shouldReturnCorrectEmployeesListForDepartment(){
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertEquals(EMPLOYEE_LIST_DEPARTMENT_1,out.printEmployeesListForDepartment(DEPARTMENT_1));
        assertEquals(EMPLOYEE_LIST_DEPARTMENT_2,out.printEmployeesListForDepartment(DEPARTMENT_2));
        assertEquals(EMPLOYEE_LIST_DEPARTMENT_3,out.printEmployeesListForDepartment(DEPARTMENT_3));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnEmployeesListForNotExistDepartment() {
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertThrows(RuntimeException.class,() -> out.printEmployeesListForDepartment(DEPARTMENT_4));
        assertThrows(RuntimeException.class,() -> out.printEmployeesListForDepartment(DEPARTMENT_NULL));
    }
    @Test
    public void shouldReturnCorrectEmployeesListByDepartment(){
        EMPLOYEE_LIST_BY_DEPARTMENT.put(DEPARTMENT_1,EMPLOYEE_LIST_DEPARTMENT_1);
        EMPLOYEE_LIST_BY_DEPARTMENT.put(DEPARTMENT_2,EMPLOYEE_LIST_DEPARTMENT_2);
        EMPLOYEE_LIST_BY_DEPARTMENT.put(DEPARTMENT_3,EMPLOYEE_LIST_DEPARTMENT_3);

        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertEquals(EMPLOYEE_LIST_BY_DEPARTMENT,out.printEmployeesListByDepartment());
    }
    @Test
    public void shouldReturnMaxSalaryForDepartment(){
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertEquals(SALARY_1,out.getMaxSalaryForDepartment(DEPARTMENT_1));
        assertEquals(SALARY_2,out.getMaxSalaryForDepartment(DEPARTMENT_2));
        assertEquals(SALARY_3,out.getMaxSalaryForDepartment(DEPARTMENT_3));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnMaxSalaryForNotExistDepartment() {
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertThrows(RuntimeException.class,() -> out.getMaxSalaryForDepartment(DEPARTMENT_4));
        assertThrows(RuntimeException.class,() -> out.getMaxSalaryForDepartment(DEPARTMENT_NULL));
    }
    @Test
    public void shouldReturnMinSalaryForDepartment(){

        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertEquals(SALARY_1,out.getMinSalaryForDepartment(DEPARTMENT_1));
        assertEquals(SALARY_2,out.getMinSalaryForDepartment(DEPARTMENT_2));
        assertEquals(SALARY_3,out.getMinSalaryForDepartment(DEPARTMENT_3));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnMinSalaryForNotExistDepartment() {
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
        out = new DepartmentServiceImpl(employeeServiceImplMock);

        assertThrows(RuntimeException.class,() -> out.getMinSalaryForDepartment(DEPARTMENT_4));
        assertThrows(RuntimeException.class,() -> out.getMinSalaryForDepartment(DEPARTMENT_NULL));
    }
}
