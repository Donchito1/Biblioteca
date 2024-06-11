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
public class usuarios {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id; 
	
	@Getter
	@Setter
	@Nullable
	private String username;
	
	@Getter
	@Setter
	@Nullable
	private String password;
	
	@Getter
	@Setter
	@Nullable
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
