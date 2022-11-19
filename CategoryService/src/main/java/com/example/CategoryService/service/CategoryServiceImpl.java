package com.example.CategoryService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CategoryService.entity.Category;
import com.example.CategoryService.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public String deleteCategory(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		return "xoa thanh cong id" + id;
	}

	@Override
	public Category updateCategory(Category category) {
		Category category2 = categoryRepository.saveAndFlush(category);
		return category2;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = categoryRepository.findById(id).get();
		return category;
	}

	@Override
	public List<Category> getListCategory() {
		List<Category> dscategory = categoryRepository.findAll();
		return dscategory;
	}


	@Override
	public List<Category> getCategoryByName(String name) {;
		return categoryRepository.getCategoryByName(name);
	}
}
