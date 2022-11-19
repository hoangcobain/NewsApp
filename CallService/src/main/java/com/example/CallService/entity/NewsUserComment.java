package com.example.CallService.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsUserComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1114893921105405569L;

	private int id;

	private String content;

	private User user;

	private News news;

	public NewsUserComment(int id, String content, User user, News news) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
		this.news = news;
	}

	public NewsUserComment(int id) {
		super();
		this.id = id;
	}

	public NewsUserComment() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "NewsUserComment [id=" + id + ", content=" + content + ", user=" + user + ", news=" + news + "]";
	}

}
