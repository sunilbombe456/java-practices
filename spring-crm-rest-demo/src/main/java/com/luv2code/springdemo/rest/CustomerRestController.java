package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		Customer theCustomer = customerService.getCustomer(customerId);

		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer Not Found Of Id: " + customerId);
		}
		return theCustomer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	// Add mapping for PUT / customers update the existing customers

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}
	
	//delete mapping DELETE  /customer delte existing user
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("The Customer of given id not exist : "+ customerId);
		}
		
		customerService.deleteCustomer(customerId);
		return "Deleted Customer Id : " + customerId;
	}
}
