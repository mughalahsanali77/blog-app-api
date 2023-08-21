package com.blog.app.services;

import java.util.List;

import com.blog.app.payloads.CategoryDto;

public interface CategoryService {
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);
	void deleteCategory(Long categoryId);
	CategoryDto getCategory(Long categoryId);
	List<CategoryDto> getCategories();
	
}
