package com.example.library_commonlang3_hw.controller;

import com.example.library_commonlang3_hw.model.Employee;
import com.example.library_commonlang3_hw.service.EmployeeBook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeBook employeeBook;

    public EmployeeController(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }


    @PostMapping({"/employees"})
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeBook.addEmployee(employee);
    }
}
