package com.webwork.webcustomertracker.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.webcustomertracker.dao.CustomerDao;
import com.webwork.webcustomertracker.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		// get the Current Hibernate Session

		Session currentSession = sessionFactory.getCurrentSession();

		// create the Query

		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		// get the Result List
		List<Customer> customer = theQuery.getResultList();

		// returns the Results
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
		// create the Current Session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete from database
		
	 Query theQuery	= currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
	}

}
