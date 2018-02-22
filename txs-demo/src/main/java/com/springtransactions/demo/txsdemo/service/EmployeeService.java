package com.springtransactions.demo.txsdemo.service;

import com.springtransactions.demo.txsdemo.model.Employee;
import com.springtransactions.demo.txsdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeService  {

    @Autowired
    EmployeeRepo repo;

    @Transactional(rollbackFor = Exception.class)
    public Employee createEmployee(Employee employee) throws Exception {
        Employee emp = repo.save(employee);
        throw new Exception();
    }
}
