package com.quiz.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.QuestionsDto;
import com.quiz.dto.QuizDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
import com.quiz.exception.QuestionNotFoundException;
import com.quiz.repo.QuestionsRepository;
import com.quiz.service.QuestionService;
import com.quiz.util.QuestionConverter;
import com.quiz.util.QuizConverter;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionsRepository questionsRepo;
	
	@Autowired
	private QuestionConverter questionConverter;
	
	@Autowired
	private QuizConverter quizConverter;

	@Override
	public QuestionsDto addQuestion(QuestionsDto questionsDto) {
		// TODO Auto-generated method stub
		Questions questions = this.questionConverter.convertToQuestions(questionsDto);
	 Questions saveqQuestions = this.questionsRepo.save(questions);
	 return this.questionConverter.convertToQuestionDto(saveqQuestions);
	}

	@Override
	public Set<QuestionsDto> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Questions> questions = this.questionsRepo.findAll();
		Set<QuestionsDto> questionsDtos = questions.stream().map((question)->this.questionConverter.convertToQuestionDto(question)).collect(Collectors.toSet());
		return questionsDtos;
	}

	@Override
	public QuestionsDto updateQuestion(QuestionsDto questionDto,long quesId) {
		// TODO Auto-generated method stub
		Questions updateQues = this.questionsRepo.findById(quesId).orElseThrow(()-> new  QuestionNotFoundException("question with Id "+quesId+" is not present"));
		updateQues.setQuestion(questionDto.getQuestion());
		updateQues.setImage(questionDto.getImage());
		updateQues.setAnswer(questionDto.getAnswer());
		updateQues.setGivenAnswer(questionDto.getGivenAnswer());
		updateQues.setOption1(questionDto.getOption1());
		updateQues.setOption2(questionDto.getOption2());
		updateQues.setOption3(questionDto.getOption3());
		updateQues.setOption4(questionDto.getOption4());
		 Questions saveqQuestions = this.questionsRepo.save(updateQues);
		return this.questionConverter.convertToQuestionDto(saveqQuestions);
	}

	@Override
	public QuestionsDto getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		Questions questions = this.questionsRepo.findById(questionId).orElseThrow(()-> new  QuestionNotFoundException("question with Id "+questionId+" is not present"));
		return this.questionConverter.convertToQuestionDto(questions);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		// TODO Auto-generated method stub
		Questions deleteQuestions = this.questionsRepo.findById(quesId).orElseThrow(()-> new  QuestionNotFoundException("question with Id "+quesId+" is not present"));
		this.questionsRepo.delete(deleteQuestions);
	}

	@Override
	public Set<QuestionsDto> getQuestionOfQuiz(QuizDto quizDto) {
		// TODO Auto-generated method stub
		Quiz quiz = this.quizConverter.convertToquQuiz(quizDto);
		Set<Questions> questions = this.questionsRepo.findByQuiz(quiz);
		Set<QuestionsDto> questionsDtos = questions.stream().map((question)->this.questionConverter.convertToQuestionDto(question)).collect(Collectors.toSet());
return questionsDtos;
	}

	@Override
	public Questions get(Long questionId) {
		// TODO Auto-generated method stub
		Questions questions = this.questionsRepo.findById(questionId).orElseThrow(()-> new  QuestionNotFoundException("question with Id "+questionId+" is not present"));
		return questions;
	}

}
