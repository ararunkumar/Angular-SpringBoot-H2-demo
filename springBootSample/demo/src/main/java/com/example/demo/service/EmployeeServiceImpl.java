package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import java.util.List;


//import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service

// Class
public class EmployeeServiceImpl
        implements EmployeeService {

    
    @Autowired
    private EmployeeRepository EmployeeRepository;

    // Save operation
    @Override
    public Employee saveEmployee(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    // Read operation
    @Override
    public List<Employee> fetchEmployeeList() {
     return (List<Employee>) EmployeeRepository.findAll();
    }

}