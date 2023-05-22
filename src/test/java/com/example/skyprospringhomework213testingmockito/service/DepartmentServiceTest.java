package com.example.skyprospringhomework213testingmockito.service;

import com.example.skyprospringhomework213testingmockito.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static com.example.skyprospringhomework213testingmockito.constants.ServiceTestConstants.*;
import static com.example.skyprospringhomework213testingmockito.constants.ServiceTestConstants.EMPLOYEE_LIST_DEPARTMENT_3;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImplMock;
    @InjectMocks
    private DepartmentServiceImpl out;

    public static Stream<Arguments> shouldReturnCorrectSalarySumForDepartmentParams() {
        return Stream.of(
                Arguments.of(DEPARTMENT_1, SALARY_SUM_1),
                Arguments.of(DEPARTMENT_2, SALARY_SUM_2),
                Arguments.of(DEPARTMENT_3, SALARY_SUM_3)
        );
    }
    public static Stream<Arguments> shouldReturnCorrectEmployeesListForDepartmentParams() {
        return Stream.of(
                Arguments.of(DEPARTMENT_1, EMPLOYEE_LIST_DEPARTMENT_1),
                Arguments.of(DEPARTMENT_2, EMPLOYEE_LIST_DEPARTMENT_2),
                Arguments.of(DEPARTMENT_3, EMPLOYEE_LIST_DEPARTMENT_3)
        );
    }
    public static Stream<Arguments> shouldReturnMaxSalaryForDepartmentParams() {
        return Stream.of(
                Arguments.of(DEPARTMENT_1, SALARY_MAX_1),
                Arguments.of(DEPARTMENT_2, SALARY_MAX_2),
                Arguments.of(DEPARTMENT_3, SALARY_MAX_3)
        );
    }
    public static Stream<Arguments> shouldReturnMinSalaryForDepartmentParams() {
        return Stream.of(
                Arguments.of(DEPARTMENT_1, SALARY_MIN_1),
                Arguments.of(DEPARTMENT_2, SALARY_MIN_2),
                Arguments.of(DEPARTMENT_3, SALARY_MIN_3)
        );
    }

    @BeforeEach
    public void beforeEach(){
        when(employeeServiceImplMock.printEmployees()).thenReturn(EMPLOYEE_LIST);
    }
    @ParameterizedTest
    @MethodSource("shouldReturnCorrectSalarySumForDepartmentParams")
    public void shouldReturnCorrectSalarySumForDepartment(String departmentId, double expected){
        assertEquals(expected,out.getSalarySumForDepartment(departmentId));
    }
    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnSalarySumForNotExistDepartment() {
        assertThrows(RuntimeException.class,() -> out.getSalarySumForDepartment(DEPARTMENT_NOT_EXIST));
        assertThrows(RuntimeException.class,() -> out.getSalarySumForDepartment(DEPARTMENT_NULL));
    }
    @ParameterizedTest
    @MethodSource("shouldReturnCorrectEmployeesListForDepartmentParams")
    public void shouldReturnCorrectEmployeesListForDepartment(String departmentId, List<Employee> expected){
        assertEquals(expected,out.printEmployeesListForDepartment(departmentId));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnEmployeesListForNotExistDepartment() {
        assertThrows(RuntimeException.class,() -> out.printEmployeesListForDepartment(DEPARTMENT_NOT_EXIST));
        assertThrows(RuntimeException.class,() -> out.printEmployeesListForDepartment(DEPARTMENT_NULL));
    }
    @Test
    public void shouldReturnCorrectEmployeesListByDepartment(){
        assertEquals(EMPLOYEE_LIST_BY_DEPARTMENT,out.printEmployeesListByDepartment());
    }
    @ParameterizedTest
    @MethodSource("shouldReturnMaxSalaryForDepartmentParams")
    public void shouldReturnMaxSalaryForDepartment(String departmentId, double expected){
        assertEquals(expected,out.getMaxSalaryForDepartment(departmentId));
    }
    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnMaxSalaryForNotExistDepartment() {
        assertThrows(RuntimeException.class,() -> out.getMaxSalaryForDepartment(DEPARTMENT_NOT_EXIST));
        assertThrows(RuntimeException.class,() -> out.getMaxSalaryForDepartment(DEPARTMENT_NULL));
    }
    @ParameterizedTest
    @MethodSource("shouldReturnMinSalaryForDepartmentParams")
    public void shouldReturnMinSalaryForDepartment(String departmentId, double expected){
        assertEquals(expected,out.getMinSalaryForDepartment(departmentId));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToReturnMinSalaryForNotExistDepartment() {
        assertThrows(RuntimeException.class,() -> out.getMinSalaryForDepartment(DEPARTMENT_NOT_EXIST));
        assertThrows(RuntimeException.class,() -> out.getMinSalaryForDepartment(DEPARTMENT_NULL));
    }
}
