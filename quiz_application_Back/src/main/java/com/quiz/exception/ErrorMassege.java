package com.quiz.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMassege {
	
	private HttpStatus httpStatus;
	private String messageString;
	
	
	

}
