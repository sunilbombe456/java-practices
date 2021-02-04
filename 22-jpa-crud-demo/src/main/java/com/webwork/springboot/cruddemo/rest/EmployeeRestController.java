package com.webwork.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.springboot.cruddemo.entity.Employee;
import com.webwork.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.webwork.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeService.findAll();
	}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("The Employee Not in the System Id: " + employeeId);
		}
		return theEmployee;
	}

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {

		theEmployee.setId(0);
		employeeService.save(theEmployee);

		return theEmployee;
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {

		employeeService.deleteById(employeeId);
		return "We Delete Employee Of ID: " + employeeId;
	}

}
