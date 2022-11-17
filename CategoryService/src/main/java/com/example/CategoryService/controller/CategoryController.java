package com.example.CategoryService.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CategoryService.entity.Category;
import com.example.CategoryService.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("")
	public Category addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return category;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		categoryService.deleteCategory(id);
		return "xoá thành công id" + id;
	}

	@PostMapping("/update")
	public Category updateCustomer(@RequestBody Category Category) {
		Category Category2 = categoryService.updateCategory(Category);
		return Category2;
	}

	@GetMapping("/{id}")
	public Category getCustomerById(@PathVariable int id) {
		Category Category = categoryService.getCategoryById(id);
		return Category;
	}

	@GetMapping("")
	public List<Category> getListCategory() {
		List<Category> dsCategory = categoryService.getListCategory();
		return dsCategory;
	}
	
	@GetMapping("name/{name}")
	public List<Category> getCustomerByName(@PathVariable String name) {
		List<Category> dsCategory = categoryService.getCategoryByName(name);
		return dsCategory;
	}


}
