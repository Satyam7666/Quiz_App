package com.quiz.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz.dto.CategoryDto;
import com.quiz.dto.UserDto;
import com.quiz.entity.Category;
import com.quiz.entity.User;

@Component
public class CategoryConverter {
	//convert User to USerDto
			public CategoryDto convertToCategoryDto(Category category) {
				CategoryDto categoryDto=new CategoryDto();
				
				if(category!=null) {
					BeanUtils.copyProperties(category, categoryDto);
				}
				return categoryDto;
			}
			
			//convert UserDto to USer
				public Category convertToCategory(CategoryDto categoryDto) {
					Category category=new Category();
					
					if(categoryDto!=null) {
						BeanUtils.copyProperties(categoryDto, category);
						
					}
					return category;
				}
}
