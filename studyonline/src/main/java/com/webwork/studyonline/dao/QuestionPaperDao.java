package com.webwork.studyonline.dao;

import java.util.List;

import com.webwork.studyonline.model.Answer;
import com.webwork.studyonline.model.QuestionPaper;

public interface QuestionPaperDao {

	public List<QuestionPaper> getQuestion();
	
	public List<QuestionPaper> getQuestionBySubject(String subject);

	int getQuestionCount(String subject);

	boolean saveAnswer(Answer[] answer, int count);

	boolean isTestGivenBefore(int userId);

	int submitAnswerCount(int userId);

	List<Answer> getUserAnswer(int userId);
}
