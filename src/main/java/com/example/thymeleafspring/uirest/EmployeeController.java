package com.example.thymeleafspring.uirest;

import com.example.thymeleafspring.dto.EmployeeDto;
import com.example.thymeleafspring.servicesimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//rest dış dünyaya açılan yapı
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    //get
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();

    }

    //save
    @PostMapping("/save")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    //Find
    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id).getBody());

    }

    @PutMapping("edit/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name="id") Long id, @RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteEmployeeById(@PathVariable(name="id") Long id){
        Map<String,Boolean>response= new HashMap<>();
        response.put("deleted",Boolean.TRUE); //ı think this code redundant because ı dont write here any logic... it can returns just a simple deleted message
        employeeService.deleteEmployeeById(id);
        return  ResponseEntity.ok(response);

    }


}
