package com.example.Project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmpService {

     String createEmployee(Employee employee);
     List<Employee> readEmployee();
     boolean deleteEmployee(Long id);
     String updateEmployee(Long id, Employee employee);
    Employee readEmployeeById(Long id);

}
