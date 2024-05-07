package com.quiz.dto;

import com.quiz.entity.Quiz;

import lombok.Data;

@Data
public class QuestionsDto {
	 private long quesId;

	    private String question;

	    private String image;

	    private  String option1;
	    private  String option2;
	    private  String option3;
	    private  String option4;


	    private  String answer;
	    
	    private String givenAnswer;
	    private Quiz quiz;

}
