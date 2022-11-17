package com.example.CommentService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CommentService.entity.Comment;


@Service
public interface CommentService {

	public Comment addComment(Comment comment);

	public String deleteComment(int commentId);

	public Comment updateComment(Comment comment);

	public Comment getCommentById(int id);

	public List<Comment> getListComment();
}
