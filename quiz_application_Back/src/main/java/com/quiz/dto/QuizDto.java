package com.quiz.dto;

import java.util.HashSet;
import java.util.Set;

import com.quiz.entity.Category;
import com.quiz.entity.Questions;
import com.quiz.entity.StudentQuizRecord;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class QuizDto {
	private long quizId;

    private String title;

    private String description;

    private String maxMark;

    private String numberOfquestion;
   

    private boolean active=false;
   
    
    private Category category;
    
  //  private  Set<QuestionsDto> questions=new HashSet<>();
    
    // private Set<StudentQuizRecordDto> quizRecords = new HashSet<>();

}
