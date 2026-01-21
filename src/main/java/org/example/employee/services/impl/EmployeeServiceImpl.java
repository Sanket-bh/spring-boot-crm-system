package org.example.employee.services.impl;

import org.example.employee.dto.EmployeeCreateDto;
import org.example.employee.model.Employee;
import org.example.employee.model.User;
import org.example.employee.repository.EmployeeRepository;
import org.example.employee.repository.UserRepository;
import org.example.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Employee createEmployee(EmployeeCreateDto employeeDetails) {
        if(employeeRepository.existsByEmail(employeeDetails.getEmail())){
            throw new RuntimeException("Email already exist");
        }
        User user= new User();
        user.setUsername(employeeDetails.getUsername());
        user.setPassword(passwordEncoder.encode(employeeDetails.getPassword()));
        user.setRole("EMPLOYEE");
        userRepository.save(user);

        Employee employee=new Employee();
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setStatus(employeeDetails.getEmployeeStatus());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setSalary(employeeDetails.getSalary());
        employee.setJoiningDate(LocalDate.parse(employeeDetails.getJoiningDate()));
        employee.setUser(user);

        return employeeRepository.save(employee);
    }
}
