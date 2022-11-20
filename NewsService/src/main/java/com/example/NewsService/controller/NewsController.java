package com.example.NewsService.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

import com.example.NewsService.entity.News;
import com.example.NewsService.service.NewsService;


@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@PostMapping("")
	@CachePut(value = "new", key = "#news.id")
	public News addNews(@RequestBody News news) {
		newsService.addnews(news);
		return news;
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "new", key = "#id")
	public String delete(@PathVariable int id) {
		newsService.deleteNews(id);
		return "xoá thành công id" + id;
	}

	@PostMapping("/update")
	public News updateCustomer(@RequestBody News news) {
		News news2 = newsService.updateNews(news);
		return news2;
	}

	@GetMapping("/{id}")
	@Cacheable(value = "new", key = "#id")
	public News getNewsById(@PathVariable int id) {
		News news = newsService.getNewsById(id);
		return news;
	}

	@GetMapping("")
	public List<News> getListNews() {
		List<News> dsNews = newsService.getListNews();
		return dsNews;
	}
	
	@GetMapping("title/{title}")
	public List<News> getCNewsByTitle(@PathVariable String title) {
		List<News> dsNews = newsService.getNewsByTitle(title);
		return dsNews;
	}

}
