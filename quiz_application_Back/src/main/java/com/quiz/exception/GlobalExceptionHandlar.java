package com.quiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandlar {
	
	@ExceptionHandler
	public ResponseEntity<ErrorMassege> handleUserException(UserNotFoundException ex,WebRequest request) {
		ErrorMassege em=new ErrorMassege(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMassege> handleCategoryException(CategoryNotFoundException ex,WebRequest request) {
		ErrorMassege em=new ErrorMassege(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMassege> handleQuizException(QuizNotFoundException ex,WebRequest request) {
		ErrorMassege em=new ErrorMassege(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMassege> handleQuestionException(QuestionNotFoundException ex,WebRequest request) {
		ErrorMassege em=new ErrorMassege(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}

}
