package com.examples.rest.webservices.restfulwebservices.user.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	@Positive
	private Integer id;
	
	@NotNull
	private String message;
	
	public Post(){
		
	}

	public Post(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", message=" + message + "]";
	}
}
