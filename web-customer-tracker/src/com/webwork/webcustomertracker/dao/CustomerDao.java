package com.webwork.webcustomertracker.dao;

import java.util.List;

import com.webwork.webcustomertracker.entity.Customer;

public interface CustomerDao {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);
}
