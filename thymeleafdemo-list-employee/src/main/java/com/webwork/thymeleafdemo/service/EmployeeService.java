package com.webwork.thymeleafdemo.service;

import java.util.List;

import com.webwork.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();

	public void save(Employee theEmployee);

	public Employee findById(int employeeId);

	public void deleteById(int employeeId);

}
