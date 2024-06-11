package com.biblioteca.entities;

import org.springframework.data.annotation.Id;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Book {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	
	@Getter
	@Setter
	@Nullable
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Getter
	@Setter
	@Nullable
	private String author;
	
	@Getter
	@Setter
	@Nullable
	private String isbn;
}
