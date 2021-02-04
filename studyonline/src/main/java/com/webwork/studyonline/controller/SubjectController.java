package com.webwork.studyonline.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webwork.studyonline.model.Subject;
import com.webwork.studyonline.service.SubjectService;
import com.webwork.studyonline.service.impl.SubjectServiceImpl;


public class SubjectController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Subject subject;
	private SubjectService subjectService;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		subject = new Subject();
		subject.setSubject(request.getParameter("subject").toString());
		subject.setExamTime(Integer.parseInt(request.getParameter("examTime")));
		subject.setSubjectStatus(request.getParameter("subjectStatus"));
		
		subjectService = new SubjectServiceImpl();
		
		if(subjectService.setSubject(subject)) {
			response.sendRedirect("subject.jsp");
		}else {
			response.sendRedirect("add-subject.jsp");
		}
		
		
	}
	
}