package com.webwork.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.springrestdemo.entity.Student;
import com.webwork.springrestdemo.entity.StudentErrorResponse;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define the @PostConstruct to load Student Data ...only once..
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student(1, "Neema", "Patel"));
		theStudents.add(new Student(2, "Ravi", "Pokale"));
		theStudents.add(new Student(3, "Ganesh", "date"));
	}

	@GetMapping("/Students")
	public List<Student> getStudent() {
		return theStudents;
	}

	@GetMapping("/Students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		// just Student into the list ..keep it simple for now

		// check studentId against List

		if ((studentId >= theStudents.size()) || (studentId < 0)) {

			throw new StudentNotFoundExeception("StudentId not Found: "+studentId );
		}
		return theStudents.get(studentId);
	}
	
	
}
