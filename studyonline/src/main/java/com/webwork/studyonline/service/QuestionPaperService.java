package com.webwork.studyonline.service;

import java.util.List;

import com.webwork.studyonline.model.Answer;
import com.webwork.studyonline.model.QuestionPaper;

public interface QuestionPaperService {

	List<QuestionPaper> getQuestionPaper(String subject);

	int getQuestionCount(String subject);

	boolean saveAnswer(Answer[] answer, int count);

	boolean isTestGivenBefore(int userId);

	public boolean checkAnswer(int qId, String answer);

	public boolean checkUserAnswer(int qId, String answer);

	public String getUserAnswer(int userId, int qId);
	
	
	

}
