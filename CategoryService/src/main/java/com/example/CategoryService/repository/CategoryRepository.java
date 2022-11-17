package com.example.CategoryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CategoryService.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query(value = "select * from category where name = :name", nativeQuery = true)
	public List<Category> getCategoryByName(@Param(value = "name") String name);
}