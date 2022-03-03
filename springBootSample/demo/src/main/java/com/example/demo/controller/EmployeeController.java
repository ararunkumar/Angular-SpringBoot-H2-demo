package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestScope
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;

    // Save operation
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCoins")
    public Employee saveEmployee(@RequestBody Employee Empl) {
        return EmployeeService.saveEmployee(Empl);
    }

    // Read operation
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getEmployeeCoins")
    public Map<String, Integer> fetchEmployeeList() {
        List<Employee> tempList = EmployeeService.fetchEmployeeList();
        Map<String, Integer> tempMap =  
        tempList.stream().collect(Collectors.groupingBy(Employee::getFirstName,
        Collectors.summingInt(Employee::getCoins)));
        return tempMap;
    }

}