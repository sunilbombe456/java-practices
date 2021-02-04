package com.webwork.studyonline.service.impl;

import com.webwork.studyonline.dao.UserDao;
import com.webwork.studyonline.dao.impl.UserDaoImpl;
import com.webwork.studyonline.model.User;
import com.webwork.studyonline.service.LoginService;


public class LoginServiceImpl implements LoginService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User userLogin(String username, String userpwd) {
		return userDao.login(username, userpwd);
	}
	


}
