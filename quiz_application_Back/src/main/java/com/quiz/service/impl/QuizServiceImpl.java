package com.quiz.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.QuizDto;
import com.quiz.entity.Category;
import com.quiz.entity.Quiz;
import com.quiz.exception.CategoryNotFoundException;
import com.quiz.exception.QuizNotFoundException;
import com.quiz.repo.CategoryRepo;
import com.quiz.repo.QuizRepo;
import com.quiz.service.QuizService;
import com.quiz.util.CategoryConverter;
import com.quiz.util.QuizConverter;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuizConverter quizConverter;
	
	@Autowired
	
	private CategoryRepo categoryRepo;
	
	@Autowired
	CategoryConverter categoryConverter;
	

	@Override
	public QuizDto addQuiz(QuizDto quizDto) {
		Quiz quiz = this.quizConverter.convertToquQuiz(quizDto);
		         
		 Quiz saveqQuiz = this.quizRepo.save(quiz);
		 return this.quizConverter.convertToQuizDto(saveqQuiz);
	}

	@Override
	public QuizDto updateQuiz(QuizDto quizDto,long qId) {
		System.out.println("service "+quizDto);
		Quiz updateQuiz  = this.quizRepo.findById(qId).orElseThrow(()->new QuizNotFoundException("Quiz with quizId "+qId+" is Not present"));
		updateQuiz.setTitle(quizDto.getTitle());
		updateQuiz.setDescription(quizDto.getDescription());
		updateQuiz.setNumberOfquestion(quizDto.getNumberOfquestion());
		updateQuiz.setMaxMark(quizDto.getMaxMark());
		updateQuiz.setActive(quizDto.isActive());
     //   Category category = categoryRepo.findById(quizDto.getCategoryId()).orElseThrow(()->new  CategoryNotFoundException("category with id "+quizDto.getCategoryId()+" is not present"));
		//updateQuiz.setCategory(category);
	//	Category category = this.categoryRepo.findById(quizDto.getCatId()).orElseThrow();
		//updateQuiz.setCategory(category);
        Quiz saveqQuiz = this.quizRepo.save(updateQuiz);
		return this.quizConverter.convertToQuizDto(saveqQuiz);
	}

	@Override
	public Set<QuizDto> getQuizzes() {
		// TODO Auto-generated method stub
		List<Quiz> quizs = this.quizRepo.findAll();
		 Set<QuizDto> quizDtos = quizs.stream().map((quiz)->this.quizConverter.convertToQuizDto(quiz)).collect(Collectors.toSet());
		return  quizDtos;
	}

	@Override
	public QuizDto getQuiz(Long quizId) {
		// TODO Auto-generated method stub
	
		
		Quiz quiz = this.quizRepo.findById(quizId).orElseThrow(()->new QuizNotFoundException("Quiz with quizId "+quizId+" is Not present"));
		return this.quizConverter.convertToQuizDto(quiz);
	}

	@Override
	public void delteQuiz(Long quizId) {
		Quiz deleteQuiz = this.quizRepo.findById(quizId).orElseThrow(()->new QuizNotFoundException("Quiz with quizId "+quizId+" is Not present"));
		this.quizRepo.delete(deleteQuiz);
		
	}

	@Override
	public List<QuizDto> getQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		 List<Quiz> quizs = this.quizRepo.findByCategory(category);
		 List<QuizDto> quizDtos = quizs.stream().map((quiz)->this.quizConverter.convertToQuizDto(quiz)).collect(Collectors.toList());
		 return quizDtos;
	}

	@Override
	public List<QuizDto> getActiveQuizzess() {
		// TODO Auto-generated method stub
		 List<Quiz> quizs = this.quizRepo.findByActive(true);
		 List<QuizDto> quizDtos = quizs.stream().map((quiz)->this.quizConverter.convertToQuizDto(quiz)).collect(Collectors.toList());
		 return quizDtos;
	}

	@Override
	public List<QuizDto> getActiveQuizzessOfCategory(Category c) {
		// TODO Auto-generated method stub
		
		 List<Quiz> quizs = this.quizRepo.findByCategoryAndActive(c, true);
		 List<QuizDto> quizDtos = quizs.stream().map((quiz)->this.quizConverter.convertToQuizDto(quiz)).collect(Collectors.toList());
		 return quizDtos;
	}

}
