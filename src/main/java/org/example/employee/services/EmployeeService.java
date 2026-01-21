package org.example.employee.services;


import org.example.employee.dto.EmployeeCreateDto;
import org.example.employee.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {
    public Employee createEmployee(EmployeeCreateDto employeeDetails);
}
