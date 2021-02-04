package com.webwork.springboot.cruddemo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webwork.springboot.cruddemo.dao.EmployeeDao;
import com.webwork.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub

		Query query = entityManager.createQuery("from Employee");

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub

		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub

		Employee dbEmployee = entityManager.merge(theEmployee);

		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		// delete object with primary key
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

		query.setParameter("employeeId", theId);

		query.executeUpdate();

	}

}
