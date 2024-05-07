package com.quiz.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Category {
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long catId;

	    private String title;

	    private String description;
	    
	    
	    
	    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	    @JsonIgnore
	    //@JsonManagedReference
	    private Set<Quiz> quizzes=new LinkedHashSet<>();

}
