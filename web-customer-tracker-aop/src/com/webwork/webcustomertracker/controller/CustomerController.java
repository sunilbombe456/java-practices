package com.webwork.webcustomertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webwork.webcustomertracker.entity.Customer;
import com.webwork.webcustomertracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject the Dao
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// Get Customer from dao
		List<Customer> customer = customerService.getCustomers();

		// Add Customer to the Model
		theModel.addAttribute("customers", customer);

		return "list-customer";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomerForm(Model theModel) {

		// create a model Attribute to bind the Form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId, Model theModel) {
		// get the Customer from database;
		Customer theCustomer = customerService.getCustomer(theId);

		// Set Customer to the Model to Prepopulate the Form
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// call delete method from customer Service
		customerService.deleteCustomer(theId);

		return "redirect:/customer/list";
	}
}
