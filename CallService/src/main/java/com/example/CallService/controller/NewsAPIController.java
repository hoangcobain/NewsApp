package com.example.CallService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
	public List<NewsCategory> getAllNew() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<NewsCategory>> responseEntity = restTemplate.exchange(urlNews, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<NewsCategory>>() {
				});
		List<NewsCategory> newsCategories = responseEntity.getBody();

		ResponseEntity<List<News>> responseNews = restTemplate.exchange(urlNews, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<News>>() {
				});
		List<News> news = responseNews.getBody();
		List<NewsCategory> newArrayList = new ArrayList<NewsCategory>();
		for (News news2 : news) {
			Category category = new Category();
			category = restTemplate.getForObject(urlCategory + "/" + news2.getCategoryId(), Category.class);
			NewsCategory newsCategory = new NewsCategory();
			newsCategory = restTemplate.getForObject(urlNews + "/" + news2.getId(), NewsCategory.class);
			newsCategory.setCategory(category);
			newArrayList.add(newsCategory);
		}
		return newArrayList;

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

//	Category
	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Category> response = restTemplate.getForEntity(urlCategory + "/" + id, Category.class);
		return response.getBody();
	}

}
