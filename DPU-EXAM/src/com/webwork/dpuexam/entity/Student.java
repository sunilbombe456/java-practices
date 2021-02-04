package com.webwork.dpuexam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String userPassword;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_detail_id")
	private StudentDetail theStudentDetail;

	public Student() {
	}

	public Student(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

	public StudentDetail getTheStudentDetail() {
		return theStudentDetail;
	}

	public void setTheStudentDetail(StudentDetail theStudentDetail) {
		this.theStudentDetail = theStudentDetail;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", theStudentDetail="
				+ theStudentDetail + "]";
	}

	
	

}
