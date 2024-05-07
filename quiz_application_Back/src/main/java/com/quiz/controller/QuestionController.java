package com.quiz.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.QuestionsDto;
import com.quiz.dto.QuizDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
import com.quiz.entity.StudentQuizRecord;
import com.quiz.entity.User;
import com.quiz.service.QuestionService;
import com.quiz.service.QuizService;
import com.quiz.service.UserQuizRecordService;
import com.quiz.service.impl.QuestionServiceImpl;
import com.quiz.util.QuestionConverter;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionConverter questionConverter;
	
	@Autowired
	private UserQuizRecordService userQuizRecordService;
	
	
	@PostMapping("/")
    public ResponseEntity<QuestionsDto> addQuestion(@RequestBody QuestionsDto questionDto){
        return ResponseEntity.ok(this.questionService.addQuestion(questionDto));
         }
	
	@PutMapping("/{id}")
    public ResponseEntity<QuestionsDto> update(@RequestBody QuestionsDto questionDto,@PathVariable long id){
        return ResponseEntity.ok(this.questionService.updateQuestion(questionDto, id));

    }
	
	@GetMapping("/")
	public ResponseEntity<Set<QuestionsDto>> getAllQuestions(){
		return ResponseEntity.ok(this.questionService.getAllQuestions());
	}
	
	@GetMapping("/{quesId}")
	public ResponseEntity<QuestionsDto> getQuestion(@PathVariable Long quesId){
	 System.out.println("id from client"+quesId);
		return ResponseEntity.ok(this.questionService.getQuestion(quesId));
	}
	
	@DeleteMapping("/{quesId}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable long quesId){
		 try {
	            questionService.deleteQuestion(quesId);
	            return ResponseEntity.noContent().build();
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	}
	
	
	//get question of Quiz
		@GetMapping("/quiz/all/{quizId}")
		public ResponseEntity<Set<QuestionsDto>> getALLQuestionOfQuiz(@PathVariable long quizId){
			QuizDto quizDto=new QuizDto();
			quizDto.setQuizId(quizId);
			return new ResponseEntity<Set<QuestionsDto>>(this.questionService.getQuestionOfQuiz(quizDto),HttpStatus.OK);
		}
	
	
	//get question of Quiz as the number of question
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<QuestionsDto>> getQuestionOfQuiz(@PathVariable long quizId){
		 QuizDto quizDto = this.quizService.getQuiz(quizId);
		 System.out.println(quizDto);
	        Set<QuestionsDto> questionsDtos = this.questionService.getQuestionOfQuiz(quizDto);
	        System.out.println(questionsDtos);
	        List<QuestionsDto> list=new ArrayList(questionsDtos);
	        System.out.println("1-"+list);
	        if(list.size() > Integer.parseInt(quizDto.getNumberOfquestion())){
	            list=list.subList(0,Integer.parseInt(quizDto.getNumberOfquestion()));
	        }
	        System.out.println("2-"+list);
	        list.forEach((q)->{
	            q.setAnswer("");
	        });
	        Collections.shuffle(list);
	        System.out.println("3-"+list);
	        return ResponseEntity.ok(list);
	}
	
	
	//evall quiz
	@PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Questions> questions){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        System.out.println("user is "+user.getUserId());
		System.out.println(questions);
	       int  marksGot=0;
	        int correctAnswer=0;
	       int  attempted=0;
	       Quiz quiz = questions.get(0).getQuiz();
	        for(Questions q: questions){
	            //single question
	      Questions question=this.questionService.get(q.getQuesId());
	      if(question.getAnswer().equals(q.getGivenAnswer())){
	          //correct
	          correctAnswer++;


	          double markSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMark())/questions.size();
	            marksGot+=markSingle;
	      }
	      if(q.getGivenAnswer()!=null ){
	          attempted++;
	          System.out.println(attempted);
	      }



	        };
	        Map<String, Object> map=Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted);
	       StudentQuizRecord studentQuizRecord=new StudentQuizRecord();
	       studentQuizRecord.setAttempted(attempted);
	       studentQuizRecord.setCorrectAnswer(correctAnswer);
	       studentQuizRecord.setMarksGot(marksGot);
	       studentQuizRecord.setQuizName(quiz.getTitle());
	       
	       studentQuizRecord.setNoOfQuestion(Integer.parseInt(quiz.getNumberOfquestion()));
	       studentQuizRecord.setCategoryName(quiz.getCategory().getTitle());
	       studentQuizRecord.setUserId(user.getUserId());
	        this.userQuizRecordService.addStudentRecord(studentQuizRecord);
	        return ResponseEntity.ok(map);
	
	}

}
