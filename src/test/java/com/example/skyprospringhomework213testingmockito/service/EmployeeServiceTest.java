package com.example.skyprospringhomework213testingmockito.service;

import com.example.skyprospringhomework213testingmockito.model.Employee;
import org.junit.jupiter.api.Test;

import static com.example.skyprospringhomework213testingmockito.constants.ServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnCorrectEmployeeAfterAdd(){
        Employee result = out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        assertEquals(EMPLOYEE_1, result);
    }
    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToAddExistEmployee() {
        out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        assertThrows(RuntimeException.class,
                () -> out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1)
        );
    }
    @Test
    public void shouldReturnCorrectEmployeeAfterRemove(){
        out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee result = out.removeEmployee(FIRST_NAME_1, LAST_NAME_1);
        assertEquals(EMPLOYEE_1, result);
    }
    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToRemoveNotExistEmployee() {
        assertThrows(RuntimeException.class,
                () -> out.removeEmployee(FIRST_NAME_1, LAST_NAME_1)
        );
    }
    @Test
    public void shouldReturnCorrectEmployeeAfterFind(){
        out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee result = out.findEmployee(FIRST_NAME_1, LAST_NAME_1);
        assertEquals(EMPLOYEE_1, result);
    }
    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToFindNotExistEmployee() {
        assertThrows(RuntimeException.class,
                () -> out.removeEmployee(FIRST_NAME_1, LAST_NAME_1)
        );
    }

}
