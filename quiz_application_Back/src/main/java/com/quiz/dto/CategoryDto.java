package com.quiz.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.quiz.entity.Quiz;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class CategoryDto {
	
	private long catId;

    private String title;

    private String description;
    
    private Set<Quiz> quizzes=new LinkedHashSet<>();

}
