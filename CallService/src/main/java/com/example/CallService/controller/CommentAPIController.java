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

import com.example.CallService.entity.Comment;
import com.example.CallService.entity.News;
import com.example.CallService.entity.NewsUserComment;
import com.example.CallService.entity.Role;
import com.example.CallService.entity.User;
import com.example.CallService.entity.UserRole;

@RestController
@RequestMapping("/api")
public class CommentAPIController {

	String urlComment = "http://localhost:8085/comment";

	@GetMapping("/comment/{id}")
	public NewsUserComment getComment(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Comment> response = restTemplate.getForEntity(urlComment + "/" + id, Comment.class);

		ResponseEntity<User> responseUser = restTemplate
				.getForEntity(urlComment + "/" + response.getBody().getUser_id(), User.class);

		ResponseEntity<News> responseNews = restTemplate.getForEntity(urlComment + "/" + response.getBody().getNew_id(),
				News.class);

		NewsUserComment newsUserComment = new NewsUserComment(response.getBody().getId(),
				response.getBody().getContent(), responseUser.getBody(), responseNews.getBody());

		return newsUserComment;
	}

	@GetMapping("/comment")
	public List<NewsUserComment> getAllComment() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<NewsUserComment>> responseEntity = restTemplate.exchange(urlComment, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<NewsUserComment>>() {
				});
		List<NewsUserComment> listUserComments = responseEntity.getBody();

		ResponseEntity<List<Comment>> responseComment = restTemplate.exchange(urlComment, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comment>>() {
				});
		List<Comment> comments = responseComment.getBody();

		List<NewsUserComment> newArrayList = new ArrayList<NewsUserComment>();

		for (Comment comment : comments) {
			User user = new User();
			News news = new News();

			user = restTemplate.getForObject(urlComment + "/" + comment.getUser_id(), User.class);
			news = restTemplate.getForObject(urlComment + "/" + comment.getNew_id(), News.class);

			NewsUserComment newsUserComment = new NewsUserComment();
			newsUserComment = restTemplate.getForObject(urlComment + "/" + comment.getId(), NewsUserComment.class);

			newsUserComment.setUser(user);
			newsUserComment.setNews(news);

			newArrayList.add(newsUserComment);
		}

		return newArrayList;
	}

	@DeleteMapping("/comment/{id}")
	public String deleteComment(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		restTemplate.delete(urlComment + "/" + id, params);
		return "Xóa Thành Công";
	}

	@PostMapping("/comment")
	public String createComment(@RequestBody Comment comment) {
		RestTemplate restTemplate = new RestTemplate();
		Comment response = restTemplate.postForObject(urlComment, comment, Comment.class);
		return "thêm thành công";
	}

}
