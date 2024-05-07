package com.quiz.service;

import java.util.Set;

import com.quiz.dto.QuestionsDto;
import com.quiz.dto.QuizDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;

public interface QuestionService {
	
	public QuestionsDto addQuestion(QuestionsDto questionsDto);
	
	Set<QuestionsDto> getAllQuestions();
	
	public  QuestionsDto updateQuestion(QuestionsDto questionDto,long quesId);
	
	public  QuestionsDto getQuestion(Long questionId);
	
	 public void  deleteQuestion(Long quesId);
	 
	 public  Set<QuestionsDto> getQuestionOfQuiz(QuizDto quizDto);
	 public Questions get(Long questionId);

}
