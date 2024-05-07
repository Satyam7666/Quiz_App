package com.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Questions {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long quesId;

	    private String question;

	    private String image;

	    private  String option1;
	    private  String option2;
	    private  String option3;
	    private  String option4;


	    private  String answer;
	    
	    private String givenAnswer;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    private Quiz quiz;

}
