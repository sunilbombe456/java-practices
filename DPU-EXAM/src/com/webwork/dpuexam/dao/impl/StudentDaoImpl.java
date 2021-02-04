package com.webwork.dpuexam.dao.impl;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.dpuexam.DateUtils;
import com.webwork.dpuexam.dao.StudentDao;
import com.webwork.dpuexam.entity.Student;
import com.webwork.dpuexam.entity.StudentDetail;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveStudent() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		Date birthDate = null;
		try {
			birthDate = (Date) DateUtils.parseDate("26/03/1998");
		} catch (Exception e) {
			e.printStackTrace();
		}

		StudentDetail studentDetail = new StudentDetail("Sunil", "Sakharam", "Bombe", "sunilbombe456@gmail.com",
				"8605705665", birthDate, "D Y Patil", "MCS", "Second Year", 10);

		Student student = new Student("sunilbombe1998", "@smile4u..");

		student.setTheStudentDetail(studentDetail);

		session.save(student);

	}

}
