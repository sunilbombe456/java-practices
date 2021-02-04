package com.webwork.studyonline.service;

public interface SendEmailService {
	public void send(String from,String password,String to,String sub,String msg);
}
