package com.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Category;
import com.quiz.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{

	public List<Quiz> findByCategory(Category category);

    public List<Quiz> findByActive(Boolean b);
    public  List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
