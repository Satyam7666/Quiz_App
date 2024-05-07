package com.quiz.entity;

import java.time.LocalDate;

import javax.swing.plaf.multi.MultiInternalFrameUI;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.val;

@Entity
@Data
public class StudentQuizRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recordId;
	
	private double marksGot;
	
	private int correctAnswer;
	
	private int attempted;
	
	 private LocalDate date;
	 private long userId;
	 private String quizName;
	 private int noOfQuestion;
	 
	 private String categoryName;


	  
	
	
	}
