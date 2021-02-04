package com.webwork.springboot.cruddemo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webwork.springboot.cruddemo.dao.EmployeeDao;
import com.webwork.springboot.cruddemo.entity.Employee;
import com.webwork.springboot.cruddemo.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	// define field for entity Manager
	private EntityManager entityManager;

	// set up constructor for injection

	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		// get current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

		// create query

		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get Result list

		List<Employee> employees = theQuery.getResultList();

		// returns the result list

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub

		Session currentSession = entityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

		Session currentSession = entityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Empolyee Not  in our System ID: " +theId);
		}
		
		currentSession.delete(theEmployee);
	}

}
