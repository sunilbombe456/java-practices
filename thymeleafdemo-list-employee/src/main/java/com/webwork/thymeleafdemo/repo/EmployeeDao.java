package com.webwork.thymeleafdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.thymeleafdemo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
}
