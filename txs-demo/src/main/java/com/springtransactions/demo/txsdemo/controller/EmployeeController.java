package com.springtransactions.demo.txsdemo.controller;

import com.springtransactions.demo.txsdemo.model.Employee;
import com.springtransactions.demo.txsdemo.repository.EmployeeRepo;
import com.springtransactions.demo.txsdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.createEmployee(employee);
    }
}
