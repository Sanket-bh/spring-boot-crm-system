package org.example.employee.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.employee.enums.EmployeeStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeCreateDto {
    private String name;
    private String email;
    private String phone;
    private String designation;
    private EmployeeStatus employeeStatus;
    private String  joiningDate;
    private BigDecimal salary;
    private String username;
    private String password;
}
