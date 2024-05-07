package com.quiz.service;

import java.util.List;
import java.util.Set;

import com.quiz.dto.QuizDto;
import com.quiz.entity.Category;
import com.quiz.entity.Quiz;

public interface QuizService {
	
	    public QuizDto addQuiz(QuizDto quiz); 
	    
	    public  QuizDto updateQuiz(QuizDto quiz,long qId);
	    
	    public Set<QuizDto> getQuizzes();

	    public  QuizDto getQuiz(Long quizId);
	    
	    public  void  delteQuiz(Long quizId);
	    
	  
	    public List<QuizDto> getQuizzesOfCategory(Category category);

	    public  List<QuizDto> getActiveQuizzess();
	    public  List<QuizDto> getActiveQuizzessOfCategory(Category c);

}
