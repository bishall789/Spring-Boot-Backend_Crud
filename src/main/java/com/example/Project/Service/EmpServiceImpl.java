package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List; // Correct import for List

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.EmployeeEntity;
import com.example.Project.Repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;
    // List<Employee> employees = new ArrayList<>();

    /*
     * @Override
     * public String createEmployee(Employee employee) {
     * EmployeeEntity employeeEntity = new EmployeeEntity();
     * BeanUtils.copyProperties(employee, employeeEntity);
     * employeeRepository.save(employeeEntity);
     * // employees.add(employee);
     * return "Saved Succesfully";
     * }
     * 
     */

    @Override
    public Employee readEmployeeById(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        // Copy properties from Employee to EmployeeEntity
        employeeEntity.setName(employee.getName());
        employeeEntity.setPhone(employee.getPhone());
        employeeEntity.setEmail(employee.getEmail());
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        // employees.remove(id);
        EmployeeEntity emplo = employeeRepository.findById(id).get();
        employeeRepository.delete(emplo);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {

        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return "Updated Successfully";
    }

}
