package com.quiz.service;

import java.util.Set;

import com.quiz.dto.CategoryDto;
import com.quiz.entity.Category;


public interface CategoryService {
	
	 public CategoryDto addCategory(CategoryDto category);
	    public CategoryDto updateCategory(CategoryDto category,long cId);

	    public Set<CategoryDto> getCategories();

	    public CategoryDto getCategory(Long categoryId);

	    public  void  deleteCategory(Long categoryId);

}
