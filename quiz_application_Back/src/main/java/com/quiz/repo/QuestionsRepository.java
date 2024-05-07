package com.quiz.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
	Set<Questions> findByQuiz(Quiz quiz);

}
