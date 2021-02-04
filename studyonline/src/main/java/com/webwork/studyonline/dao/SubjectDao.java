package com.webwork.studyonline.dao;

import java.util.List;

import com.webwork.studyonline.model.Subject;

public interface SubjectDao {

	List<Subject> getAllSubject();
	
	boolean setSubject(Subject subject);
	
	Subject getSubject(String subject);
}
