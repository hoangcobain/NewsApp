package com.example.NewsService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NewsService.entity.News;


@Service
public interface NewsService {

	public News addnews(News news);

	public String deleteNews(int id);

	public News updateNews(News news);

	public News getNewsById(int id);

	public List<News> getListNews();
	
	public List<News>  getNewsByTitle(String title);
}
