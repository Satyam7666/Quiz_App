package com.quiz.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz.dto.CategoryDto;
import com.quiz.dto.QuestionsDto;
import com.quiz.entity.Category;
import com.quiz.entity.Questions;

@Component
public class QuestionConverter {
	//convert User to USerDto
	public  QuestionsDto convertToQuestionDto(Questions questions) {
		QuestionsDto questionDto=new QuestionsDto();
		
		if(questions!=null) {
			BeanUtils.copyProperties(questions, questionDto);
		}
		return questionDto;
	}
	
	//convert UserDto to USer
		public Questions convertToQuestions(QuestionsDto questionDto) {
			Questions questions=new Questions();
			
			if(questionDto!=null) {
				BeanUtils.copyProperties(questionDto, questions);
				
			}
			return questions;
		}

}
