package com.example.CommentService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "comments")
@Entity
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1114893921105405569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "content", columnDefinition = "text")
	private String content;

	@Column(name = "user_id")
	private int user_id;

	@Column(name = "new_id")
	private int new_id;

	public Comment(int id, String content, int user_id, int new_id) {
		super();
		this.id = id;
		this.content = content;
		this.user_id = user_id;
		this.new_id = new_id;
	}

	public Comment(int id) {
		super();
		this.id = id;
	}

	public Comment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getNew_id() {
		return new_id;
	}

	public void setNew_id(int new_id) {
		this.new_id = new_id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", user_id=" + user_id + ", new_id=" + new_id + "]";
	}

}
