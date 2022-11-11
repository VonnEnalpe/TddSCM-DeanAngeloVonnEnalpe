package com.example.demo.service;



import com.example.demo.model.Employee;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> getAllEmployeesThatAreEarningMoreThan(Double salary);
    List<Employee> getAllEmployeesExceedingAge(int age);
    List<Employee> getAllEmployeesWithMatchingPosition(String position);
    Optional<Employee> getEmployeeWithHighestSalary();

    List<Employee> findAllEmployees();
}
