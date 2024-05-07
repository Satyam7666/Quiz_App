package com.quiz.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.CategoryDto;
import com.quiz.entity.Category;
import com.quiz.exception.CategoryNotFoundException;

import com.quiz.repo.CategoryRepo;
import com.quiz.service.CategoryService;
import com.quiz.util.CategoryConverter;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private CategoryConverter categoryConverter;
	


	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = this.categoryConverter.convertToCategory(categoryDto);
		Category saveCategory = this.categoryRepo.save(category);
		return this.categoryConverter.convertToCategoryDto(saveCategory);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,long cId) {
		// TODO Auto-generated method stub
		Category updateCategory = this.categoryRepo.findById(cId).orElseThrow(()-> new CategoryNotFoundException("Category with CategoryId "+cId+" is Not present"));
		updateCategory.setTitle(categoryDto.getTitle());
		updateCategory.setDescription(categoryDto.getDescription());
		 Category saveCategory = this.categoryRepo.save(updateCategory);
		 return this.categoryConverter.convertToCategoryDto(saveCategory);
	}

	@Override
	public Set<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		
	List<Category> categories = this.categoryRepo.findAll();
	System.out.println("CAtegories");
	System.out.println(categories);
 Set<CategoryDto> categoryDtos = categories.stream().map((category)->this.categoryConverter.convertToCategoryDto(category)).collect(Collectors.toSet());
	
 System.out.println("Category Dto");
 System.out.println(categoryDtos);
 return  categoryDtos;
	}

	@Override
	public CategoryDto getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category with CategoryId "+categoryId+" is Not present"));
	return this.categoryConverter.convertToCategoryDto(category);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category deleteCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category with CategoryId "+categoryId+" is Not present"));
		this.categoryRepo.delete(deleteCategory);
	}

}
