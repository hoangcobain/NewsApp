package com.example.CallService.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String thumbnail;
	private String shortdescription;
	private String content;
	private int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public News(int id, String title, String thumbnail, String shortdescription, String content, int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortdescription = shortdescription;
		this.content = content;
		this.categoryId = categoryId;
	}

	public News(int id) {
		super();
		this.id = id;
	}

	public News() {
		super();
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", shortdescription="
				+ shortdescription + ", content=" + content + ", categoryId=" + categoryId + "]";
	}

}
