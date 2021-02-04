package com.webwork.studyonline.service;

import java.util.List;

import com.webwork.studyonline.model.Feedback;
import com.webwork.studyonline.model.User;
import com.webwork.studyonline.exception.UserNotFoundException;

public interface UserService {

	boolean saveUser(User user);

	User getUser(int userId);

	List<User> getAllUser(String userType) throws UserNotFoundException;

	boolean saveFeedback(Feedback feedback);
	
	boolean newUser(User user, String userPwd);
	
	boolean deleteUser(int userId);

}
