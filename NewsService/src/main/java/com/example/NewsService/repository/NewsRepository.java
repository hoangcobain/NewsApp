package com.example.NewsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.NewsService.entity.News;


@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
	@Query(value = "select * from news where title = :title", nativeQuery = true)
	public List<News> getNewsByTitle(@Param(value = "title") String title);
}