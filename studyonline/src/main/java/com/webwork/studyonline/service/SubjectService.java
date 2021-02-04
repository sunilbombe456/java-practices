package com.webwork.studyonline.service;

import java.util.List;

import com.webwork.studyonline.model.Subject;

public interface SubjectService {
	
	List<Subject> getAllSubject();
	
	boolean setSubject(Subject subject);
}
