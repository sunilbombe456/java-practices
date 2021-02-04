package com.webwork.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webwork.thymeleafdemo.entity.Employee;
import com.webwork.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	private List<Employee> employees;

	@GetMapping("/list")
	public String getEmployeeList(Model theModel) {
		employees = employeeService.findAll();
		theModel.addAttribute("employees", employees);
		return "employee/employee-list";
	}

	@GetMapping("/showFormForAdd")
	public String showAddEmployeeForm(Model theModel) {
		theModel.addAttribute("employee", new Employee());
		return "employee/add-employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employee/list";
	}

	@GetMapping("/update/{employeeId}")
	public String udpdateEmployee(@PathVariable int employeeId,Model theModel) {
		 
		Employee theEmployee = employeeService.findById(employeeId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee/add-employee";

	}
	
	@GetMapping("/update")
	public String udpdateNewEmployee(@RequestParam int employeeId,Model theModel) {
		 
		Employee theEmployee = employeeService.findById(employeeId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee/add-employee";

	}
	

	@GetMapping("/delete")
	public String deleteNewEmployee(@RequestParam int employeeId) {
		 
		 employeeService.deleteById(employeeId);
		
		return "redirect:/employee/list";
	}

}
