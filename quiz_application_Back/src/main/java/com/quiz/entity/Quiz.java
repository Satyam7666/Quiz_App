package com.quiz.entity;

import java.util.HashSet;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Quiz {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long quizId;

	    private String title;

	    private String description;

	    private String maxMark;

	    private String numberOfquestion;

	    private boolean active=true;
	    
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	  //  @JoinColumn(
	    //		name = "cId",referencedColumnName = "cId")
	 //   @JsonBackReference
	    private Category category;

	      @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	      @JsonIgnore
	     private  Set<Questions> questions=new HashSet<>();
	      
	    

}
