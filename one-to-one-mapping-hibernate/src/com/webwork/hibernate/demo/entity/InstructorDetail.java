package com.webwork.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	// annotation the class as Entity and map to db table

	// define the fields

	// annotate the field with db column name
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youTube;

	@Column(name = "hobby")
	private String hobby;

	// create constructor

	public InstructorDetail() {
	}

	public InstructorDetail(String youTube, String hobby) {
		this.youTube = youTube;
		this.hobby = hobby;
	}

	// generate getter and setter method

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYouTube() {
		return youTube;
	}

	public void setYouTube(String youTube) {
		this.youTube = youTube;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	// Generate the toString Method

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youTube=" + youTube + ", hobby=" + hobby + "]";
	}

}
