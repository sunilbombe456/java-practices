package com.webwork.springboot.cruddemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.springboot.cruddemo.dao.EmployeeRepository;
import com.webwork.springboot.cruddemo.entity.Employee;
import com.webwork.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.webwork.springboot.cruddemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
		employeeRepo = theEmployeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub

		Employee theEmployee = null;

		Optional<Employee> result = employeeRepo.findById(theId);
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new EmployeeNotFoundException("Employee id not found: " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepo.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(theId);

	}

}
