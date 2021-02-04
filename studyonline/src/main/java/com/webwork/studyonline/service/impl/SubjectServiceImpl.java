package com.webwork.studyonline.service.impl;

import java.util.List;

import com.webwork.studyonline.dao.SubjectDao;
import com.webwork.studyonline.dao.impl.SubjectDaoImpl;
import com.webwork.studyonline.model.Subject;
import com.webwork.studyonline.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private SubjectDao subjectDao = new SubjectDaoImpl();

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectDao.getAllSubject();
	}

	@Override
	public boolean setSubject(Subject subject) {
		// TODO Auto-generated method stub
		
		return subjectDao.setSubject(subject);
	}

}
