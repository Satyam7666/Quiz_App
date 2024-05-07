package com.quiz.controller;

import java.util.LinkedHashSet;
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

import com.quiz.dto.CategoryDto;
import com.quiz.entity.Category;

import com.quiz.service.CategoryService;
import com.quiz.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	 @PostMapping("/")
	 public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
	        CategoryDto categoryDto1 = this.categoryService.addCategory(categoryDto);
	        System.out.println(categoryDto1);
	        return new ResponseEntity<CategoryDto>(categoryDto1,HttpStatus.CREATED);

	    }


	   
	    @GetMapping("/{categoryId}")
	    public  ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Long categoryId){
	        return new ResponseEntity<CategoryDto>(this.categoryService.getCategory(categoryId),HttpStatus.OK);
	    }


	    //get all category
	    @GetMapping("/")
	    public  ResponseEntity<Set<CategoryDto>> getCategories(){
	    	
	    	Set<CategoryDto> categoriesDtos = this.categoryService.getCategories();
	    	System.out.println(categoriesDtos);
	        return new ResponseEntity<Set<CategoryDto>>(categoriesDtos,HttpStatus.OK);

	    }


	    //update Category
	    @PutMapping("/{cId}")
	    public  ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable int cId){
	        return new ResponseEntity<CategoryDto>(this.categoryService.updateCategory(categoryDto, cId),HttpStatus.OK);
	    }

	    //Delete category
	    @DeleteMapping("/{categoryId}")
	    public  void deleteCategory(@PathVariable("categoryId") Long categoryId){
	        this.categoryService.deleteCategory(categoryId);
	        
	        
	    }


}
