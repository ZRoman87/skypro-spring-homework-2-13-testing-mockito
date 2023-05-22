package com.example.skyprospringhomework213testingmockito.controller;

import com.example.skyprospringhomework213testingmockito.service.DepartmentServiceImpl;
import com.example.skyprospringhomework213testingmockito.model.Employee;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/salary/max")
    public double getMaxSalaryForDepartment(@PathVariable(required = false) String id) {
        return departmentService.getMaxSalaryForDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public double getMinSalaryForDepartment(@PathVariable(required = false) String id) {
        return departmentService.getMinSalaryForDepartment(id);
    }
    @GetMapping(path = "/{id}/salary/sum")
    public Double getSalarySumForDepartment(@PathVariable(required = false) String id) {
        return departmentService.getSalarySumForDepartment(id);
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> printEmployeesListForDepartment(@PathVariable(required = false) String id) {
        return departmentService.printEmployeesListForDepartment(id);
    }
    @GetMapping(path = "/employees")
    public Map<String, List<Employee>> printEmployeesListByDepartment() {
        return departmentService.printEmployeesListByDepartment();
    }

}
