package com.example.demo.service;
import com.example.demo.entity.Employee;

import org.springframework.data.jpa.repository.Query;

// Importing required classes
import java.util.List;
 
// Interface
public interface EmployeeService {
 
    // Save operation
    Employee saveEmployee(Employee Employee);
 
    // Read operation
    @Query(value="select emp.FIRST_NAME, SUM(emp.COINS) from EMPLOYEE emp group by emp.FIRST_NAME", nativeQuery = true)
    List<Employee> fetchEmployeeList();
 
}