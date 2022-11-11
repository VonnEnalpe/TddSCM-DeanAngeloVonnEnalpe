package com.example.demo.service;



import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Employee> getAllEmployeesThatAreEarningMoreThan( Double salary) {
        List<Employee> employeesEarningMore= (List<Employee>) employeeRepository.findAll();
        return employeesEarningMore
                .stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }



    @Override
    public List<Employee> getAllEmployeesExceedingAge(int age) {
        List<Employee> employeesAge= (List<Employee>) employeeRepository.findAll();
        return employeesAge
                .stream()
                .filter(employee -> employee.getAge() > age)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeesWithMatchingPosition(String position) {
        List<Employee> employeesPosition= (List<Employee>) employeeRepository.findAll();
        return employeesPosition
                .stream()
                .filter(employee -> Objects.equals(employee.getPosition(), position))
                .collect(Collectors.toList());
    }



    public Optional<Employee> getEmployeeWithHighestSalary() {
        List<Employee> employeesOptional = (List<Employee>) employeeRepository.findAll();
        return employeesOptional
            .stream()
            .max(Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();

    }


}

