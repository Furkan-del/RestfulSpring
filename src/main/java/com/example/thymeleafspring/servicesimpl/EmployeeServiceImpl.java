package com.example.thymeleafspring.servicesimpl;

import com.example.thymeleafspring.dto.EmployeeDto;
import com.example.thymeleafspring.entity.EmployeeEntity;
import com.example.thymeleafspring.exception.ResourceNotFoundException;
import com.example.thymeleafspring.repository.EmployeeRepository;
import com.example.thymeleafspring.service.EmployeeServices;
import jakarta.persistence.Access;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository; //Databasele alakalı işlemler burada yapılır!
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        for (EmployeeEntity temp : employeeEntities) {
            EmployeeDto employeeDto = entityToDto(temp);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    //save

    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepository.save(dtoToEntity(employeeDto));
        return employeeDto;
    }
    //find

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This resource didnt found this id" + id));
        EmployeeDto employeeDto = entityToDto(employeeEntity);
        return ResponseEntity.ok(employeeDto);


    }

//update
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        //id ile eriştiğin herşeye bir check at
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This resource didnt found this id" + id));
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());
        EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(entityToDto(updatedEmployee));
    }
//delete
    @DeleteMapping("delete/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable(name = "id") Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This resource didnt found :" + id));
        employeeRepository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //Model Mapper
    //Dto to Entity
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }

    //Entity to Dto
    @Override
    public EmployeeDto entityToDto(EmployeeEntity entity) {
        EmployeeDto employeeDto = modelMapper.map(entity, EmployeeDto.class);
        return employeeDto;
    }
    //

}
