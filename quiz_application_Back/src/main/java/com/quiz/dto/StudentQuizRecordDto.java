package com.quiz.dto;

import com.quiz.entity.Quiz;
import com.quiz.entity.User;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class StudentQuizRecordDto {
private long recordId;
	
	private double marksGot;
	
	private int correctAnswer;
	
	private int attempted;
	
	
	private User user;

	
	private Quiz quiz;

}
