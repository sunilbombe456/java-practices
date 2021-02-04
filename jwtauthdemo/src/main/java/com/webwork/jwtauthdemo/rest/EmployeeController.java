package com.webwork.jwtauthdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.jwtauthdemo.entity.Employee;
import com.webwork.jwtauthdemo.exception.BusinessException;
import com.webwork.jwtauthdemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public List<Employee> employeeList(){
		return employeeService.findAll();
	}
	
	
	@GetMapping("/list/1")
	public List<Employee> employeeListFor(){
		List<Employee> emp = null;
		if(emp == null) {
			throw new BusinessException("List Of Employees Not Found");
		}
		return emp;
	}
	

	
}
