package com.example.CommentService.controller;

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

import com.example.CommentService.entity.Comment;
import com.example.CommentService.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("")
	public Comment addComment(@RequestBody Comment comment) {
		commentService.addComment(comment);
		return comment;
	}

	@DeleteMapping("/{id}")
	public String deleteComment(@PathVariable int commentId) {
		commentService.deleteComment(commentId);
		return "xoá thành công id" + commentId;
	}

	@PostMapping("/update")
	public Comment updateComment(@RequestBody Comment comment) {
		Comment comment2 = commentService.updateComment(comment);
		return comment2;
	}

	@GetMapping("/{id}")
	public Comment getCommentById(@PathVariable int commentId) {
		Comment comment = commentService.getCommentById(commentId);
		return comment;
	}

	@GetMapping("")
	public List<Comment> getListComment() {
		List<Comment> dsComment = commentService.getListComment();
		return dsComment;
	}

}
