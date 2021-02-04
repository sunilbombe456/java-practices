package com.webwork.dpuexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.dpuexam.dao.StudentDao;
import com.webwork.dpuexam.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao; 

	@Override
	public void saveStudent() {
		// TODO Auto-generated method stub
		
		studentDao.saveStudent();
		
	}

}
