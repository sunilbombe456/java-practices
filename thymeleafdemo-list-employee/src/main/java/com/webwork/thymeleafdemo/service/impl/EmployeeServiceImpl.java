package com.webwork.thymeleafdemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.thymeleafdemo.entity.Employee;
import com.webwork.thymeleafdemo.repo.EmployeeDao;
import com.webwork.thymeleafdemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAllByOrderByLastNameAsc();
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDao.save(theEmployee);
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		Employee theEmployee = null;

		Optional<Employee> result = employeeDao.findById(employeeId);
		if (result.isPresent()) {

			theEmployee = result.get();

		}

		return theEmployee;
	}

	@Override
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		
		employeeDao.deleteById(employeeId);
	}

}
