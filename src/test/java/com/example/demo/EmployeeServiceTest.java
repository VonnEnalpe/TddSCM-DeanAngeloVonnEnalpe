package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Test
	@DisplayName("Given a request, " +
			"getAllEmployeesThatAreEarningMoreThan should contain dean, angelo & vonn " +
			"execute Service")
	void getAllEmployeesThatAreEarningMoreThan(){
		//arrange
		Employee dean = new Employee(1L, "Dean", 23, 30000d, "Dev");
		Employee angelo = new Employee(2L, "Angelo", 24, 190000d, "Soft Dev");
		Employee vonn = new Employee(3L, "Vonn", 25, 2000000d, "Senior Dev");
		List<Employee> employees = of(dean, angelo, vonn);
		Mockito.when(employeeRepository.findAll())
				.thenReturn(employees);
		//act
		List<Employee> filteredEmployees = employeeServiceImpl.getAllEmployeesThatAreEarningMoreThan(20d);
		assertThat(filteredEmployees).contains(dean, angelo, vonn);
	}

	@Test
	@DisplayName("Given a request, " +
			"getAllEmployeesExceedingAge should contain angelo and vonn" +
			"execute Service")
	void getAllEmployeesExceedingAge() {
		Employee dean = new Employee(1L, "Dean", 23, 30000d, "Dev");
		Employee angelo = new Employee(2L, "Angelo", 24, 190000d, "Soft Dev");
		Employee vonn = new Employee(3L, "Vonn", 25, 2000000d, "Senior Dev");
		List<Employee> employees = of(dean, angelo, vonn);
		Mockito.when(employeeRepository.findAll())
				.thenReturn(employees);
		//act
		List<Employee> filteredEmployees = employeeServiceImpl.getAllEmployeesExceedingAge(23);
		assertThat(filteredEmployees).contains(angelo, vonn);
	}
	@Test
	@DisplayName("Given a request, " +
			"getAllEmployeesWithMatchingPosition should contain dean & angelo" +
			"execute Service")
	void getAllEmployeesWithMatchingPosition() {
		Employee dean = new Employee(1L, "Dean", 23, 30000d, "Dev");
		Employee angelo = new Employee(2L, "Angelo", 24, 190000d, "Dev");
		Employee vonn = new Employee(3L, "Vonn", 25, 2000000d, "Senior Dev");
		List<Employee> employees = of(dean, angelo, vonn);
		Mockito.when(employeeRepository.findAll())
				.thenReturn(employees);
		//act
		List<Employee> filteredEmployees = employeeServiceImpl.getAllEmployeesWithMatchingPosition("Dev");
		assertThat(filteredEmployees).contains(dean, angelo);
	}

	@Test
	@DisplayName("Given a request, " +
			"getEmployeeWithHighestSalary should contain vonn " +
			"execute Service")
	void getEmployeeWithHighestSalary() {
		//arrange
		Employee dean = new Employee(1L, "Dean", 23, 30000d, "Dev");
		Employee angelo = new Employee(2L, "Angelo", 24, 190000d, "Soft Dev");
		Employee vonn = new Employee(3L, "Vonn", 25, 2000000d, "Senior Dev");
		List<Employee> employees = of(dean, angelo, vonn);
		Mockito.when(employeeRepository.findAll())
				.thenReturn(employees);
		//act
		Optional<Employee> filteredEmployees = employeeServiceImpl.getEmployeeWithHighestSalary();
		//assert
		assertThat(filteredEmployees).contains(vonn);

	}
//	@Test
//	@DisplayName("Given a request, " +
//			"findAllEmployees should contain dean, angelo & vonn " +
//			"execute Service")
//	void findAllEmployees(){
//		//arrange
//		Employee dean = new Employee(1L, "Dean", 23, 30000d, "Dev");
//		Employee angelo = new Employee(2L, "Angelo", 24, 190000d, "Soft Dev");
//		Employee vonn = new Employee(3L, "Vonn", 25, 2000000d, "Senior Dev");
//		List<Employee> employees = of(dean, angelo, vonn);
//
//		//act
//		List<Employee> employeeList = employeeServiceImpl.findAllEmployees();
//		assertThat(employeeList).contains((Employee) employees);
//	}

}

