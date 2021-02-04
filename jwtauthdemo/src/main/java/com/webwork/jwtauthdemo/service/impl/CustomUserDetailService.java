package com.webwork.jwtauthdemo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webwork.jwtauthdemo.entity.User;
import com.webwork.jwtauthdemo.repo.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(), new ArrayList<>());
	}

}
