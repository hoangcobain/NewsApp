package com.example.CallService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CallService.entity.Category;
import com.example.CallService.entity.News;
import com.example.CallService.entity.NewsCategory;

import io.vavr.collection.List;

@RestController
@RequestMapping("/api")
public class NewsAPIController {
	String urlNews = "http://localhost:8081/news";
	String urlCategory = "http://localhost:8082/category";

//	News
	@GetMapping("/news/{id}")
	public NewsCategory getNews(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<News> response = restTemplate.getForEntity(urlNews + "/" + id, News.class);

		ResponseEntity<Category> responseCategory = restTemplate
				.getForEntity(urlCategory + "/" + response.getBody().getCategoryId(), Category.class);

		NewsCategory newsCategory = new NewsCategory(response.getBody().getId(), response.getBody().getTitle(),
				response.getBody().getThumbnail(), response.getBody().getShortdescription(),
				response.getBody().getContent(), responseCategory.getBody());
		return newsCategory;
	}

	@GetMapping("/news")
	public ResponseEntity<String> getAllNew() {
		RestTemplate restTemplate = new RestTemplate();		
//		ResponseEntity<News[]> response = restTemplate.getForEntity(urlNews, News[].class);
//		News[] newsCategories= response.getBody();
//		return newsCategories;
		
//		ResponseEntity<News> response = restTemplate.getForEntity(urlNews, News.class);
//		ResponseEntity<Category> responseCategory = restTemplate
//				.getForEntity(urlCategory + "/" + response.getBody().toString(), Category.class);
//		
//		NewsCategory[] newsCategory =response.getBody().getId(), response.getBody().getTitle(),
//				response.getBody().getThumbnail(),response.getBody().getShortdescription(), 
//				response.getBody().getContent(), responseCategory.getBody();
//		return newsCategory;
		
//		NewsCategory newsCategories = response.getBody();
//		return newsCategories;
		ResponseEntity<String> result = restTemplate.getForEntity(urlNews, String.class);
		return result;
		
//		ResponseEntity<News> result = restTemplate.getForEntity(urlNews, News.class);
		
//		ResponseEntity<Category> responseCategory = restTemplate
//				.getForEntity(urlCategory + "/" + result.getBody().getCategoryId(), Category.class);
//		
//		NewsCategory newsCategories= new NewsCategory(result.getBody().getId(), result.getBody().getTitle(),
//				result.getBody().getThumbnail(),result.getBody().getShortdescription(), 
//				result.getBody().getContent(), responseCategory.getBody());
//		return newsCategories;
		
//		NewsCategory newsCategory = new NewsCategory(result.getBody().getId(), result.getBody().getTitle(),
//				result.getBody().getThumbnail(),result.getBody().getShortdescription(), 
//				result.getBody().getContent(), responseCategory.getBody());
		}

	@DeleteMapping("/news/{id}")
	public String deleteNews(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		restTemplate.delete(urlNews + "/" + id, params);
		return "Xóa Thành Công";
	}

	@PostMapping("/news")
	public String createNews(@RequestBody News news) {
		RestTemplate restTemplate = new RestTemplate();
		News response = restTemplate.postForObject(urlNews, news, News.class);
		return "thêm thành công";

	}

	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Category> response = restTemplate.getForEntity(urlCategory + "/" + id, Category.class);
		return response.getBody();
	}

}
