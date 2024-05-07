package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.StudentQuizRecordDto;
import com.quiz.entity.StudentQuizRecord;
import com.quiz.entity.User;
import com.quiz.service.UserQuizRecordService;

@RestController
@RequestMapping("/studentRecord")
@CrossOrigin("*")
public class StudentQuizRecordController {
	
	@Autowired
	private UserQuizRecordService quizRecordService;
	
@GetMapping("/")
public ResponseEntity<List<StudentQuizRecord>> getAllRecords(){
	 
	return new ResponseEntity<List<StudentQuizRecord>>(this.quizRecordService.getAllRecords(),HttpStatus.OK);
}

@GetMapping("/{userId}")
public ResponseEntity<List<StudentQuizRecord>> getAllRecords(@PathVariable long userId){
	 
	return new ResponseEntity<List<StudentQuizRecord>>(this.quizRecordService.getRecordByUserId(userId),HttpStatus.OK);
}

}
