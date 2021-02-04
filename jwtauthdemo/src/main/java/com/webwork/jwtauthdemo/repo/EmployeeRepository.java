package com.webwork.jwtauthdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webwork.jwtauthdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
