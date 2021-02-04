package com.webwork.studyonline.dao;

import com.webwork.studyonline.model.User;

public interface LoginDao {

	public User login(String username, String userpwd);
}
