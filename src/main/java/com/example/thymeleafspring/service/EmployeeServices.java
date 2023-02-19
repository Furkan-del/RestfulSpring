package com.example.thymeleafspring.service;

import com.example.thymeleafspring.dto.EmployeeDto;
import com.example.thymeleafspring.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {
    //CRUD
    public List<EmployeeDto> getAllEmployees();

    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto);
    public ResponseEntity<Map<String , Boolean>> deleteEmployeeById(Long id);


    //model mapper
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
    public EmployeeDto entityToDto(EmployeeEntity entity);
}
