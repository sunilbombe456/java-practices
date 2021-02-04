package com.webwork.studyonline.service;

import com.webwork.studyonline.model.User;

public interface LoginService {

	User userLogin(String username, String userpwd);

}
