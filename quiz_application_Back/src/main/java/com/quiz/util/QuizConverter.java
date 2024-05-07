package com.quiz.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz.dto.CategoryDto;
import com.quiz.dto.QuizDto;
import com.quiz.entity.Category;
import com.quiz.entity.Quiz;

@Component
public class QuizConverter {
	
	//convert User to USerDto
	public QuizDto convertToQuizDto(Quiz quiz) {
		QuizDto quizDto=new QuizDto();
		
		if(quiz!=null) {
			BeanUtils.copyProperties(quiz, quizDto);
		}
		return quizDto;
	}
	
	//convert UserDto to USer
		public Quiz convertToquQuiz(QuizDto quizDto) {
			Quiz quiz= new  Quiz();
			
			if(quizDto!=null) {
				BeanUtils.copyProperties(quizDto, quiz);
				
			}
			return quiz;
		}

}
