package com.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.dto.StudentQuizRecordDto;
import com.quiz.entity.StudentQuizRecord;
import com.quiz.entity.User;

public interface UserQuizRecordRepo extends JpaRepository<StudentQuizRecord, Long>{
  
   List<StudentQuizRecord> findByUserId(long userId);
	
//	 @Query("SELECT new com.quiz.entity.StudentQuizRecordDto(q.quizName, q.category.categoryName) FROM StudentQuizRecord sqr JOIN sqr.quiz q WHERE sqr.user.userId = ?1")
//	    List<StudentQuizRecord> findQuizDetailsByUserId(long userId);
   }
