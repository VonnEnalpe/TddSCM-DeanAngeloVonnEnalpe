package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/id")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employeeList = employeeService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }
    @GetMapping("/{salary}")
    public List<Employee> getAllEmployeesThatAreEarningMoreThan(@PathVariable Double salary){
        return employeeService.getAllEmployeesThatAreEarningMoreThan(salary);
    }
    @GetMapping("/{age}")
    public List<Employee> getAllEmployeesExceedingAge(@PathVariable int age){
        return employeeService.getAllEmployeesExceedingAge(age);
    }
    @GetMapping("/{position}")
    public List<Employee> getAllEmployeesWithMatchingPosition(@PathVariable String position){
        return employeeService.getAllEmployeesWithMatchingPosition(position);
    }
    @GetMapping("/{highsalary}")
    public Optional<Employee> getEmployeeWithHighestSalary(){
        return employeeService.getEmployeeWithHighestSalary();
    }
}
