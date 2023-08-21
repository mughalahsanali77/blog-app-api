package com.blog.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.payloads.ApiResponse;
import com.blog.app.payloads.CategoryDto;
import com.blog.app.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto category = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
	}//end create
	
	@PutMapping("/{cid}")
	public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Long cid){
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, cid);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}//end update
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
		this.categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
	}//end delete
	
	@GetMapping("/{cid}")
	public ResponseEntity<CategoryDto> getOne(@PathVariable Long cid){
		CategoryDto getCategory = this.categoryService.getCategory(cid);
		return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.OK);
	}//end update
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll(){
		List<CategoryDto> categories = this.categoryService.getCategories();
		return  ResponseEntity.ok(categories);
	}//end update
}
