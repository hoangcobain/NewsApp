package com.example.CategoryService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CategoryService.entity.Category;


@Service
public interface CategoryService {

	public Category addCategory(Category category);

	public String deleteCategory(int id);

	public Category updateCategory(Category category);

	public Category getCategoryById(int id);

	public List<Category> getListCategory();
	
	public List<Category> getCategoryByName(String name);
}
