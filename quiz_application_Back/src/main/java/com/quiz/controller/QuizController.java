package com.quiz.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.QuizDto;
import com.quiz.entity.Category;
import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;
import com.quiz.service.impl.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	
	 //add quiz
    @PostMapping("/")
    public ResponseEntity<QuizDto> addQuiz(@RequestBody QuizDto quizDto){
    	System.out.println("inside Controller"+quizDto);
        return new ResponseEntity<QuizDto>(this.quizService.addQuiz(quizDto),HttpStatus.CREATED);

    }


//Update Quiz
    @PutMapping("/{qId}")
    public ResponseEntity<QuizDto> updateQuiz(@RequestBody QuizDto quizDto,@PathVariable int qId){
    	System.out.println("controller"+quizDto);
        return new ResponseEntity<QuizDto>(this.quizService.updateQuiz(quizDto,qId),HttpStatus.OK);

    }

    //get quiz
    @GetMapping("/")
    public  ResponseEntity<Set<QuizDto>> quizess(){
    	Set<QuizDto> quizzes = this.quizService.getQuizzes();
        return  ResponseEntity.ok(quizzes);
    }


    //get quiz by id
    @GetMapping("/{qid}")
    public  ResponseEntity<QuizDto> quiz(@PathVariable("qid") Long qid){
        return new ResponseEntity<QuizDto>(this.quizService.getQuiz(qid),HttpStatus.OK);
    }

    
  //delete quiz
    @DeleteMapping("/{qid}")
    public ResponseEntity<Void> delete(@PathVariable("qid") Long qid){
        try {
            quizService.delteQuiz(qid);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    //quizzes of category
    @GetMapping("/category/{cId}")
    public ResponseEntity<List<QuizDto>> getQuizeesOfCategory(@PathVariable long cId) {
    	Category category=new Category();
    	category.setCatId(cId);
    	return new ResponseEntity<List<QuizDto>>(this.quizService.getQuizzesOfCategory(category),HttpStatus.OK);
		
	}
    
    
    //get Active Quizzess
    
    @GetMapping("/active")
    public ResponseEntity<List<QuizDto>> getActiveQuizzess(){
    	return new ResponseEntity<List<QuizDto>>(this.quizService.getActiveQuizzess(),HttpStatus.OK);
    }
    
    //get Active quizzess of category
    @GetMapping("/category/active/{cId}")
    public ResponseEntity<List<QuizDto>> getActiveQuizessOfCategory(@PathVariable long cId){
    	Category category=new Category();
    	category.setCatId(cId);
    	
    	return new ResponseEntity<List<QuizDto>>(this.quizService.getActiveQuizzessOfCategory(category),HttpStatus.OK);
    	
    }

}
