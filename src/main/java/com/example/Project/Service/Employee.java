package com.example.Project.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// data gives getter and setter for all
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    private Long id;
    private String name;
    private String phone;
    private String email;


}
