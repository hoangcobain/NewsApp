package com.example.CallService.entity;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String thumbnail;
	private String shortdescription;
	private String content;
	private Category category;

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

	@Override
	public String toString() {
		return "NewsCategory [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", shortdescription="
				+ shortdescription + ", content=" + content + ", category=" + category + "]";
	}

	public NewsCategory(int id, String title, String thumbnail, String shortdescription, String content,
			Category category) {
		super();
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortdescription = shortdescription;
		this.content = content;
		this.category = category;
	}

	public NewsCategory() {
		super();
	}

	
}
