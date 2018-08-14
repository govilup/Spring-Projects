package com.springbatch.entity;


public class AnimeDTO {

	private String id;
	private String title;
	private String description;

	public AnimeDTO() {
	}

	public AnimeDTO(String string, String title, String description) {
		this.id = string;
		this.title = title;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AnimeDTO [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

}
