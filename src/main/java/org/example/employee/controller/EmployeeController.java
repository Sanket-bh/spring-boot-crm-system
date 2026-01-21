package org.example.employee.controller;


import org.example.employee.dto.EmployeeCreateDto;
import org.example.employee.model.Employee;
import org.example.employee.repository.EmployeeRepository;
import org.example.employee.services.EmployeeService;
import org.example.employee.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/employees")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeCreateDto dto){
        Employee employee=employeeService.createEmployee(dto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

}
