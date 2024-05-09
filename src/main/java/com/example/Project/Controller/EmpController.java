package com.example.Project.Controller;

import java.util.List; // Correct import for List

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Service.EmpService;
import com.example.Project.Service.Employee;

@RestController
public class EmpController {

    // List<Employee> employees = new ArrayList<>();
    // EmpService employeeService = new EmpServiceImpl();

    // Dependency Injection

    @Autowired
    private EmpService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmp() {
        return employeeService.readEmployee();
    }

    @GetMapping("employees/{id}")
    public Employee getEmpById(@PathVariable Long id) {
        return employeeService.readEmployeeById(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employees.add(employee);
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id))
            return "Deleted Succesfully";

        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}