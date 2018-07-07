package com.footballWorld.pojo;

import org.springframework.stereotype.Component;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private String photoUrl;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
   
	public User(String username, String password, String email) {
		this(username,password);
		this.email = email;
	}
     
	public User(String username, String email, String password, String photoUrl) {
		this(username,password,email);
		this.photoUrl = photoUrl;
	}
	
	public User(int id,String username, String email, String password, String photoUrl) {
		this(username,email,password,photoUrl);
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
}
