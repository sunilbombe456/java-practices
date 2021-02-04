package com.webwork.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
