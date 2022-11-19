package com.example.CommentService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CommentService.entity.Comment;
import com.example.CommentService.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	@Transactional
	public Comment addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

	@Override
	public String deleteComment(int commentId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(commentId);
		return "xoa thanh cong id" + commentId;
	}

	@Override
	public Comment updateComment(Comment comment) {
		Comment comment2 = commentRepository.saveAndFlush(comment);
		return comment2;
	}

	@Override
	public Comment getCommentById(int id) {
		Comment comment = commentRepository.findById(id).get();
		return comment;
	}

	@Override
	public List<Comment> getListComment() {
		List<Comment> dsComment = commentRepository.findAll();
		return dsComment;
	}
	
}
