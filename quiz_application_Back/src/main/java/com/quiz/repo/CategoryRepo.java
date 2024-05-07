package com.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
